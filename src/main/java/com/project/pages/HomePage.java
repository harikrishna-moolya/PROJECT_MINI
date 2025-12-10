package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By loginLink = By.cssSelector("a[href='/login']");
    By searchBox = By.id("small-searchterms");
    By searchButton = By.cssSelector("button[type='submit'][class*='search-box-button']");
    By shoppingCartLink = By.cssSelector("a[href='/cart']");

    public HomePage(WebDriver driver){ this.driver = driver; }

    public void goToLogin(){ driver.findElement(loginLink).click(); }
    public void search(String text){
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchButton).click();
    }
    public void openCart(){ driver.findElement(shoppingCartLink).click(); }
}
