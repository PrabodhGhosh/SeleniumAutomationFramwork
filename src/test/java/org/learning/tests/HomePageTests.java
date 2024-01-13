package org.learning.tests;

import org.learning.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {


    @Test

    public void test2() {
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Google");

    }

    @Test
    public void test4() {
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Google");

    }
}
