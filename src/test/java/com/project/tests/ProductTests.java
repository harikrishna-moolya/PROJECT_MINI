package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test
    public void searchAndOpenProduct() {

        HomePage home = new HomePage(driver);

        try {
            // Clear search box and type product
            By searchBox = By.id("small-searchterms");
            driver.findElement(searchBox).clear();
            driver.findElement(searchBox).sendKeys("14.1-inch Laptop");

            // Close dropdown if appears
            driver.findElement(searchBox).sendKeys(Keys.ESCAPE);

            // Press ENTER to search
            driver.findElement(searchBox).sendKeys(Keys.ENTER);

            // Click the first product from search results
            driver.findElements(By.cssSelector("h2.product-title a")).get(0).click();

            // Add product to cart
            ProductPage pp = new ProductPage(driver);
            pp.addToCart();

        } catch (Exception e) {
            System.out.println("Product test exception: " + e.getMessage());
        }
    }
}

