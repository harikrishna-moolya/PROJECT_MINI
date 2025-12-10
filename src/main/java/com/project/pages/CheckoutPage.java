package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    // Locators (placeholder)
    private By checkoutButton = By.id("checkout");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click checkout (for demo placeholder)
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
