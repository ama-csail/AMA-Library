package edu.mit.dig.ama.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static android.content.Context.ACCESSIBILITY_SERVICE;

/**
 * A collection of core functionality for creating accessible features
 * within an Android application, provided as static methods
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 0.0.1
 */
public class AMA {

    //----------------------------------------------------------------------------------------------
    // region Vision
    // Methods that may be useful for vision-related capabilities
    //----------------------------------------------------------------------------------------------

    /**
     * Checks to see if TalkBack is installed (note that this is the Google version of TalkBack)
     * @param context The calling activity
     * @return true if TalkBack is installed on this device
     */
    public static boolean isTalkBackInstalled(Context context) {

        List<ApplicationInfo> packages;
        PackageManager pm;

        pm = context.getPackageManager();
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(Constants.TALKBACK_PACKAGE))
                return true;
        }
        return false;

    }

    /**
     * Checks to see if TalkBack is currently enabled
     * @param context The calling activity
     * @return true if TalkBack is enabled
     */
    public static boolean isTalkBackEnabled(Context context) {

        AccessibilityManager am = (AccessibilityManager) context.getSystemService(ACCESSIBILITY_SERVICE);
        return am.isEnabled();

    }

    /**
     * Checks to see if explore by touch (provided via TalkBack) is currently enabled
     * @param context The calling activity
     * @return true if explore by touch is enabled
     */
    public static boolean isExploreByTouchEnabled(Context context) {

        AccessibilityManager am = (AccessibilityManager) context.getSystemService(ACCESSIBILITY_SERVICE);
        return am.isTouchExplorationEnabled();

    }

    /**
     * Returns an Intent that will open Google Play Store, and link to the TalkBack app page
     * @return The intent that will open the play store at the TalkBack page
     */
    public static Intent getTalkBackPlayIntent() {

        return new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + Constants.TALKBACK_PACKAGE));

    }

    /**
     * Assesses whether the app name is accessible (no emojis or unspeakable characters)
     * @param context The context that wishes to know the results
     * @return True if this app has an accessible name
     */
    public static boolean isHumanReadable(Context context) {

        PackageManager packageManager = context.getPackageManager();
        String name = null;

        try {
            ApplicationInfo applicationInfo = packageManager
                    .getApplicationInfo(context.getApplicationInfo().packageName, 0);
            if(applicationInfo != null) {
                name = packageManager.getApplicationLabel(applicationInfo).toString();
            }
        } catch (PackageManager.NameNotFoundException ignored) {}

        return isStringAccessible(name);

    }

    /**
     * Disables any TalkBack interaction from the given views. This method should only be
     * used to disable TalkBack on decorations
     * @param views The views to remove audio prompts from
     */
    public static void disableAudioPrompts(View... views) {
        for(View v : views) {
            v.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
        }
    }

    /**
     * Enables TalkBack interaction from the given view.
     * @param views The views to add audio prompts to
     */
    public static void enableAudioPrompts(View ... views) {
        for(View v : views) {
            v.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);
        }
    }

    /**
     * Switches the content view of this activity to another layout when TalkBack is enabled
     * Note that you may need multiple TalkBack layouts in different screen type folders, in
     * case the user has an unexpected screen size or is in, say, landscape mode.
     * @param activity The activity to set an alternative layout
     * @param layout The layout resource for the accessible layout
     */
    public static void setTalkBackLayout(Activity activity, @LayoutRes int layout) {
        if (isTalkBackEnabled(activity)) {
            activity.setContentView(layout);
        }
    }

    /**
     * Causes TalkBack to speak the given string out loud
     * @param activity The activity to call TalkBack from
     * @param message The message to have TalkBack speak out loud
     */
    public static void speak(Activity activity, String message) {
        activity.findViewById(android.R.id.content).announceForAccessibility(message);
    }

    /**
     * Changes the font of each given view to the given font
     * @param size The new font size of each view TODO: What units?
     * @param views A list of views to increase the size of
     */
    public static void setFont(float size, View ... views) {
        for(View v : views) {
            if(v instanceof TextView) {
                ((TextView) v).setTextSize(size);
            }
        }
    }

    /**
     * Increases the margin of each given view by the given amount
     * @param space The additional margin of each view
     * @param views A list of views to increase the spacing of
     */
    public static void increaseSpacing(int space, List<View> views) {
        for(View v : views) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.setMargins(params.leftMargin, params.topMargin + space, params.rightMargin, params.bottomMargin);
            v.setLayoutParams(params);
        }
    }

    /**
     * Assesses whether the given colors satisfy the 4.5:1 ratio for contrast
     * Uses resources from W3 in calculations, especially from the following links:
     * https://www.w3.org/TR/2008/REC-WCAG20-20081211/#relativeluminancedef
     * https://www.w3.org/TR/2008/REC-WCAG20-20081211/#contrast-ratiodef
     * @param context The calling application
     * @param colorForeground The color resource in the front of the background
     * @param colorBackground The color resource of the background
     */
    public static boolean statisfiesContrast(Context context, @ColorRes int colorForeground, @ColorRes int colorBackground) {
        double contrast = getContrast(context, colorForeground, colorBackground);
        return contrast >= 4.5;
    }

    /**
     * Returns the contrast of the given foreground and background colors, ranging from 1 to 21
     * Uses resources from W3 in calculations, especially from the following links:
     * https://www.w3.org/TR/2008/REC-WCAG20-20081211/#relativeluminancedef
     * https://www.w3.org/TR/2008/REC-WCAG20-20081211/#contrast-ratiodef
     * @param context The calling application
     * @param colorForeground The color resource in the front of the background
     * @param colorBackground The color resource of the background
     */
    public static double getContrast(Context context, @ColorRes int colorForeground, @ColorRes int colorBackground) {

        // Get the RGB values of each color
        // This integer represents 0xAARRGGBB
        int color1 = context.getResources().getColor(colorForeground);
        int color2 = context.getResources().getColor(colorBackground);
        int[] oneARGB = new int[] {(0x11000000 & color1) >> 6, (0x110000 & color1) >> 4, (0x1100 & color1) >> 2, 0x11 & color1};
        int[] twoARGB = new int[] {(0x11000000 & color2) >> 6, (0x110000 & color2) >> 4, (0x1100 & color2) >> 2, 0x11 & color2};

        // Calculation for relative luminance, as defined by https://www.w3.org/TR/2008/REC-WCAG20-20081211/#contrast-ratiodef
        float oneL = calcLuminance(oneARGB);
        float twoL = calcLuminance(twoARGB);

        return oneL > twoL ? (oneL + 0.05) / (twoL + 0.05) : (twoL + 0.05) / (oneL + 0.05);

    }

    /**
     * Calculates the luminance of an ARGB color, as given by the equations at
     * https://www.w3.org/TR/2008/REC-WCAG20-20081211/#relativeluminancedef
     * @param comps The ARGB components of the color (from 0 to 255)
     *              comps[0] = alpha, [1] = red, [2] = green, [3] = blue
     * @return the luminance to be used in contrast calculations
     */
    private static float calcLuminance(int[] comps) {

        float RSRGB = comps[1] / 255f;
        float GSRGB = comps[2] / 255f;
        float BSRGB = comps[3] / 255f;
        float R = RSRGB <= 0.03928 ? RSRGB / 12.92f : (float) Math.pow((RSRGB + 0.055) / 1.055f, 2.4);
        float G = GSRGB <= 0.03928 ? GSRGB / 12.92f : (float) Math.pow((GSRGB + 0.055) / 1.055f, 2.4);
        float B = BSRGB <= 0.03928 ? BSRGB / 12.92f : (float) Math.pow((BSRGB + 0.055) / 1.055f, 2.4);
        float luminance = 0.2126f * R + 0.7152f * G + 0.0722f * B;

        return luminance;

    }

    //endregion

    //----------------------------------------------------------------------------------------------
    // region Voice
    // Methods that may be useful for voice-related capabilities
    //----------------------------------------------------------------------------------------------

    /**
     * Check if navigation is speech-only
     * @param view the view to check upon
     */
    public static void checkNavigationOnlySpeech(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Get the current available input methods from the input field
     * @param view the view to check upon
     * @param activity the Activity for specific input field
     */
    public static void getInputMethodsInInputFields(View view, Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Set the text input available for all speech-driven inputs
     * @param view the view to check upon
     * @param activity the Activity for specific input field
     */
    public static void setTextInputAvailable(View view, Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Returns true if the input string is deemed accessible, and can
     * be read reliably by TalkBack TODO: Make this better
     * Essentially checks if a string is composed of solely letters,
     * punctuation, whitespace, and numbers (no special characters such as
     * emojis)
     * @param input The string to test accessibility on
     * @return true if input is accessible
     */
    public static boolean isStringAccessible(String input) {

        if(input != null) {

            input = input.trim();
            return input.matches("[A-Za-z0-9,;'\".?!\\s]+");

        } else {
            return false;
        }

    }

    //endregion

    //----------------------------------------------------------------------------------------------
    // region Motor Skills
    // Methods that may be useful for mobility-related capabilities
    //----------------------------------------------------------------------------------------------

    /**
     * Sets the NavType of an Activity
     * @param activity The Activity to set the NavType on
     * @param type The NavType to set
     *                 - NavType.TABS
     *                 - NavType.TABS+SWIPE
     *                 - NavType.SWIPE+TITLE
     *                 - NavType.DROPDOWN
     */
    public static void setNavType(Activity activity, NavType type) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets the NavTypes of an Activity
     * @param activity The Activity to set the NavType on
     * @return an Arraylist of NavTypes
     */
    public static ArrayList<NavType> getNavTypes(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * THIS METHOD WILL BE INTENSE - REQUIRES DESIGN OF KEYBOARD INPUT TO MAKE
     * CUSTOM AccessibilityHandlers
     * Sets the Activity to be keyboard accessible
     * @param activity The Activity to set
     */
    public static void setKeyboardAccessible(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the a custom KeyboardAccessibilityHandler
     * @param activity The Activity to set the handler on
     * @param handler the custom handler to add
     */
    public static void setKeyboardAccessibleHandler(Activity activity, AccessibilityHandler handler) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the all taps to single taps
     * @param activity The Activity to set
     */
    public static void setActivitySingleTaps(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the grace period on all taps
     * @param activity The Activity to set
     * @param sec The number of seconds for the grace period
     */
    public static void setTapGracePeriod(Activity activity, int sec) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the all gestures to single handed gestures
     * @param activity The Activity to set
     */
    public static void setSingleHandGestures(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the input time for a View
     * @param view The View to set
     * @param sec The number of seconds for the input
     * @param disable The boolean to determine if time can be disabled
     * @param extend The boolean to determine if time can be extended
     */
    public static void setTimeInput(View view, int sec, boolean disable, boolean extend) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the minimum padding on Views in an Activity
     * @param activity The Activity to set
     * @param min The minimum number of padding (px)
     */
    public static void setMinimumPadding(Activity activity, int min) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    //endregion

    //----------------------------------------------------------------------------------------------
    // region Hearing
    // Methods that may be useful for hearing-related capabilities
    //----------------------------------------------------------------------------------------------

    /**
     * Get to the "No Audio" mode by disabling all the parts
     * that contain audio prompts
     * @param view the view to check upon
     */
    public static void getNoAudioMode(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Check if the current view contains any audio related features
     * @param view the view to check upon
     */
    public static void checkIfAudioExists(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Add visual feedback to the current view
     * Ideally, this method would be used in place of audio feedback
     * where there does not exist any non-audio feedback
     * @param view the view to check upon
     * @param activity the Activity to set feedback on
     */
    public static void addVisualFeedback(View view, Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Check if any feedback is audio-only
     * @param view the view to check upon
     */
    public static void checkFeedbackOnlySpeech(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    //endregion

    //----------------------------------------------------------------------------------------------
    // region Cognition
    // Methods that may be useful for cognition-related capabilities
    //----------------------------------------------------------------------------------------------

    /**
     * Sets the HelpMessage of a View
     * @param view The view to set the helpMessage on
     * @param helpMessage The string to set
     */
    public static void setHelpMessage(View view, String helpMessage) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets the HelpMessage of a View
     * @param view The view to get the HelpMessage on
     * @return The String HelpMessage of the view
     */
    public static String getHelpMessage(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the ActionClass of a View
     * @param activity The calling activity
     * @param view The view to set the ActionClass on
     * @param actionClass The ActionClass to set, which can be one of
     *                 - ActionClass.DEFAULT
     *                 - ActionClass.PRIMARY
     *                 - ActionClass.SUCCESS
     *                 - ActionClass.INFO
     *                 - ActionClass.WARNING
     *                 - ActionClass.DANGER
     *                 - ActionClass.LINK
     */
    public static void setActionClass(Activity activity, View view, ActionClass actionClass) {

        view.setTag(Constants.ACTION_CLASS_KEY, actionClass);

        // adjust view based on actionClass
        if(view instanceof Button) {
            view.setBackgroundResource(Constants.ACTION_BACKGROUND_COLOR.get(actionClass));
            if(actionClass != ActionClass.DEFAULT) {
                ((Button) view).setTextColor(activity.getResources().getColor(android.R.color.white));
            } else {
                ((Button) view).setTextColor(activity.getResources().getColor(android.R.color.black));
            }
        }

    }

    /**
     * Gets the ActionClass of a View
     * @param view The view to set the ActionClass on
     * @return class The ActionClass to set, which can be one of
     *                 - ActionClass.DEFAULT
     *                 - ActionClass.PRIMARY
     *                 - ActionClass.SUCCESS
     *                 - ActionClass.INFO
     *                 - ActionClass.WARNING
     *                 - ActionClass.DANGER
     *                 - ActionClass.LINK
     */
    public static ActionClass getActionClass(View view) {

        if (view.getTag(Constants.ACTION_CLASS_KEY) != null) {
            return (ActionClass) view.getTag(Constants.ACTION_CLASS_KEY);
        } else {
            return ActionClass.DEFAULT;
        }
    }

    /**
     * Gets the number of Views within an Activity, by traversing through the view hierarchy
     * Note that an activity with no views still has one view (the main content view)
     * @param activity The activity to check
     * @return the number of views
     */
    public static int getNumViews(Activity activity) {

        View topView = activity.findViewById(android.R.id.content);
        Queue<View> queue = new LinkedList<>();
        queue.add(topView);

        int viewCount = 0;

        // Iterate through view in the queue
        while (queue.size() > 0) {
            View popped = queue.remove();
            if (popped instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) popped;
                for (int i = 0; i < group.getChildCount(); i++) {
                    queue.add(group.getChildAt(i));
                }
            } else {
                viewCount++; // This is a View with no children
            }
        }

        return viewCount;

    }

    /**
     * Gets all the Views on an Activity (note that this does not include ViewGroups)
     * @param activity The activity to check
     * @return an ArrayList of views
     */
    public static List<View> getAllViews(Activity activity) {

        View topView = activity.findViewById(android.R.id.content);
        Queue<View> queue = new LinkedList<>();
        List<View> views = new ArrayList<>();
        queue.add(topView);

        // Iterate through view in the queue
        while (queue.size() > 0) {
            View popped = queue.remove();
            if (popped instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) popped;
                for (int i = 0; i < group.getChildCount(); i++) {
                    queue.add(group.getChildAt(i));
                }
            } else {
                views.add(popped);
            }
        }

        return views;

    }


    /**
     * Gets all the Strings associated with an Activity. These are the strings that
     * are currently present within TextViews in this layout
     * @param activity The activity to check
     * @return an ArrayList of Strings that are active in this layout
     */
    public static List<String> getAllStrings(Activity activity) {

        List<View> views = getAllViews(activity);
        List<String> strings = new ArrayList<>();
        for (View view : views) {
            if (view instanceof TextView) {
                strings.add(((TextView) view).getText().toString());
            }
        }

        return strings;

    }

    /**
     * Gets all the complex Strings associated with an Activity
     * @param activity The activity to check
     * @return an ArrayList of complex Strings
     */
    public static ArrayList<String> getAllComplexStrings(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets all the simple Strings associated with complex Strings in an
     * Activity
     * @param strings A Map of complex Strings and simple strings
     */
    public static void setSimpleStringAlternatives(Map strings) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets action feedback for a View
     * @param view The view to set
     * @param feedbackMessage String to set
     */
    public static void setFeedbackMessage(View view, String feedbackMessage) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets action feedback for a View
     * @param view The view to get the feedbackMessage from
     */
    public static void getFeedbackMessage(View view){
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets bulleted version of long string
     * @param paragraph The String to break down
     * @return bulleted version of paragraph
     */
    public static String getBullettedString(String paragraph){
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    //endregion

}
