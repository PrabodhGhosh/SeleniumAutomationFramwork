package org.learning.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.learning.driver.DriverManager;
import org.learning.util.ReadPropFile;
import org.learning.util.ScreenShotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;

public final class ExtentLogger {

    private ExtentLogger() {
    }

    public static void pass(String message) throws FileNotFoundException {
        if (ReadPropFile.readProp("ScreenshotOnPass").equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenShot()).build());
        } else {
            ExtentManager.getExtentTest().pass(message);
        }
    }

    public static void fail(String message) throws FileNotFoundException {
        if (ReadPropFile.readProp("ScreenshotOnFailure").equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenShot()).build());
        }
        else {
            ExtentManager.getExtentTest().fail(message);
        }
    }

    public static void skip(String message) throws FileNotFoundException {
        if (ReadPropFile.readProp("ScreenshotOnSkip").equalsIgnoreCase("yes")) {
            ExtentManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenShot()).build());
        }
        else {
            ExtentManager.getExtentTest().skip(message);
        }
    }

}
