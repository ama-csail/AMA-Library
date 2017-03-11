package edu.mit.dig.ama.tests.specifics;

import org.junit.Test;

import edu.mit.dig.ama.tests.util.Config;

/**
 * The actual tests to be used for vision. This class is run by the
 * AccessibilityTester, and configured using a config object.
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 3.10.2017
 */
public class VisionTests {

    public static Config config = null;

    @Test
    public void basicTest() {

        System.out.println(config);

    }

}
