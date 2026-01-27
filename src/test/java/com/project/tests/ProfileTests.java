package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(
            dataProvider = "loginData",
            dataProviderClass = TestDataProvider.class
    )
    public void checkProfileAccess(String username, String password, boolean expectedResult) {

        // Navigate to login page
        HomePage home = new HomePage(driver);
        home.goToLogin();

        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        // Validate profile access
        ProfilePage profile = new ProfilePage(driver);

        if (expectedResult) {
            Assert.assertTrue(
                    profile.isLoggedIn(),
                    "Profile should be accessible for valid user credentials"
            );
        } else {
            Assert.assertFalse(
                    profile.isLoggedIn(),
                    "Profile should NOT be accessible for invalid user credentials"
            );
        }
    }
}
