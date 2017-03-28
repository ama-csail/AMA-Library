package edu.mit.dig.ama.core;

import android.app.Activity;
import android.content.res.Configuration;

import edu.mit.dig.ama.core.menu.MenuView;

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
            accessibleMenu = MenuView.getMenu();
        }
        accessibleMenu.setEnabled(true);
    }

    /**
     * Disable the accessibility menu for this activity (note that this disables
     * any settings configured by the user within the activity)
     */
    public void disableMenu() {
        if(accessibleMenu == null) {
            accessibleMenu = MenuView.getMenu();
        }
        accessibleMenu.setEnabled(false);
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

}
