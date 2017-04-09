package edu.mit.dig.ama;

import android.annotation.SuppressLint;
import android.util.Log;

import org.junit.Test;

import edu.mit.dig.ama.core.AMA;

import static org.junit.Assert.*;

/**
 * A collection of unit tests for AMA which uses plain Java
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 */

public class JavaUnitTest {

    /**
     * Tests that a series of accessible strings are indeed accessible as
     * defined by <code>AMA.isStringAccessible()</code>
     */
    @Test
    public void isStringAccessibleTrue() {

        String string1 = "This is certainly an accessible string";
        String string2 = "Is this accessible? Sure should be.";
        String string3 = "21 years old I am. 21.";

        assertTrue(String.format("Expected \"%s\" to be accessible", string1),
                AMA.isStringAccessible(string1));
        assertTrue(String.format("Expected \"%s\" to be accessible", string2),
                AMA.isStringAccessible(string2));
        assertTrue(String.format("Expected \"%s\" to be accessible", string3),
                AMA.isStringAccessible(string3));

    }

    /**
     * Tests that a series of inaccessible strings are indeed inaccessible as
     * defined by <code>AMA.isStringAccessible()</code>
     */
    @Test
    public void isStringAccessibleFalse() {

        String string1 = "˙¨øø∫√∂å´¥∫ˆ˜®≈´ should not be accessible";
        String string2 = null;
        String string3 = "";

        assertFalse(String.format("Expected \"%s\" to be inaccessible", string1),
                AMA.isStringAccessible(string1));
        assertFalse(String.format("Expected \"%s\" to be inaccessible", string2),
                AMA.isStringAccessible(string2));
        assertFalse(String.format("Expected \"%s\" to be inaccessible", string3),
                AMA.isStringAccessible(string3));

    }

    @Test
    public void calcLuminanceWhite() {
        int[] comps = new int[] {1, 255, 255, 255};
        assertEquals("Luminance of white is 1", 1.0, AMA.calcLuminance(comps), 0.0001);
    }

}
