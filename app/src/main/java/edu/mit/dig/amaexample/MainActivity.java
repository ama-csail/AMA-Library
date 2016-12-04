package edu.mit.dig.amaexample;

import android.os.Bundle;

import edu.mit.dig.ama.core.AccessibleAppCompatActivity;

/**
 * Main activity for the demo app of Accessiblity for Mobile Applications
 *
 * Features of this app:
 *      - Provides ActionClass button types
 *      - Custom TalkBack speaking
 *      - Check if a string is Accessible
 *      - Speak back when orientation changed
 *
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 12.3.2016
 */
public class MainActivity extends AccessibleAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enable the custom orientation changed listener
        enableOrientationChangedListener(true);

    }
}
