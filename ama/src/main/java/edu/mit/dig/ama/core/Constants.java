package edu.mit.dig.ama.core;

import java.util.Map;
import java.util.HashMap;

import android.graphics.Color;

import edu.mit.dig.ama.R;
import edu.mit.dig.ama.core.ActionClass;

/**
 * A list of constants used throughout the AMA Library
 * DO NOT USE OR MODIFY
 * @author Aaron Vontell
 * @author Byungkyu Park
 * @version 12.3.2016
 */
public class Constants {

    /**
     * Keys for view tags
     */
    public static final int ACTION_CLASS_KEY = R.string.action_class_tag;

    /**
     * Background colors for ActionClasses
     */
    public static final Map<ActionClass, Integer> ACTION_BACKGROUND_COLOR = new HashMap<ActionClass, Integer>(){{
        put(ActionClass.DEFAULT, Color.WHITE);
        put(ActionClass.PRIMARY, Color.BLUE);
        put(ActionClass.SUCCESS, Color.GREEN);
        put(ActionClass.INFO, Color.CYAN);
        put(ActionClass.WARNING, Color.YELLOW);
        put(ActionClass.DANGER, Color.RED);
        put(ActionClass.LINK, Color.WHITE);
    }};

    /**
     * String resource for text on changing the orientation to landscape
     */
    public static final int STRING_ORIENTATION_CHANGE_LANDSCAPE =
            R.string.orientation_change_landscape;

    /**
     * String resource for text on changing the orienation to portrait
     */
    public static final int STRING_ORIENTATION_CHANGE_PORTRAIT =
            R.string.orientation_change_portrait;

}
