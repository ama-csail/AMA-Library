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
    private String title;
    private boolean enabled;

    /** Parts of the module **/
    private Map<String, String> simpleAlts;
    private Map<String, String> definitions;

    public LanguageMenuModule(String title) {
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

    public Map<String, String> getSimpleAlts() {
        return simpleAlts;
    }

    public void setSimpleStringAlternatives(Map<String, String> simpleAlts) {
        this.simpleAlts = simpleAlts;
    }

    public Map<String, String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Map<String, String> definitions) {
        this.definitions = definitions;
    }
}
