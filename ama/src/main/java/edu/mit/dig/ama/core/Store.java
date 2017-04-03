package edu.mit.dig.ama.core;

import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

/**
 * A class used to store information for either 1) switching between accessible
 * modes, or 2) saving accessibility options for use in other applications
 * TODO: This class needs to actually store key-val pairs, not to variables
 *       (variables are for demo only)
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @author Metin Say
 * @version 0.0.1
 */
public class Store {

    private static HashMap<View, String> originals = new HashMap<>();

    /**
     * Saves the original text from a string for use in replacing complex
     * strings with more complicated strings
     * @param view the view which had the original string
     * @param original the original string to restore
     */
    public static void saveViewString(View view, String original) {
        originals.put(view, original);
    }

    /**
     * Restores the view's original text
     * TODO: This will be bad if the view was actually changed by the user!
     * @param view The view to restore the original content
     */
    public static void restoreString(View view) {

        if(originals.containsKey(view)) {
            ((TextView) view).setText(originals.get(view));
        }

    }

    /**
     * Stores text content into a file with the given absolute file name on the
     * internal drive (with sharing enabled)
     * @param file The absolute filename to save to
     * @param content The contents to save to the file
     */
    public void storeString(String file, String content) {

    }

    /**
     * Retrieves the string content from the given file on the internal drive
     * @param file The absolute filename to retrieve from
     * @return The contents of the file, or null if no file was accessed
     */
    public String getString(String file) {

    }


}
