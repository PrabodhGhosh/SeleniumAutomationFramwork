package org.learning.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import org.learning.util.ReadPropFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DockerTest {

    @Test(dataProvider = "getData")

    public void dockerTest1(String browser) throws FileNotFoundException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        driver.get("https://www.google.com");
        System.out.println("The title is: "+driver.getTitle());
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test
    public void dockerTest2() throws FileNotFoundException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(ReadPropFile.readProp("browser"));
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        driver.get("https://www.google.com");
        System.out.println("The title is: "+driver.getTitle());
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        driver.quit();
    }

   @DataProvider

   public Object[][] getData(){

        return new Object[][]{{"chrome"},{"firefox"},{"chrome"},{"firefox"}};
   }


}
