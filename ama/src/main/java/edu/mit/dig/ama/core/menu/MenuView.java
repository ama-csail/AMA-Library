package edu.mit.dig.ama.core.menu;

import android.content.Context;

/**
 * The core interface for the hoverable accessible menu view, which developers
 * and users can interact with to provide accessibility options to the user.
 * Note that this is also a singleton object.
 * @author Aaron Vontell
 */
public class MenuView {

    // METHODS FOR INSTANTIATION AND SINGLETON MANAGEMENT ----------------------

    /**
     * The actual MenuView instance
     */
    private static MenuView menuInstance = null;

    /**
     * Returns the instance of the MenuView for manipulation and interaction
     * @param context The context to load for the menu
     * @return the current MenuView
     */
    public static MenuView getMenu(Context context) {

        if(menuInstance == null) {
            menuInstance = new MenuView(context);
        }
        return menuInstance;

    }

    // -------------------------------------------------------------------------

    private MenuConfig configuration;

    /**
     * Creates a singleton MenuView for the given context
     */
    private MenuView(Context context) {
        this.configuration = new MenuConfig(context);
    }

    /**
     * Returns the configuration for this menu
     * @return the configuration for this menu
     */
    public MenuConfig getConfiguration() {
        return configuration;
    }

    /**
     * If true, then the menu will be enabled for this applications
     * @param enabled true if the menu should be used (and settings shown)
     */
    public void setEnabled(boolean enabled) {
        configuration.setEnabled(enabled);
    }

}
