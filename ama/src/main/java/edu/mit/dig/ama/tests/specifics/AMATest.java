package edu.mit.dig.ama.tests.specifics;

/**
 * An enumerated type which holds all types for AMA tests (i.e. every test
 * category and every individual type)
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byungkyu Park
 * @version 3.12.2017
 */

public enum AMATest {

    // AMATest categories ---------------------------------------------------------

    /**
     * Category for all Cognitive tests
     */
    COGNITIVE,

    /**
     * Category for all Vision tests
     */
    VISION,

    // Individual tests --------------------------------------------------------

    /**
     * Tests whether all strings in strings.xml are accessible
     */
    ALL_STRINGS_ACCESSIBLE_TEST,

    /**
     * Tests whether action class are used on buttons for intent clarity
     */
    USES_ACTION_CLASSES_TEST,

    /**
     * Tests to see if string alternatives are provided for complex strings
     */
    PROVIDES_SIMPLE_ALTERNATIVES_TEST;

    // HELPER METHODS ----------------------------------------------------------

    /**
     * Returns the total number of individual tests
     * @return the total number of individual tests
     */
    public static int totalIndTests() {
        return values().length - totalCategories();
    }

    /**
     * Returns the number of test categories
     * @return the number of test categories
     */
    public static int totalCategories() {
        return 3;
    }

    /**
     * Returns the count of individual tests in tests
     * @param tests the tests you want to survey
     * @return the count of individual tests in tests
     */
    public static int notCategories(AMATest[] tests) {
        int count = 0;
        for(AMATest test : tests) {
            if (test != COGNITIVE && test != VISION) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the count of categories in tests
     * @param tests the tests you want to survey
     * @return the count of categories tests in tests
     */
    public static int onlyCategories(AMATest[] tests) {
        int count = 0;
        for(AMATest test : tests) {
            if (test == COGNITIVE || test == VISION) {
                count++;
            }
        }
        return count;
    }

}
