package edu.mit.dig.amaexample;

import android.content.Intent;
import android.os.Bundle;

import edu.mit.dig.ama.core.AccessibleAppCompatActivity;
import edu.mit.dig.ama.core.menu.services.navigation.IntentEntry;


public class OtherActivity extends AccessibleAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        enableMenu(); // Note that you must enabled the menu before configuring
        generateIntentList(); // Provide a sitemap for the menu
        showMenu();

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
