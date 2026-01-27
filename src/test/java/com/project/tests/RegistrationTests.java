package com.project.tests;

import com.project.dataprovider.TestDataProvider;
import com.project.pages.HomePage;
import com.project.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test(
            dataProvider = "registrationData",
            dataProviderClass = TestDataProvider.class
    )
    public void registerUser(
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword,
            boolean expectedResult) {

        HomePage home = new HomePage(driver);
        home.goToRegister();

        RegistrationPage reg = new RegistrationPage(driver);
        reg.selectGender(gender);
        reg.enterFirstName(firstName);
        reg.enterLastName(lastName);
        reg.enterEmail(email);
        reg.enterPassword(password);
        reg.enterConfirmPassword(confirmPassword);
        reg.clickRegister();

        if (expectedResult) {

            Assert.assertTrue(
                    reg.getSuccessMessage().toLowerCase().contains("completed"),
                    "Registration should be successful with valid data"
            );

        } else {

            Assert.assertTrue(
                    driver.getCurrentUrl().contains("register"),
                    "User should remain on registration page for invalid data"
            );
        }
    }
}
