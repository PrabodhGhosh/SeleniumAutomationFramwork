package org.learning.tests;

import org.json.simple.JSONObject;
import org.learning.driver.DriverManager;
import org.learning.pages.SauceLabsLoginPage;
import org.learning.reports.ExtentLogger;
import org.learning.reports.ExtentManager;
import org.learning.reports.ExtentReport;
import org.learning.util.JSONDataProvider;
import org.learning.util.ReadPropFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public final class SauceLabsLoginPageTest extends BaseTest{

    private SauceLabsLoginPageTest() {
    }

    @Test (dataProvider = "dataProvider", dataProviderClass= JSONDataProvider.class)
    public void login(Object testObject) throws FileNotFoundException {
        SauceLabsLoginPage loginPage = new SauceLabsLoginPage();
        String userName =(String)((JSONObject)testObject).get("user");
        String password =(String)((JSONObject)testObject).get("password");
        loginPage.login(userName, password);
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Swag Labs");
    }
}
