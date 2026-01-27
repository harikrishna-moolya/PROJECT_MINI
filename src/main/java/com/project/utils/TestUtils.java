package com.project.utils;

import org.openqa.selenium.WebDriver;

public final class TestUtils {

    private TestUtils() {
        // Prevent instantiation
    }

    public static void safeQuit(WebDriver driver) {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception ignored) {
            // Intentionally ignored to avoid masking test results
        }
    }
}
