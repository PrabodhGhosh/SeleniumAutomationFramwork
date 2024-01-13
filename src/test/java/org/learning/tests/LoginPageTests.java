package org.learning.tests;

import org.learning.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {


    @Test

    public void test1()
    {
        Assert.assertEquals(DriverManager.getDriver().getTitle(),"Google");

    }
}
