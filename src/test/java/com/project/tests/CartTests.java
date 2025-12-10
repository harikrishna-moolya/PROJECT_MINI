package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCart() {
        HomePage home = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Clear search, type product
            By searchBox = By.id("small-searchterms");
            WebElement searchInput = driver.findElement(searchBox);
            searchInput.clear();
            searchInput.sendKeys("14.1-inch Laptop");
            searchInput.sendKeys(Keys.ESCAPE);  // close dropdown
            searchInput.sendKeys(Keys.ENTER);    // submit search

            // Wait until Add to cart button is clickable
            By addToCartBtn = By.cssSelector("input[value='Add to cart']");
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

            // Click first Add to cart button
            driver.findElements(addToCartBtn).get(0).click();

            // Wait for cart overlay / success popup to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));

            // Open cart
            home.openCart();

            CartPage cp = new CartPage(driver);
            Assert.assertTrue(cp.isOnCart(), "Should be on cart page");

        } catch (Exception e) {
            Assert.fail("Failed to add product to cart: " + e.getMessage());
        }
    }
}
