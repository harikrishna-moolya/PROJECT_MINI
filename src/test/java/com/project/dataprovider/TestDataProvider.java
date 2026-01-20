package com.project.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    // ---------- LOGIN / PROFILE ----------
    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return new Object[][]{
                {"hari01@gmail.com", "HK@0123", true},
                {"hari07@gmail.com", "HK@0577", false},
                {"hari011@gmail.com", "HK@01234", false}
        };
    }

    // ---------- PRODUCT SEARCH ----------
    @DataProvider(name = "searchData")
    public static Object[][] searchData() {
        return new Object[][]{
                {"14.1-inch Laptop", true},
                {"NonExistingProduct123", false}
        };
    }

    // ---------- CART / CHECKOUT ----------
    @DataProvider(name = "cartData")
    public static Object[][] cartData() {
        return new Object[][]{
                {"14.1-inch Laptop"}
        };
    }

    // ---------- REGISTRATION ----------
    @DataProvider(name = "registrationData")
    public static Object[][] registrationData() {
        return new Object[][]{
                // valid
                {"male", "Hari", "Krishna", "hari_new01@gmail.com", "HK@0123", "HK@0123", true},

                // invalid
                {"female", "", "Krishna", "NOEMAIL", "123", "456", false}
        };
    }
}
