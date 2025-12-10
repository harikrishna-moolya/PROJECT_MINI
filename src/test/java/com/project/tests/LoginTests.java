package com.project.tests;

import com.project.pages.HomePage;
import com.project.pages.LoginPage;
import com.project.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials(){

        // 🔥 Hardcoded credentials here
        String username = "hari01@gmail.com";
        String password = "HK@0123";

        HomePage home = new HomePage(driver);
        home.goToLogin();

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);   // passing directly

        ProfilePage profile = new ProfilePage(driver);
        Assert.assertTrue(profile.isLoggedIn(),
                "User should be logged in (logout link present)");
    }
}
