package org.learning.pages;

import org.learning.driver.DriverManager;
import org.openqa.selenium.By;

public class BasePage {
    protected void click(By by) {
        DriverManager.getDriver().findElement(by).click();
    }
}
