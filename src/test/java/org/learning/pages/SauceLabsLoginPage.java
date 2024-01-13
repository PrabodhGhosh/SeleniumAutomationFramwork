package org.learning.pages;

import org.learning.driver.DriverManager;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;

public final class SauceLabsLoginPage extends BasePage {

    private final By user_id = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");

    public SauceLabsHomePage login(String user, String pwd) throws FileNotFoundException {
        DriverManager.getDriver().findElement(user_id).sendKeys(user);
        DriverManager.getDriver().findElement(password).sendKeys(pwd);
        click(loginBtn);
        return new SauceLabsHomePage();

    }

    public String getTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
