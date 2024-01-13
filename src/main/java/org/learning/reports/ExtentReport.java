package org.learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.learning.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport() {
    }

    private static ExtentReports extent;

    public static void generateReport() throws FileNotFoundException {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportpath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("AutomationReport");
            spark.config().setReportName("SauceLabsReport");
        }
    }

    public static void closeReport() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
            ExtentManager.unload();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getReportpath()).toURI());
        }

    }

    public static void createTest(String testName) {
        ExtentManager.setExtentTest(extent.createTest(testName));
    }

}
