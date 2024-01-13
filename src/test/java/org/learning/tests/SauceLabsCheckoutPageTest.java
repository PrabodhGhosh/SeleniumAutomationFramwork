package org.learning.tests;

import org.learning.pages.SauceLabsHomePage;
import org.learning.pages.SauceLabsLoginPage;
import org.learning.util.ReadPropFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SauceLabsCheckoutPageTest extends  BaseTest{

    private SauceLabsCheckoutPageTest(){}

    @Test
    public void verifyCheckOut() throws FileNotFoundException {

        SauceLabsLoginPage loginPage = new SauceLabsLoginPage();
        SauceLabsHomePage homePage = loginPage.login(ReadPropFile.readProp("user"), ReadPropFile.readProp("password"));
        Assert.assertEquals(homePage.clickCartLink().clickCheckOutLink().enterShippingDetails().isFinishBtnPresent(),true);

    }

}
