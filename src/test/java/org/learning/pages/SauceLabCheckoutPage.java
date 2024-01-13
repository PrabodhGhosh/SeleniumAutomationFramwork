package org.learning.pages;

import org.learning.driver.DriverManager;
import org.openqa.selenium.By;

public final class SauceLabCheckoutPage extends BasePage {

    private final By checkOutLink = By.id("checkout");
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");

    public SauceLabCheckoutPage clickCheckOutLink() {
        click(checkOutLink);
        return this;
    }

    public  SauceLabCheckoutPage enterShippingDetails() {
        DriverManager.getDriver().findElement(firstName).sendKeys("fname");
        DriverManager.getDriver().findElement(lastName).sendKeys("lname");
        DriverManager.getDriver().findElement(zipCode).sendKeys("713146");
        click(continueBtn);
        return this;
    }

    public  boolean isFinishBtnPresent() {
        return DriverManager.getDriver().findElement(finishBtn).isDisplayed();
    }
}
