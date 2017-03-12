package edu.mit.dig.ama.tests.util;

import java.util.HashSet;
import java.util.Set;

import edu.mit.dig.ama.tests.specifics.AMATest;

/**
 * A configuration structure to be used for testing the accessibility of
 * applications
 * @author Aaron Vontell
 */
public class Config {

    private Set<AMATest> whitelist;
    private Set<AMATest> blacklist;

    public Config() {
        this.whitelist = new HashSet<AMATest>();
        this.blacklist = new HashSet<AMATest>();
    }

    public void clearAll() {
        this.whitelist = new HashSet<AMATest>();
        this.blacklist = new HashSet<AMATest>();
    }

    public void defaultAllIncluded() {
        for(AMATest test : AMATest.values()) {
            this.whitelist.add(test);
        }
        this.blacklist = new HashSet<>();
    }

    public void defaultAllIgnored() {
        for(AMATest test : AMATest.values()) {
            this.blacklist.add(test);
        }
        this.whitelist = new HashSet<>();
    }

    public void addToWhitelist(AMATest test) {
        this.whitelist.add(test);
    }

    public void addToBlacklist(AMATest test) {
        this.blacklist.add(test);
    }

    public void addToWhitelist(AMATest[] tests) {
        for(AMATest test : tests) {
            this.whitelist.add(test);
        }
    }

    public void addToBlacklist(AMATest[] tests) {
        for(AMATest test : tests) {
            this.blacklist.add(test);
        }
    }

    public void removeFromWhitelist(AMATest test) {
        this.whitelist.remove(test);
    }

    public void removeFromBlacklist(AMATest test) {
        this.blacklist.remove(test);
    }

    public boolean blacklistContains(AMATest test) {
        return blacklist.contains(test);
    }

    public boolean whitelistContains(AMATest test) {
        return whitelist.contains(test);
    }

    public boolean shouldTest(AMATest category, AMATest test) {
        return !blacklistContains(test) && !blacklistContains(category) && whitelistContains(test);
    }

}
