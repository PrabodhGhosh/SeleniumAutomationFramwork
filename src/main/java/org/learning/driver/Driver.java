package org.learning.driver;

import org.learning.util.ReadPropFile;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver() {
    }

    public static void initDriver() throws Exception {
        if ((DriverManager.getDriver() == null)) {
            DriverManager.setDriver(DriverFactory.getDriver());
        }

        DriverManager.getDriver().get(ReadPropFile.readProp("url"));
        DriverManager.getDriver().manage().window().maximize();

    }


    public static void quitDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
