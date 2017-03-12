package edu.mit.dig.ama.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import edu.mit.dig.ama.tests.specifics.*;
import edu.mit.dig.ama.tests.specifics.CognitionTests;
import edu.mit.dig.ama.tests.util.Config;

/**
 * A top-level test suite which can be used to determine if your app
 * is accessible in certain cases
 * TODO: https://developer.android.com/training/testing/unit-testing/instrumented-unit-tests.html#build
 *              -> section on "Create a test suite"
 * @author Aaron Vontell
 * @author William Caruso
 * @author Byunkyu Park
 */
public class AccessibilityTester {

    private Config config;

    /**
     * Emptry constructor to make JUnit use happy
     */
    public AccessibilityTester() {
        this.config = new Config();
    }

    /**
     * Runs the desired tests from the configured settings.
     */
    public void runAllTests() {

        // Set defaults
        this.config.defaultAllIncluded();

        // Set config for each test class
        CognitionTests.config = this.config;

        // Run each class
        Result result = JUnitCore.runClasses(
                edu.mit.dig.ama.tests.specifics.CognitionTests.class,
                edu.mit.dig.ama.tests.specifics.VisionTests.class);

        // Generate the test report
        String report = generateReport(result);

        if(!result.wasSuccessful()) {
            throw new AssertionError(report);
        } else {
            System.out.println(report);
        }

    }

    /**
     * Runs the selected categories or test types. All other tests ignored
     */
    public void runTests(AMATest[] whitelist, AMATest[] blacklist) {

        // Set defaults
        this.config.clearAll();
        this.config.addToWhitelist(whitelist);
        this.config.addToBlacklist(blacklist);

        // Set config for each test class
        CognitionTests.config = this.config;

        // Run each class
        Result result = JUnitCore.runClasses(
                edu.mit.dig.ama.tests.specifics.CognitionTests.class,
                edu.mit.dig.ama.tests.specifics.VisionTests.class);

        // Generate the test report
        String report = generateReport(result);

        if(!result.wasSuccessful()) {
            throw new AssertionError(report);
        } else {
            System.out.println(report);
        }

    }

    /**
     * Generates a readable report for accessible testing, based off of the
     * results from <code>runTests()</code> or <code>runAllTests()</code>
     * @param result The
     * @return
     */
    private String generateReport(Result result) {

        StringBuilder report = new StringBuilder();
        if(result.wasSuccessful()) {
            report.append("\n\nACCESSIBLE TESTS PASSED ---------------------------");
            report.append("\n");
        }
        else {
            report.append("\n\nACCESSIBLE TESTS NOT PASSED -----------------------");
            report.append("\n");
        }

        int numProvTest = AMATest.totalIndTests();
        int numProvCats = AMATest.totalCategories();
        int totalFailed = result.getFailureCount();
        int totalIgnored = result.getIgnoreCount();
        int total = result.getRunCount();
        long totalTime = result.getRunTime();

        report.append("Passed " + (total - totalFailed) + "/" + (total) + " tests (" + (totalIgnored) + " AMA tests ignored) [Ran in " + totalTime + " ms]");
        report.append("\n");
        report.append("Failed a total of " + totalFailed + " test cases\n\n");

        if(result.wasSuccessful()) {
            report.append("END OF ACCESSIBLE TEST REPORT -----------------------\n");
            return report.toString();
        }

        report.append("FAILED TESTS LIST ---------------------------------");
        report.append("\n\n");
        report.append("\tThe following is a list of failed test cases. Most will\n" +
                      "\tprovide examples on how to fix the issue; otherwise,\n" +
                      "\tvisit the AMA site for more examples and help.\n\n");

        for(Failure failure : result.getFailures()) {

            report.append("---------------------------------\n");
            report.append(failure.getTestHeader());
            report.append("\n");
            report.append("\t" + failure.getMessage());
            report.append("\n");
            report.append("---------------------------------\n\n");

        }

        report.append("END OF ACCESSIBLE TEST REPORT -----------------------\n");

        return report.toString();

    }

}
