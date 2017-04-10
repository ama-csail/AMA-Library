package edu.mit.dig.ama.core.menu.services;

/**
 * Defines a module to be used in the accessibility menu. A list of these
 * modules is held by the accessibility menu, which can be enabled, disabled,
 * and used to hold or display information
 * @author Aaron Vontell
 */
public interface MenuModule {

    /**
     * Returns true if this module is enabled and should be available to the
     * user to interact with. Note that this may also depend on whether or
     * not this module has the appropriate data loaded into it
     * @return true if this menu option should be accessible
     */
    boolean isEnabled();

    /**
     * Set to true for this module to be accessible by the user, and false
     * otherwise
     * @param enabled true if this module should be enabled, false otherwise
     */
    void setEnabled(boolean enabled);

    /**
     * Returns the title for this module, or essentially the first text view's
     * text within the layout for this module
     * NOTE: This must be unique! It is used as an identifier for the HoverMenu
     * @return the title of this module
     */
    String getTitle();

}
