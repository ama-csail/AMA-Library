package edu.mit.dig.ama.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        Intent talkbackIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + Constants.TALKBACK_PACKAGE));

        return talkbackIntent;

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
     * @param activity The activity to set an alternative layout
     * @param layout The layout resource for the accessible layout
     * @param screenType The ScreenType to use, which can be one of: TODO
     */
    public static void setTalkBackLayout(Activity activity, @LayoutRes int layout, ScreenType screenType) {
        //TODO
        throw new RuntimeException("Method not implemented");
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
    public static void increaseSpacing(int space, View ... views) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Assesses whether the given colors satisfy the 4.5:1 ratio for contrast
     * @param colorForeground The color resource in the front of the background
     * @param colorBackground The color resource of the background
     */
    public static boolean statisfiesContrast(int colorForeground, int colorBackground) {
        //TODO
        throw new RuntimeException("Method not implemented");
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
     * be read reliably by TalkBack
     * @param input The string to test accessibility on
     * @return true if input is accessible
     */
    public static boolean isStringAccessible(String input) {

        return input != null && input.matches("^[a-zA-Z0-9]*$");

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
     * Gets the number of Views within an Activity
     * @param activity The activity to check
     * @return the number of views
     */
    public static int getNumViews(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets all the Views on an Activity
     * @param activity The activity to check
     * @return an ArrayList of views
     */
    public static ArrayList<View> getAllViews(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets all the Strings associated with an Activity
     * @param activity The activity to check
     * @return an ArrayList of Strings
     */
    public static ArrayList<String> getAllStrings(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
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
