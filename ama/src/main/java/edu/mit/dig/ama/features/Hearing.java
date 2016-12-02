package edu.mit.dig.ama.features;

import android.app.Activity;
import android.view.View;

/**
 * Hearing related accessibility helper functions.
 */

public class Hearing {

    /**
     *
     * Get to the "No Audio" mode by disabling all the parts
     * that contain audio prompts
     *
     * @param view the view to check upon
     */
    public void getNoAudioMode(View view){
        throw new RuntimeException("Method not implemented");
    }

    /**
     *
     * Check if the current view contains any audio related features
     *
     * @param view the view to check upon
     */
    public void checkIfAudioExists(View view){
        throw new RuntimeException("Method not implemented");
    }

    /**
     *
     * Add visual feedback to the current view
     * Ideally, this method would be used in place of audio feedback
     * where there does not exist any non-audio feedback
     *
     * @param view the view to check upon
     * @param activity the Activity to set feedback on
     */
    public void addVisualFeedback(View view, Activity activity){
        throw new RuntimeException("Method not implemented");
    }

    /**
     *
     * Check if any feedback is audio-only
     *
     * @param view the view to check upon
     */
    public void checkFeedbackOnlySpeech(View view){
        throw new RuntimeException("Method not implemented");
    }
}
