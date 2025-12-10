package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;
    By addToCartButton = By.cssSelector("input[value='Add to cart']");
    By productTitle = By.cssSelector("div.product-name h1");

    public ProductPage(WebDriver driver){ this.driver = driver; }

    public String getTitle(){ return driver.findElement(productTitle).getText(); }
    public void addToCart(){ driver.findElement(addToCartButton).click(); }
}
