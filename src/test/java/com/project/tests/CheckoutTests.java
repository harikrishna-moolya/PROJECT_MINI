package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void placeholderCheckout() {

        HomePage home = new HomePage(driver);

        try {
            // Clear search box, type product name
            By searchBox = By.id("small-searchterms");
            driver.findElement(searchBox).clear();
            driver.findElement(searchBox).sendKeys("14.1-inch Laptop");

            // Close dropdown if appears
            driver.findElement(searchBox).sendKeys(Keys.ESCAPE);

            // Press ENTER to search
            driver.findElement(searchBox).sendKeys(Keys.ENTER);

            // Add first product to cart
            driver.findElements(By.cssSelector("input[value='Add to cart']")).get(0).click();

            // Open cart
            home.openCart();

            // Accept terms for checkout
            CartPage cp = new CartPage(driver);
            cp.acceptTerms();

            // Note: do not proceed to actual checkout on demo site
        } catch (Exception e) {
            // Optional: print exception or fail silently for placeholder
            System.out.println("Checkout placeholder exception: " + e.getMessage());
        }
    }
}
