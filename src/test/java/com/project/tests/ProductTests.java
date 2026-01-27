package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.HomePage;
import com.project.pages.ProductPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(
            dataProvider = "searchData",
            dataProviderClass = TestDataProvider.class
    )
    public void searchAndOpenProduct(String productName, boolean shouldExist) {

        // Search from HomePage (correct responsibility)
        HomePage home = new HomePage(driver);
        home.search(productName);

        // Count search results
        int results = driver.findElements(
                By.xpath("//h2[@class='product-title']/a[text()='" + productName + "']")
        ).size();

        if (shouldExist) {

            Assert.assertTrue(
                    results > 0,
                    "Expected product to be displayed for valid search"
            );

            // Open product
            driver.findElement(
                    By.xpath("//h2[@class='product-title']/a[text()='" + productName + "']")
            ).click();

            // Product-specific actions
            ProductPage productPage = new ProductPage(driver);
            productPage.addToCart();

        } else {

            Assert.assertEquals(
                    results,
                    0,
                    "No products should be displayed for invalid search"
            );
        }
    }
}
