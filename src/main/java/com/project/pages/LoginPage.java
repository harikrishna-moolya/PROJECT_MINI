package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector("input.button-1.login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Perform login
    public void login(String username, String password) {

        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(username);

        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
    }
}
