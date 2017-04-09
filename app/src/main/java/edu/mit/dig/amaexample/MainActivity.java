package edu.mit.dig.amaexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import edu.mit.dig.ama.core.AccessibleAppCompatActivity;
import edu.mit.dig.ama.core.menu.services.navigation.IntentEntry;

/**
 * Main activity for the demo app of Accessibility for Mobile Applications
 *
 * Features of this app:
 *      -
 *
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @author Metin Say
 * @version 4.7.2016
 */
public class MainActivity extends AccessibleAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MENU", "Enabling menu");
        enableMenu(); // Note that you must enabled the menu before configuring
        generateIntentList(); // Provide a sitemap for the menu
        showMenu();


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * Generates a list of intents which can be called to access other
     * parts of the application.
     */
    private void generateIntentList() {

        IntentEntry otherIntent =
                new IntentEntry("Other Activity", new Intent(this, OtherActivity.class));
        IntentEntry thisIntent =
                new IntentEntry("Main Activity", new Intent(this, MainActivity.class));

        this.giveSitemap("My First Sitemap", thisIntent, otherIntent);

    }


}