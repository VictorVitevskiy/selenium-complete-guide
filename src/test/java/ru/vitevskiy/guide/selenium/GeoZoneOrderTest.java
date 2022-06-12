package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;

public class GeoZoneOrderTest extends BaseTest {

    @BeforeEach
    void start() {
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.enterAdminCredentials();
        adminLoginPage.clickLoginButton();
    }

    @Test
    void geoZoneOrderCanada() {

        Comparator<String> comparator = String::compareTo;
        int elementNumber = driver.findElements(By.xpath("//tr[@class='row']")).size();

        for (int i = 1; i <= elementNumber; i++) {
            WebElement element = driver.findElement(By.xpath(String.format("(//tr[@class='row'])[%d]", i)));
            element.findElement(By.xpath("./td[3]/a")).click();

            List<WebElement> elementList = driver.findElements(By.xpath("//select[contains(@name, 'zone_code')]/option[@selected]"));

            for (int j = 0; j < elementList.size() - 1; j++) {
                Assertions.assertTrue(
                        comparator.compare(elementList.get(j).getText(), elementList.get(j + 1).getText()) < 0);
            }
            if (i == elementNumber) {
                break;
            }
            driver.findElement(By.xpath("//span[contains(text(),'Geo Zones')]")).click();
        }
    }
}
