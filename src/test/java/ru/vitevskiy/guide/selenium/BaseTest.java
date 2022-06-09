package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseTest {

    public static WebDriver driver = Browser.getDriver();

//    @BeforeEach
//    public void start(){
//        driver.get("http://localhost/litecart/admin/");
//    }

    @AfterEach
    public void stop() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator) != null;
    }
}
