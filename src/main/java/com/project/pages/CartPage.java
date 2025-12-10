package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By termsCheckbox = By.id("termsofservice");
    private By checkoutButton = By.id("checkout");
    private By cartItems = By.cssSelector(".cart-item-row"); // Each row in the cart

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Accept terms of service
    public void acceptTerms() {
        driver.findElement(termsCheckbox).click();
    }

    // Click checkout
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    //  Check if cart is empty
    public boolean isCartEmpty() {
        // If no cart items found, cart is empty
        return driver.findElements(cartItems).size() == 0;
    }

    // Optional: check if on cart page
    public boolean isOnCart() {
        return driver.getCurrentUrl().contains("cart");
    }
}
