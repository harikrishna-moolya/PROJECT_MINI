package com.project.tests;


import com.project.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTests extends BaseTest {


    @Test
    public void verifyUserRegistration() {
        driver.get("https://demowebshop.tricentis.com/register");


        RegistrationPage reg = new RegistrationPage(driver);


        reg.selectGender("male");
        reg.enterFirstName("Hari");
        reg.enterLastName("Krishna");
        reg.enterEmail("hari01@gmail.com");
        reg.enterPassword("HK@0123");
        reg.enterConfirmPassword("HK@0123");
        reg.clickRegister();


        String msg = reg.getSuccessMessage();
        Assert.assertTrue(msg.contains("Your registration completed"), "Registration failed!");
    }
}