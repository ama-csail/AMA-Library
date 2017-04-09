package edu.mit.dig.ama.core.util.exceptions;

/**
 * Represents an extension which indicates that the accessible menu (MenuView)
 * was not instantiated or referenced before attempting to modify it
 * @author Aaron Vontell
 */
public class MenuNotCreatedException extends RuntimeException {

    public MenuNotCreatedException() {
        super("An attempt was made to configure the accessible menu (MenuView)," +
                "but the menu was never created or referenced. Make sure to" +
                "call 'enableMenu()' before the menu is configured.");
    }
}
