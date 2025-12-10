package com.project.tests;
import com.project.driver.BrowserFactory;
import com.project.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriverIncognito();
        String url = ConfigReader.get("url"); 
        if(url!=null) driver.get(url); else driver.get("https://demowebshop.tricentis.com/");
    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null) driver.quit();
    }
}
