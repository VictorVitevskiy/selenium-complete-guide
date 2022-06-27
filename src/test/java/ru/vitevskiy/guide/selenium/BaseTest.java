package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.vitevskiy.guide.selenium.app.Application;
import ru.vitevskiy.guide.selenium.util.Browser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTest {

    private static final String PATH_TO_PRODUCT_INFORMATION_PROPERTIES = "src/test/resources/productInformation.properties";

    protected WebDriver driver;
    protected Application application;

    @BeforeEach
    void start() {
        driver = Browser.getInstance().getDriver();
        application = new Application();
    }

    @AfterEach
    void stop() {
        Browser.getInstance().driverQuit();
    }

    protected String readProperty(String property) {

        Properties properties = new Properties();

        try (InputStream inputStream = Files.newInputStream(Paths.get(PATH_TO_PRODUCT_INFORMATION_PROPERTIES));
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            properties.load(inputStreamReader);
            return properties.getProperty(property);
        } catch (IOException exception) {
            System.out.println("Can't read '" + property + "' from file");
            exception.printStackTrace();
        }
        return null;
    }
}
