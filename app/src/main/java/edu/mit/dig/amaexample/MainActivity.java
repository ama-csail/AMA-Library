package edu.mit.dig.amaexample;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import edu.mit.dig.ama.core.AccessibleAppCompatActivity;
import edu.mit.dig.ama.core.menu.services.navigation.IntentEntry;

/**
 * Main activity for the demo app of Accessibility for Mobile Applications
 *
 * Features of this app:
 *      - WCAG 2.4.5 Satisfied
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
        generateSimpleAlts(); // Provide a list of simple strings
        generateGlossary(); // Provide a list of glossary terms
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

    private void generateSimpleAlts() {

        Map<String, String> simpleMappings = new HashMap<>();
        simpleMappings.put("complex", "simple");
        simpleMappings.put("UI", "user interface");
        simpleMappings.put("quite", "very");

        this.provideSimpleStrings(simpleMappings);

    }

    private void generateGlossary() {

        Map<String, String> definitions = new HashMap<>();
        definitions.put("Mitochondria", "The powerhouse of the cell");
        definitions.put("Accessibility", "The quality of being able to be reached or entered (something that Android lacks");
        definitions.put("Native Mobile", "An application built using libraries provided by the OS creator, rather than a third party service");

        this.provideGlossary(definitions);

    }

}