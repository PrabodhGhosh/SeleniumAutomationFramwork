package org.learning.listeners;

import org.learning.reports.ExtentLogger;
import org.learning.reports.ExtentReport;
import org.testng.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ListenerProvider implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite){
        try {
            ExtentReport.generateReport();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite)
    {
        try {
            ExtentReport.closeReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Override

    public void onTestSuccess(ITestResult result)
    {
        try {
            ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public void onTestFailure(ITestResult result)
    {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName()+" is failed");
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public void onTestSkipped(ITestResult result)
    {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
