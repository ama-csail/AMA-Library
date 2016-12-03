package edu.mit.dig.ama.features;

import android.app.Activity;
import android.view.View;

/**
 * Hearing related accessibility helper functions.
 * @author Byungkyu Park
 * @author Aaron Vontell
 * @author William Caruso
 * @version 12.3.2016
 */
public class Hearing {

    /**
     * Get to the "No Audio" mode by disabling all the parts
     * that contain audio prompts
     * @param view the view to check upon
     */
    public static void getNoAudioMode(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Check if the current view contains any audio related features
     * @param view the view to check upon
     */
    public static void checkIfAudioExists(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Add visual feedback to the current view
     * Ideally, this method would be used in place of audio feedback
     * where there does not exist any non-audio feedback
     * @param view the view to check upon
     * @param activity the Activity to set feedback on
     */
    public static void addVisualFeedback(View view, Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Check if any feedback is audio-only
     * @param view the view to check upon
     */
    public static void checkFeedbackOnlySpeech(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

}
