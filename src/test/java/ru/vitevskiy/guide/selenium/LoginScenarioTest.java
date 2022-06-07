package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScenarioTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/victor/IdeaProjects/selenium-complete-guide/drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    public static void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    @Test
    void loginTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }
}
