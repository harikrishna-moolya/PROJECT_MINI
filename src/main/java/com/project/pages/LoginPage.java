package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By email = By.id("Email");
    By password = By.id("Password");
    By loginBtn = By.cssSelector("input.button-1.login-button");

    public LoginPage(WebDriver driver){ this.driver = driver; }

    public void login(String user, String pass){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
