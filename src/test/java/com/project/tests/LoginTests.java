package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(
            dataProvider = "loginData",
            dataProviderClass = TestDataProvider.class
    )
    public void loginTest(String username, String password, boolean expectedResult) {

        HomePage home = new HomePage(driver);
        home.goToLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        ProfilePage profile = new ProfilePage(driver);

        if (expectedResult) {
            Assert.assertTrue(
                    profile.isLoggedIn(),
                    "Login should succeed for valid credentials"
            );
        } else {
            Assert.assertFalse(
                    profile.isLoggedIn(),
                    "Login should fail for invalid credentials"
            );
        }
    }
}
