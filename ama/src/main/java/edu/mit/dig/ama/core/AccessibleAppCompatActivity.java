package edu.mit.dig.ama.core;

import android.app.Activity;
import android.content.res.Configuration;

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
