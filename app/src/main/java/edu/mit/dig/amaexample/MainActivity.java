package edu.mit.dig.amaexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
