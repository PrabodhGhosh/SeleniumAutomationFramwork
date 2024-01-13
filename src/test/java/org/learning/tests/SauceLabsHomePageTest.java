package org.learning.tests;

import org.learning.pages.SauceLabsHomePage;
import org.learning.pages.SauceLabsLoginPage;
import org.learning.util.ReadPropFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public final class SauceLabsHomePageTest extends BaseTest {
    private SauceLabsHomePageTest() {
    }

    @Test

    public void logOutFromSauceLabs() throws FileNotFoundException, InterruptedException {
        SauceLabsLoginPage loginPage = new SauceLabsLoginPage();
        loginPage.login(ReadPropFile.readProp("user"), ReadPropFile.readProp("password"))
                .logOut();
       String loginPageTitle= loginPage.getTitle();
        Assert.assertEquals(loginPageTitle, "Swag Labs");

    }
}
