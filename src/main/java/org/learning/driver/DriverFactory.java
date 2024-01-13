package org.learning.driver;

import org.learning.util.ReadPropFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {
    private DriverFactory() {
    }


    public static WebDriver getDriver() throws FileNotFoundException, MalformedURLException {
        WebDriver driver = null;
        String runMode = ReadPropFile.readProp("runmode");
        String browser = ReadPropFile.readProp("browser");

        if (runMode.equalsIgnoreCase("local")) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else {
                throw new RuntimeException("Check the browser name");
            }
        } else if (runMode.equalsIgnoreCase("remote")) {
            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else if (browser.equalsIgnoreCase("firefox")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            } else {
                throw new RuntimeException("Check the runmode value");
            }
        }

        return driver;
    }
}
