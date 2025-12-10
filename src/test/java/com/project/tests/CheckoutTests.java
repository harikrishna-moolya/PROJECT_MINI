package com.project.tests;

import com.project.pages.CartPage;
import com.project.pages.CheckoutPage;
import com.project.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTests extends BaseTest {

    @Test
    public void testCheckoutFlow() {

        HomePage home = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Search for a product
            By searchBox = By.id("small-searchterms");
            WebElement input = driver.findElement(searchBox);
            input.clear();
            input.sendKeys("14.1-inch Laptop");
            input.sendKeys(Keys.ESCAPE); // Close dropdown
            input.sendKeys(Keys.ENTER);  // Submit search

            // Wait for "Add to cart" button to be clickable
            By addToCartBtn = By.cssSelector("input[value='Add to cart']");
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

            // Click the first "Add to cart" button
            driver.findElements(addToCartBtn).get(0).click();

            //  Wait for success notification to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));

            //  Open cart
            home.openCart();

            // Accept terms of service
            CartPage cart = new CartPage(driver);
            cart.acceptTerms();

            //  Navigate to checkout page (Demo site placeholder)
            CheckoutPage checkout = new CheckoutPage(driver);
            checkout.clickCheckout(); // Safe placeholder; demo site will stop before real order

            // Assert we are on the checkout page
            Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Should navigate to checkout page");

        } catch (Exception e) {
            Assert.fail("Checkout test failed: " + e.getMessage());
        }
    }
}
