package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    // Locators
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");
    private By successMsg = By.cssSelector(".result");
    private By errorMsg = By.cssSelector("div.validation-summary-errors");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMale).click();
        } else {
            driver.findElement(genderFemale).click();
        }
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        driver.findElement(confirmPassword).sendKeys(pass);
    }

    public void clickRegister() {
        driver.findElement(registerBtn).click();
    }

    // For valid registration
    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }

    // For invalid registration
    public String getErrorMessage() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return ""; // no error found
        }
    }
}
