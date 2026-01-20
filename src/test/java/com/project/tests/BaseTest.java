package com.project.tests;

import com.project.driver.BrowserFactory;
import com.project.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        driver = BrowserFactory.getDriver(browser);

        String url = ConfigReader.get("url");
        driver.get(url != null ? url : "https://demowebshop.tricentis.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
