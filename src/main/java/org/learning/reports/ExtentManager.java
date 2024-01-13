package org.learning.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager() {
    }

    private static final ThreadLocal<ExtentTest> et = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return et.get();
    }

    static void setExtentTest(ExtentTest test) {
        et.set(test);
    }

    static void unload() {
        et.remove();
    }
}
