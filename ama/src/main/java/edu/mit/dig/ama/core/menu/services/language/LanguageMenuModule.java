package edu.mit.dig.ama.core.menu.services.language;

import java.util.Map;

import edu.mit.dig.ama.core.menu.services.MenuModule;

/**
 * A module for providing navigation-specific accessibility tools for
 * users. Currently provides the following:
 *      - Toggles for simple strings
 *      - Glossary for hard-to-understand terms
 */
public class LanguageMenuModule implements MenuModule {

    /** Entire module settings **/
    private final String TITLE = "Language Options";
    private boolean enabled;

    /** Parts of the module **/
    private Map<String, String> simpleAlts;
    private Map<String, String> definitions;

    public LanguageMenuModule() {

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
     * Returns the mapping of complex strings to simpler strings
     * @return the mapping of complex strings to simpler strings
     */
    public Map<String, String> getSimpleAlts() {
        return simpleAlts;
    }

    /**
     * Sets the mapping of complex strings to simpler strings
     * @param simpleAlts the mapping of complex strings to simpler strings
     */
    public void setSimpleStringAlternatives(Map<String, String> simpleAlts) {
        this.simpleAlts = simpleAlts;
    }

    /**
     * Returns the glossary of terms and definitions to be used within the menu
     * glossary
     * @return the glossary of terms and definitions
     */
    public Map<String, String> getDefinitions() {
        return definitions;
    }

    /**
     * Returns the glossary of terms and definitions to be used within the menu
     * glossary
     * @param definitions the mapping of terms to definitions
     */
    public void setDefinitions(Map<String, String> definitions) {
        this.definitions = definitions;
    }
}
