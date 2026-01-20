package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.CartPage;
import com.project.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(
            dataProvider = "cartData",
            dataProviderClass = TestDataProvider.class
    )
    public void addProductToCart(String productName) {

        driver.findElement(By.id("small-searchterms"))
                .sendKeys(productName, Keys.ENTER);

        driver.findElements(By.cssSelector("input[value='Add to cart']")).get(0).click();

        HomePage home = new HomePage(driver);
        home.openCart();

        CartPage cart = new CartPage(driver);
        Assert.assertFalse(cart.isCartEmpty());
    }
}
