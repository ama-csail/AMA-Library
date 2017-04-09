package edu.mit.dig.ama.core.menu.services.navigation;

import android.content.Intent;

/**
 * Represents an activity or intent to navigate to from the MenuProvider page
 * listing
 * @author Aaron Vontell
 * @version 0.0.1
 */
public class IntentEntry {

    private Intent intent;
    private boolean active;
    private String title;

    public IntentEntry(String title, Intent intent) {
        this.title = title;
        this.intent = intent;
    }

    public boolean isActive() {
        return active;
    }

    public Intent getIntent() {
        return intent;
    }

    public String getTitle() {
        return title;
    }
}
