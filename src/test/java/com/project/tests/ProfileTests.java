package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void checkProfileAccess() {
        HomePage home = new HomePage(driver);
        home.goToLogin();

        LoginPage lp = new LoginPage(driver);

        // Hardcoded credentials (replace with your demo site login)
        lp.login("hari01@gmail.com", "HK@0123");

        ProfilePage profile = new ProfilePage(driver);
        Assert.assertTrue(profile.isLoggedIn(), "User should be logged in and able to access profile");
    }
}
