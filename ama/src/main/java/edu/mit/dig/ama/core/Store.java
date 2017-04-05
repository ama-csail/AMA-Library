package edu.mit.dig.ama.core;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

/**
 * A class used to store public information for either 1) switching between accessible
 * modes, or 2) saving accessibility options for use in other applications through external storage
 * TODO: This class needs to actually store key-val pairs, not to variables
 *       (variables are for demo only)
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @author Metin Say
 * @version 0.0.1
 */
public class Store {

    private static final String LOG_TAG = "Store";
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
     * Stores a serialized version of the object in Internal storage on the device
     * @param fileName The name of the file
     * @param obj
     */
    public void storeObject(String fileName, Serializable obj) {
        // TODO: Use ?? for storing a shared access file


    }

    /**
     * Retrieves the string content from the given file on the internal drive
     * @param file The absolute filename to retrieve from
     * @return The contents of the file, or null if no file was accessed
     */
    public String getString(String file) {
        return "Not Implemented";
    }

    public File getObject(String fileName, Serializable obj) {
        // TODO: get file is it is stored

        // Check if the directory exists for the fileName
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), fileName);
        if (!file.mkdirs()) {
            Log.e(LOG_TAG, "Directory not created");
        }
        return file;
    }

    // Helper methods for working with external storage
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
//        TODO: user Internal storage if external is not available
//        String state = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            return true;
//        }
//        return false;
        return true;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

}
