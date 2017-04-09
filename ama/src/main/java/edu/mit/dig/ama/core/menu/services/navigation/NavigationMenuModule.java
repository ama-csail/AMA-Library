package edu.mit.dig.ama.core.menu.services.navigation;

import edu.mit.dig.ama.core.menu.services.MenuModule;

/**
 * A module for providing navigation-specific accessibility tools for
 * users. Currently provides the following:
 *      - App-wide sitemap
 */
public class NavigationMenuModule implements MenuModule {

    /** Entire module settings **/
    private String title;
    private boolean enabled;

    /** Parts of the module **/
    private String sitemapTitle;
    private IntentEntry[] intentEntries;

    public NavigationMenuModule(String title) {
        this.title = title;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Sets the information for the sitemap
     * @param sitemapTitle The title for the sitemap section
     * @param intentEntries The entries for the sitemap section
     */
    public void setSitemap(String sitemapTitle, IntentEntry[] intentEntries) {
        this.sitemapTitle = sitemapTitle;
        this.intentEntries = intentEntries;
    }

    public String getSitemapTitle() {
        return sitemapTitle;
    }

    public IntentEntry[] getIntentEntries() {
        return intentEntries;
    }

}
