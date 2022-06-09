package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginScenarioTest extends BaseTest {

    @Test
    void loginTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }
}
