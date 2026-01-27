package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.CartPage;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(
            dataProvider = "cartData",
            dataProviderClass = TestDataProvider.class
    )
    public void checkoutFlow(String productName) {

        // Add product
        HomePage home = new HomePage(driver);
        home.searchAndAddProductToCart(productName);
        home.openCart();

        CartPage cart = new CartPage(driver);
        Assert.assertFalse(cart.isCartEmpty(), "Cart should not be empty");

        // First checkout click → redirects to login
        cart.acceptTerms();
        cart.clickCheckout();

        // Login with valid credentials
        LoginPage login = new LoginPage(driver);
        login.login(
                ConfigReader.get("login.valid.email"),
                ConfigReader.get("login.valid.password")
        );

        // Accept terms AFTER login
        cart.acceptTerms();
        cart.clickCheckout();

        // Final assertion
        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout"),
                "User should be navigated to checkout page"
        );
    }
}
