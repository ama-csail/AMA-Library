package edu.mit.dig.ama.features;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;

import edu.mit.dig.ama.core.AccessibilityHandler;
import edu.mit.dig.ama.core.NavType;

/**
 * MotorSkills related accessibility helper functions.
 * @author William Caruso
 * @author Aaron Vontell
 * @author Byungkyu Park
 * @version 12.3.2016
 */
public class MotorSkills {

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

}
