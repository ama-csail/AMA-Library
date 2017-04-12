package edu.mit.dig.ama.core;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import java.util.Map;

import edu.mit.dig.ama.core.menu.MenuView;
import edu.mit.dig.ama.core.menu.MenuViewParser;
import edu.mit.dig.ama.core.menu.services.navigation.IntentEntry;
import edu.mit.dig.ama.core.util.exceptions.MenuNotCreatedException;

/**
 * An accessible library which provides accessible features which a developer can
 * enable.
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 12.4.2016
 */
public class AccessibleAppCompatActivity extends Activity {

    private boolean orientationChangedListenerEnabled;
    private MenuView accessibleMenu;

    /**
     * Enable the accessibility menu for this activity (note that this enables
     * any settings configured by the user within the activity)
     */
    public void enableMenu() {
        if(accessibleMenu == null) {
            Log.d("MENU", "Getting menu");
            accessibleMenu = MenuView.getMenu(this.getApplicationContext());
        }
        accessibleMenu.setEnabled(true);
    }

    /**
     * Disable the accessibility menu for this activity (note that this disables
     * any settings configured by the user within the activity)
     */
    public void disableMenu() {
        if(accessibleMenu == null) {
            accessibleMenu = MenuView.getMenu(this.getApplicationContext());
        }
        accessibleMenu.setEnabled(false);
    }

    /**
     * Begins displaying the menu to the user
     */
    public void showMenu() {
        MenuViewParser viewParser = new MenuViewParser(this, accessibleMenu.getConfiguration());
        viewParser.prepareMenu();
    }

    /**
     * Enables the orientation changed listener for this activity
     * @param enabled true if you want TalkBack to speak on orientation changed
     */
    public void enableOrientationChangedListener(boolean enabled) {
        this.orientationChangedListenerEnabled = enabled;
    }

    /**
     * If orientationChangedListenerEnabled, then speak out with TalkBack to notify
     * the user
     * TODO: Allow customization on text that is spoken back
     * @param newConfig The new configuration which gets passed from the Android system
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(orientationChangedListenerEnabled) {

            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                this.findViewById(android.R.id.content).announceForAccessibility(
                        getString(Constants.STRING_ORIENTATION_CHANGE_LANDSCAPE));

            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

                this.findViewById(android.R.id.content).announceForAccessibility(
                        getString(Constants.STRING_ORIENTATION_CHANGE_PORTRAIT));

            }

        }

    }

    /** code to post/handler request for permission */
    public final static int REQUEST_CODE = -1010101;

    public void checkDrawOverlayPermission() {
        /** check if we already  have permission to draw over other apps */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                /** if not construct intent to request permission */
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                /** request permission via start activity for result */
                startActivityForResult(intent, REQUEST_CODE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        /** check if received result code
         is equal our requested code for draw permission  */
        if (requestCode == REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    // continue here - permission was granted
                    MenuViewParser viewParser = new MenuViewParser(this, null);
                    viewParser.prepareMenu();
                }
            }
        }
    }

    // -------------------------------------------------------------------------
    // MODULE - SPECIFIC BINDINGS FOR THE MENU CONFIGURATION
    // If you are developing our own module for the accessibility menu, here is
    // where you should add methods to make modifications to the MenuCongfig
    // As always, you should make sure that the menu has been created before
    // modifying it, as some users may have the menu disabled.

    /**
     * Provides a sitemap to the navigation module of the accessibility menu
     * @param title The title to display within for sitemap section
     * @param intentEntries The list of entries to be included within the
     *                      sitemap
     */
    public void giveSitemap(String title, IntentEntry... intentEntries) {

        if(accessibleMenu != null) {
            accessibleMenu.getConfiguration()
                    .getNavigationMenuModule()
                    .setSitemap(title, intentEntries);
        } else {
            throw new MenuNotCreatedException();
        }

    }

    /**
     * Gives the accessibility menu a mapping of complex strings to simpler
     * strings, which can be displayed through the language module for users
     * who have cognitive disabilities.
     * @param simpleStrings the mapping from complex strings to simple strings
     */
    public void provideSimpleStrings(Map<String, String> simpleStrings) {

        if(accessibleMenu != null) {
            accessibleMenu.getConfiguration()
                    .getLanguageMenuModule()
                    .setSimpleStringAlternatives(simpleStrings);
        } else {
            throw new MenuNotCreatedException();
        }

    }

    /**
     * Gives the accessibility a mapping of words to definitions, which will be
     * displayed in the glossary sections of the language module. This is useful
     * for those who may have cognitive disabilities, and need further
     * instruction
     * @param definitions the mapping of words to definitions
     */
    public void provideGlossary(Map<String, String> definitions) {

        if(accessibleMenu != null) {
            accessibleMenu.getConfiguration()
                    .getLanguageMenuModule()
                    .setDefinitions(definitions);
        } else {
            throw new MenuNotCreatedException();
        }

    }

}
