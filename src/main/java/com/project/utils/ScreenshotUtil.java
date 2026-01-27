package com.project.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "screenshots";

    public static String takeScreenshot(WebDriver driver, String testName) {

        try {
            // Create screenshots directory if not exists
            File dir = new File(SCREENSHOT_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Timestamp for uniqueness
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String fileName = testName + "_" + timestamp + ".png";
            File destination = new File(dir, fileName);

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(source.toPath(), destination.toPath());

            return destination.getAbsolutePath();

        } catch (Exception e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }
}
