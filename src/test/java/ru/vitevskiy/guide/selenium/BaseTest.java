package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/victor/IdeaProjects/selenium-complete-guide/drivers/chromedriver");
        driver = new ChromeDriver();
        driver = new SafariDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    public static void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
