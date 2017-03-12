package edu.mit.dig.ama.tests.specifics;

import org.junit.Assume;
import org.junit.Test;
import edu.mit.dig.ama.tests.util.Config;

import static org.junit.Assert.*;

/**
 * The actual tests to be used for cognition. This class is run by the
 * AccessibilityTester, and configured using a config object.
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 3.12.2017
 */
public class CognitionTests {

    public static Config config = null;

    @Test
    public void allStringsAccessibleTest() {

        // If assumption fails, this test is ignored
        Assume.assumeTrue(config.shouldTest(AMATest.COGNITIVE,
                AMATest.ALL_STRINGS_ACCESSIBLE_TEST));

        assertTrue("Tests if all strings are accessible" , false);

    }

    @Test
    public void usesActionClassesTest() {

        // If assumption fails, this test is ignored
        Assume.assumeTrue(config.shouldTest(AMATest.COGNITIVE,
                AMATest.USES_ACTION_CLASSES_TEST));

        assertTrue("Tests if action classes are used in buttons" , true);

    }

    @Test
    public void providesSimpleAlternativesTest() {

        // If assumption fails, this test is ignored
        Assume.assumeTrue(config.shouldTest(AMATest.COGNITIVE,
                AMATest.PROVIDES_SIMPLE_ALTERNATIVES_TEST));

        assertTrue("Tests if simple string alternatives are provided for complex strings" , true);

    }

}
