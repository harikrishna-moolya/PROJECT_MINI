package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(
            dataProvider = "searchData",
            dataProviderClass = TestDataProvider.class
    )
    public void searchAndOpenProduct(String productName, boolean shouldExist) {

        driver.findElement(By.id("small-searchterms"))
                .sendKeys(productName, Keys.ENTER);

        int results =
                driver.findElements(By.cssSelector("h2.product-title a")).size();

        if (shouldExist) {
            Assert.assertTrue(
                    results > 0,
                    "Expected products to be displayed for valid search"
            );

            driver.findElements(By.cssSelector("h2.product-title a"))
                    .get(0)
                    .click();

            new ProductPage(driver).addToCart();

        } else {
            Assert.assertEquals(
                    results,
                    0,
                    "No products should be displayed for invalid search"
            );
        }
    }
}
