package edu.mit.dig.ama.features;

import android.app.Activity;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

import edu.mit.dig.ama.core.ActionClass;

/**
 * Limited Cognition related accessibility helper functions.
 * @author William Caruso
 * @author Byungkyu Park
 * @author Aaron Vontell
 * @version 12.3.2016
 */

public class Cognition {

    /**
     * Sets the HelpMessage of a View
     * @param view The view to set the helpMessage on
     * @param helpMessage The string to set
     */
    public void setHelpMessage(View view, String helpMessage) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets the HelpMessage of a View
     * @param view The view to get the HelpMessage on
     * @return The String HelpMessage of the view
     */
    public String getHelpMessage(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets the ActionClass of a View
     * @param view The view to set the ActionClass on
     * @param actionClass The ActionClass to set, which can be one of
     *                 - ActionClass.DEFAULT
     *                 - ActionClass.PRIMARY
     *                 - ActionClass.SUCCESS
     *                 - ActionClass.INFO
     *                 - ActionClass.WARNING
     *                 - ActionClass.DANGER
     *                 - ActionClass.LINK
     */
    public void setActionClass(View view, ActionClass actionClass) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets the ActionClass of a View
     * @param view The view to set the ActionClass on
     * @return class The ActionClass to set, which can be one of
     *                 - ActionClass.DEFAULT
     *                 - ActionClass.PRIMARY
     *                 - ActionClass.SUCCESS
     *                 - ActionClass.INFO
     *                 - ActionClass.WARNING
     *                 - ActionClass.DANGER
     *                 - ActionClass.LINK
     */
    public ActionClass getActionClass(View view) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets the number of Views within an Activity
     * @param activity The activity to check
     * @return the number of views
     */
    public int getNumViews(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets all the Views on an Activity
     * @param activity The activity to check
     * @return an ArrayList of views
     */
    public ArrayList<View> getAllViews(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets all the Strings associated with an Activity
     * @param activity The activity to check
     * @return an ArrayList of Strings
     */
    public ArrayList<String> getAllStrings(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets all the complex Strings associated with an Activity
     * @param activity The activity to check
     * @return an ArrayList of complex Strings
     */
    public ArrayList<String> getAllComplexStrings(Activity activity) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets all the simple Strings associated with complex Strings in an
     * Activity
     * @param strings A Map of complex Strings and simple strings
     */
    public void setSimpleStringAlternatives(Map strings) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Sets action feedback for a View
     * @param view The view to set
     * @param feedbackMessage String to set
     */
    public void setFeedbackMessage(View view, String feedbackMessage) {
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets action feedback for a View
     * @param view The view to get the feedbackMessage from
     */
    public void getFeedbackMessage(View view){
        //TODO
        throw new RuntimeException("Method not implemented");
    }

    /**
     * Gets bulleted version of long string
     * @param paragraph The String to break down
     * @return bulleted version of paragraph
     */
    public String getBullettedString(String paragraph){
        //TODO
        throw new RuntimeException("Method not implemented");
    }

}
