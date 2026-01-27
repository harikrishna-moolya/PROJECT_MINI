package com.project.utils;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try {
            // Project root + config/config.properties
            String configPath = Paths.get(
                    System.getProperty("user.dir"),
                    "config",
                    "config.properties"
            ).toString();

            try (FileInputStream fis = new FileInputStream(configPath)) {
                props.load(fis);
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load config.properties from /config directory", e
            );
        }
    }

    // Backward compatible
    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
