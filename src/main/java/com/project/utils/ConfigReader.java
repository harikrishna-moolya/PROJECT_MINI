package com.project.utils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();
    static {
        try (InputStream in = new FileInputStream("config/config.properties")) {
            props.load(in);
        } catch (Exception e) {
            System.out.println("Could not load config.properties: " + e.getMessage());
        }
    }
    public static String get(String key){ return props.getProperty(key); }
}
