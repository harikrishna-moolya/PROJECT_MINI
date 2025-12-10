package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    WebDriver driver;
    By logoutLink = By.cssSelector("a[href='/logout']");

    public ProfilePage(WebDriver driver){ this.driver = driver; }
    public boolean isLoggedIn(){ return driver.findElements(logoutLink).size()>0; }
}
