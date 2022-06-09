package ru.vitevskiy.guide.selenium.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROPERTIES_PATH = "/browser.properties";

    public static String getProperty(String propertyName) {
        return getPropertiesInstance().getProperty(propertyName).trim();
    }

    private static Properties getPropertiesInstance() {
        Properties instance = new Properties();
        try (InputStream resourceStream = PropertyLoader.class.getResourceAsStream(PROPERTIES_PATH)) {
            assert resourceStream != null;
            try (InputStreamReader inputStream = new InputStreamReader(resourceStream, StandardCharsets.UTF_8)) {
                instance.load(inputStream);
            }
        } catch (IOException e) {
            System.out.println("Can't read '" + "PLATFORM" + "' from file");
        }
        return instance;
    }
}
