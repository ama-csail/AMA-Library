package edu.mit.dig.ama.features;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.accessibility.AccessibilityManager;

import java.util.List;

import edu.mit.dig.ama.core.ScreenType;

import static android.content.Context.ACCESSIBILITY_SERVICE;

/**
 * Methods for limited vision accessibility features
 * @author Aaron Vontell
 * @author Billy Caruso
 * @author Byungkyu Park
 * @version 12.3.16
 */
public class Vision {

    private static final String TALKBACK_PACKAGE = "com.google.android.marvin.talkback";

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
            if(packageInfo.packageName.equals(TALKBACK_PACKAGE))
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
                Uri.parse("market://details?id=" + TALKBACK_PACKAGE));

        return talkbackIntent;

    }

    /**
     * Assesses whether the app name is accessible (no emojis or unspeakable characters)
     * @param context The context that wishes to know the results
     * @return True if this app has an accessible name
     */
    public static boolean isHumanReadable(Context context) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Disables any TalkBack interaction from the given view. This method should only be
     * used to disable TalkBack on decorations
     * @param context The context that wishes to know the results
     * @param view The view to remove audio prompts from
     */
    public static void disableAudioPrompts(Context context, View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
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
     * @param context The context to call TalkBack from
     * @param message The message to have TalkBack speak out loud
     */
    public static void speak(Context context, String message) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Changes the font of each given view to the given font
     * @param size The new font size of each view
     * @param views A list of views to increase the size of
     */
    public static void setFont(int size, View ... views) {
        //TODO
        throw new RuntimeException("Method not implemented");
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

}
