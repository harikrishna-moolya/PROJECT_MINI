package com.project.dataprovider;

import com.project.utils.ConfigReader;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    // ---------- LOGIN / PROFILE ----------
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {
                        ConfigReader.getProperty("login.valid.email"),
                        ConfigReader.getProperty("login.valid.password"),
                        true
                },
                {
                        ConfigReader.getProperty("login.invalid.email"),
                        ConfigReader.getProperty("login.invalid.password"),
                        false
                }
        };
    }

    // ---------- PRODUCT SEARCH ----------
    @DataProvider(name = "searchData")
    public static Object[][] searchData() {
        return new Object[][]{
                {
                        ConfigReader.getProperty("product.valid.name"),
                        true
                },
                {
                        ConfigReader.getProperty("product.invalid.name"),
                        false
                }
        };
    }

    // ---------- CART / CHECKOUT ----------
    @DataProvider(name = "cartData")
    public Object[][] cartData() {
        return new Object[][]{
                { ConfigReader.getProperty("product.cart.name") }
        };
    }

    // ---------- REGISTRATION ----------
    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
                {
                        ConfigReader.getProperty("reg.valid.gender"),
                        ConfigReader.getProperty("reg.valid.firstname"),
                        ConfigReader.getProperty("reg.valid.lastname"),
                        ConfigReader.getProperty("reg.valid.email"),
                        ConfigReader.getProperty("reg.valid.password"),
                        ConfigReader.getProperty("reg.valid.password"),
                        true
                },
                {
                        ConfigReader.getProperty("reg.invalid.gender"),
                        ConfigReader.getProperty("reg.invalid.firstname"),
                        ConfigReader.getProperty("reg.invalid.lastname"),
                        ConfigReader.getProperty("reg.invalid.email"),
                        ConfigReader.getProperty("reg.invalid.password"),
                        ConfigReader.getProperty("reg.invalid.confirmpassword"),
                        false
                }
        };
    }
}
