package edu.mit.dig.ama.tests;

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

    private Builder builder;

    public AccessibilityTester(Config config) {

        this.builder = new Builder(config);

    }

    public void runTests() {

    }

    public void runTests(Config config) {

    }

    /**
     * An object which is used to configure tests which will test
     * for accessibility. This also provides methods to interact with the
     * configuration file
     */
    public class Builder {

        Config config = null;

        public Builder(Config config) {

            this.config = config;

        }

        public Builder() {

            this.config = new Config();

        }

        public void replaceConfig(Config config) {

            this.config = config;

        }


    }

}
