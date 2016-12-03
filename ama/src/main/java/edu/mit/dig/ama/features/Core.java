package edu.mit.dig.ama.features;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;

/**
 * A collection of core features which may be used within
 * different accessibility settings.
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 12.3.2016
 */
public class Core {

    static OrientationEventListener mOrientationListener;
    static String DEBUG_TAG = "AMA-Library";

    /**
     * Causes TalkBack to talk out loud whenever an orientation change occurs
     * @param activity The calling activity
     */
    public static void attachOrientationListener(Activity activity) {
        final View view = activity.findViewById(android.R.id.content);

        activity = new Activity() {
            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                super.onConfigurationChanged(newConfig);

                if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    Log.v(DEBUG_TAG, "New orientation is landscape");
                    view.announceForAccessibility("Orientation is Landscape");
                } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
                    Log.v(DEBUG_TAG, "New orientation is portrait");
                    view.announceForAccessibility("Orientation is Portrait");
                }
            };
        };
    }
}
