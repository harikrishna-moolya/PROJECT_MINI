package com.project.utils;
import org.openqa.selenium.WebDriver;

public class TestUtils {
    public static void safeQuit(WebDriver driver){
        try { if(driver!=null) driver.quit(); } catch(Exception ignored){}
    }
}
