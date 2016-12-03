package edu.mit.dig.ama.features;

import android.app.Activity;
import android.view.View;

/**
 * Voice related accessibility helper functions.
 */

public class Voice {

    /**
     *
     * Check if navigation is speech-only
     *
     * @param view the view to check upon
     */
    public void checkNavigationOnlySpeech(View view){
        throw new RuntimeException("Method not implemented");
    }

    /**
     *
     * Get the current available input methods from the input field
     *
     * @param view the view to check upon
     * @activity activity the Activity for specific input field
     */
    public void getInputMethodsInInputFields(View view, Activity activity){
        throw new RuntimeException("Method not implemented");
    }

    /**
     *
     * Set the text input available for all speech-driven inputs
     *
     * @param view the view to check upon
     * @activity activity the Activity for specific input field
     */
    public void setTextInputAvailable(View view, Activity activity){
        throw new RuntimeException("Method not implemented");
    }
}
