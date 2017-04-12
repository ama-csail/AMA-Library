package edu.mit.dig.ama.core.menu;

import android.app.Activity;
import android.content.Context;

import java.io.Serializable;

import edu.mit.dig.ama.core.menu.services.MenuModule;
import edu.mit.dig.ama.core.menu.services.language.LanguageMenuModule;
import edu.mit.dig.ama.core.menu.services.navigation.NavigationMenuModule;

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

    /** Library objects **/
    private Context globalContext;

    private NavigationMenuModule navigationMenuModule;
    private LanguageMenuModule languageMenuModule;

    /** Constants **/
    private final String USER_PREFS = "ama_user_prefs";

    /**
     * Creates a default configuration object for the MenuView. Always attempts
     * to load previous configurations from memory; otherwise, a new file is
     * created
     * @param globalContext The global / app level context (should not be an
     *                      activity context, in case the activity changes). A
     *                      non-global context can be used if
     *                      <code>setContext()</code> is used on each new
     *                      activity.
     */
    public MenuConfig(Context globalContext) {

        this.globalContext = globalContext;

        // Create an instance of each module, with default titles
        this.navigationMenuModule = new NavigationMenuModule();
        this.languageMenuModule = new LanguageMenuModule();

        //TODO: load pre-existing preferences
    }

    /**
     * Resets the context to be the given context
     * @param context The new context for this menu
     */
    public void setContext(Context context) {
        this.globalContext = context;
    }

    /**
     * If true, then the menu will be enabled for this applications
     * @param enabled true if the menu should be used (and settings shown)
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Returns the navigation module which holds information and logic regarding
     * the navigation for the accessible menu
     * @return the navigation menu module being used by the accessible menu
     */
    public NavigationMenuModule getNavigationMenuModule() {
        return this.navigationMenuModule;
    }

    /**
     * Returns the language module which holds information and logic regarding
     * language for the accessible menu
     * @return the language menu module being used by the accessible menu
     */
    public LanguageMenuModule getLanguageMenuModule() {
        return languageMenuModule;
    }

    // PARAMETERS AND RULES FOR RETRIEVING AND STORING CONFIGS -----------------

    public void saveAppConfig(Activity activity) {

        String app = activity.getPackageName();

    }

    /**
     * Calls the store
     */
    public void saveUserConfig() {

    }

    public void restoreConfigs() {

    }

    public void resetAppConfig() {

    }

    public void resetUserConfig() {

    }

    // CLASS DEFINITIONS TO SEPARATE DEVELOPER AND USER OPTIONS ----------------

    private class UserPreferences implements Serializable {

    }

    private class DeveloperOptions implements Serializable {

    }

}
