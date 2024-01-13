package org.learning.tests;

import org.learning.driver.Driver;
import org.learning.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeMethod
    void setUp() throws Exception {
        Driver.initDriver();
    }

    @AfterMethod
    void tearDown() {
        Driver.quitDriver();
    }
}
