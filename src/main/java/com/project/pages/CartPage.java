package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By cartTable = By.cssSelector("table.cart");
    By termsCheckbox = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver){ this.driver = driver; }
    public boolean isOnCart(){ return driver.findElements(cartTable).size()>0; }
    public void acceptTerms(){ if(driver.findElements(termsCheckbox).size()>0) driver.findElement(termsCheckbox).click(); }
    public void proceedToCheckout(){ driver.findElement(checkoutBtn).click(); }
}
