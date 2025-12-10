package com.project.utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtil {
    public static String take(WebDriver driver, String name){
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String dest = "screenshots/" + name + ".png";
            new File("screenshots").mkdirs();
            Files.copy(src.toPath(), new File(dest).toPath());
            return dest;
        } catch (Exception e) {
            return null;
        }
    }
}
