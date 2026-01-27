package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By loginLink = By.cssSelector("a[href='/login']");
    By registerLink = By.cssSelector("a[href='/register']");
    By searchBox = By.id("small-searchterms");
    By shoppingCartLink = By.cssSelector("a[href='/cart']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLogin() {
        driver.findElement(loginLink).click();
    }

    public void goToRegister() {
        driver.findElement(registerLink).click();
    }

    // ✅ FIXED SEARCH METHOD
    public void search(String text) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text, Keys.ENTER);
    }

    public void searchAndAddProductToCart(String productName) {
        search(productName);
        driver.findElement(
                By.xpath("//h2[@class='product-title']/a[text()='" + productName + "']" +
                        "/ancestor::div[@class='item-box']//input[@value='Add to cart']")
        ).click();
    }

    public void openCart() {
        driver.findElement(shoppingCartLink).click();
    }
}
