package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    // Locator
    private By logoutLink = By.cssSelector("a[href='/logout']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if user is logged in
    public boolean isLoggedIn() {
        return !driver.findElements(logoutLink).isEmpty();
    }
}
