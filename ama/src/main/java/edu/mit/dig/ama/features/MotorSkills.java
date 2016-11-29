package edu.mit.dig.ama.features;

/**
 * MotorSkills related accessibility helper functions.
 */

public class MotorSkills {

    /**
     *
     * Sets the NavType of an Activity
     * @param activity The Activity to set the NavType on
     * @param type The NavType to set
     *                 - NavType.TABS
     *                 - NavType.TABS+SWIPE
     *                 - NavType.SWIPE+TITLE
     *                 - NavType.DROPDOWN
     */
    public void setNavType(Activity activity, NavType type){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Gets the NavTypes of an Activity
     * @param activity The Activity to set the NavType on
     * @return an Arraylist of NavTypes
     */
    public ArrayList<NavType> getNavTypes(Activity activity){
        throw new RuntimeException("Method not implemented");
    }


    /**
     * THIS METHOD WILL BE INTENSE - REQUIRES DESIGN OF KEYBOARD INPUT TO MAKE
     * CUSTOM AccessibilityHandlers
     * Sets the Activity to be keyboard accessible
     * @param activity The Activity to set
     */
    public void setKeyboardAccessible(Activity activity){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Sets the a custom KeyboardAccessibilityHandler
     * @param activity The Activity to set the handler on
     * @param handler the custom handler to add
     */
    public void setKeyboardAccessibleHandler(Activity activity, AccessibilityHandler handler){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Sets the all taps to single taps
     * @param activity The Activity to set
     */
    public void setActivitySingleTaps(Activity activity){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Sets the grace period on all taps
     * @param activity The Activity to set
     * @param sec The number of seconds for the grace period
     */
    public void setTapGracePeriod(Activity activity, int sec){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Sets the all gestures to single handed gestures
     * @param activity The Activity to set
     */
    public void setSingleHandGestures(Activity activity){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Sets the input time for a View
     * @param view The View to set
     * @param sec The number of seconds for the input
     * @param disable The boolean to determine if time can be disabled
     * @param extend The boolean to determine if time can be extended
     */
    public void setTimeInput(View view, int sec, boolean disable, boolean extend){
        throw new RuntimeException("Method not implemented");
    }


    /**
     *
     * Sets the minimum padding on Views in an Activity
     * @param activity The Activity to set
     * @param min The minimum number of padding (px)
     */
    public void setMinimumPadding(Activity activity, int min){
        throw new RuntimeException("Method not implemented");
    }
}
