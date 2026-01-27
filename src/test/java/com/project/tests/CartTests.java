package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.CartPage;
import com.project.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(
            dataProvider = "cartData",
            dataProviderClass = TestDataProvider.class
    )
    public void addProductToCart(String productName) {

        // Use HomePage to search and add product
        HomePage home = new HomePage(driver);
        home.searchAndAddProductToCart(productName);

        // Open cart
        home.openCart();

        // Validate cart is not empty
        CartPage cart = new CartPage(driver);
        Assert.assertFalse(cart.isCartEmpty(), "Cart should not be empty");
    }
}
