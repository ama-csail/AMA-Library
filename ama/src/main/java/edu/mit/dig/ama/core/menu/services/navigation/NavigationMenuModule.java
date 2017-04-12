package edu.mit.dig.ama.core.menu.services.navigation;

import edu.mit.dig.ama.core.menu.services.MenuModule;

/**
 * A module for providing navigation-specific accessibility tools for
 * users. Currently provides the following:
 *      - App-wide sitemap
 */
public class NavigationMenuModule implements MenuModule {

    /** Entire module settings **/
    private final String TITLE = "Navigation";
    private boolean enabled;

    /** Parts of the module **/
    private String sitemapTitle;
    private IntentEntry[] intentEntries;

    /**
     * Creates a basic navigation module for the accessible menu
     */
    public NavigationMenuModule() {

    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String getTitle() {return TITLE;}

    /**
     * Sets the title and list of entries for the app sitemap
     * @param sitemapTitle The title for the sitemap section
     * @param intentEntries The entries for the sitemap section
     */
    public void setSitemap(String sitemapTitle, IntentEntry[] intentEntries) {
        this.sitemapTitle = sitemapTitle;
        this.intentEntries = intentEntries;
    }

    /**
     * Returns the title of the sitemap
     * @return the title of the sitemap
     */
    public String getSitemapTitle() {
        return sitemapTitle;
    }

    /**
     * Returns the array of intent entries, or accessible activities and
     * sections of the application
     * @return the intents to display within the accessible menu's sitemap
     */
    public IntentEntry[] getIntentEntries() {
        return intentEntries;
    }

}
