package org.learning.pages;

import org.learning.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class SauceLabsHomePage extends BasePage{

    private final By Menu = By.id("react-burger-menu-btn");
    private final By logOutLink = By.id("logout_sidebar_link");
    private final By cartLink = By.className("shopping_cart_link");

    public void logOut() throws InterruptedException {
        click(Menu);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(logOutLink));
        click(logOutLink);
    }

    public SauceLabCheckoutPage clickCartLink() {
        click(cartLink);
        return new SauceLabCheckoutPage();
    }
}
