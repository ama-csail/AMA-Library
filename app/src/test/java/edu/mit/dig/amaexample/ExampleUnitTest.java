package edu.mit.dig.amaexample;

import org.junit.Test;

import edu.mit.dig.ama.tests.AccessibilityTester;
import edu.mit.dig.ama.tests.specifics.AMATest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends AccessibilityTester {

    @Test
    public void accessibilityTest() {
        this.runAllTests();
    }

    @Test
    public void someAccessibilityTest() {

        AMATest[] toTest = {AMATest.PROVIDES_SIMPLE_ALTERNATIVES_TEST,
                            AMATest.USES_ACTION_CLASSES_TEST};
        AMATest[] toIgnore = {};
        this.runTests(toTest, toIgnore);
    }

}