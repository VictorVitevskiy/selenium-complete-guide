package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MyFirstTest extends BaseTest {

    @Test
    void myFirstTest() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
    }
}
