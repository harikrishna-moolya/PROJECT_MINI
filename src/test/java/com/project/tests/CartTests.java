package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCart(){

        HomePage home = new HomePage(driver);

        try {
            // Clear and type product name manually to avoid dropdown issues
            By searchBox = By.id("small-searchterms");

            driver.findElement(searchBox).clear();
            driver.findElement(searchBox).sendKeys("14.1-inch Laptop");

            // Close dropdown by sending ESC (prevents overlay)
            driver.findElement(searchBox).sendKeys(Keys.ESCAPE);

            // Press Enter to search
            driver.findElement(searchBox).sendKeys(Keys.ENTER);

            // Click Add to Cart button for first product
            driver.findElements(By.cssSelector("input[value='Add to cart']")).get(0).click();

            home.openCart();

            CartPage cp = new CartPage(driver);
            Assert.assertTrue(cp.isOnCart(), "Should be on cart page");

        } catch (Exception e) {
            Assert.fail("Failed to add product to cart: " + e.getMessage());
        }
    }
}
