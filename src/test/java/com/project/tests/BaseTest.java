package com.project.tests;

import com.project.driver.BrowserFactory;
import com.project.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        driver = BrowserFactory.getDriver();

        String url = ConfigReader.get("app.url");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("app.url is not specified in config.properties");
        }

        driver.get(url);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Required for Screenshot Listener
    public static WebDriver getDriver() {
        return driver;
    }
}
