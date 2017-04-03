package edu.mit.dig.ama.core.menu;

import android.app.Activity;

/**
 * An object which represents all configurations of the MenuView. Note that this
 * includes both user set options and developer set. The user options are set
 * global to the device, but since different apps may use the menu, each app is
 * referenced using their specific app ID.
 * @author Aaron Vontell
 */
public class MenuConfig {

    /** Developer options **/
    private boolean enabled;

    /** User options **/
    private boolean visible;

    /** Constants **/
    private final String GLOBAL_CONFIG = "ama_user_prefs";

    /**
     * Creates a default configuration object for the MenuView. Always attempts
     * to
     */
    public MenuConfig() {

    }

    /**
     * If true, then the menu will be enabled for this applications
     * @param enabled true if the menu should be used (and settings shown)
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // PARAMETERS AND RULES FOR RETRIEVING AND STORING JSON REPS ---------------

    public void saveAppConfig(Activity activity) {

        String app = activity.getPackageName();

    }

    public void saveUserConfig() {

    }

    public void restoreConfigs() {

    }

    public void resetAppConfig() {

    }

    public void resetUserConfig() {

    }

}
