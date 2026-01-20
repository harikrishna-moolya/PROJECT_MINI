package com.project.tests;

import com.project.dataprovider.TestDataProvider;
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

        driver.get("https://demowebshop.tricentis.com/register");

        RegistrationPage reg = new RegistrationPage(driver);
        reg.selectGender(gender);
        reg.enterFirstName(firstName);
        reg.enterLastName(lastName);
        reg.enterEmail(email);
        reg.enterPassword(password);
        reg.enterConfirmPassword(confirmPassword);
        reg.clickRegister();

        if (expectedResult) {
            Assert.assertTrue(reg.getSuccessMessage().contains("completed"));
        } else {
            Assert.assertFalse(reg.getErrorMessage().isEmpty());
        }
    }
}
