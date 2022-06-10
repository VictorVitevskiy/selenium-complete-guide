package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;

public class CountrySortTest extends BaseTest {

    @BeforeEach
    void openCountryPage() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.enterAdminCredentials();
        adminLoginPage.clickLoginButton();
    }

    @Test
    void countryAlphabeticalOrderTest() {

        Comparator<String> comparator = String::compareTo;
        List<WebElement> elementList = driver.findElements(By.xpath("//tr[@class='row']/td[5]/a"));

        for (int i = 0; i < elementList.size() - 1; i++) {
            Assertions.assertTrue(comparator.compare(elementList.get(i).getText(), elementList.get(i + 1).getText()) < 0);
        }
    }

    @Test
    void countryZonesAlphabeticalOrderTest() {

        Comparator<String> comparator = String::compareTo;
        int elementNumber = driver.findElements(By.xpath("//tr[@class='row']/td[6][not(text()='0')]/..")).size();

        for (int i = 1; i <= elementNumber; i++) {
            WebElement element = driver.findElement(By.xpath(String.format("(//tr[@class='row']/td[6][not(text()='0')]/..)[%d]", i)));
            element.findElement(By.xpath("./td[5]/a")).click();

            List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(@name, 'zones')][contains(@name, '[name]')]"));

            for (int j = 0; j < elementList.size() - 1; j++) {
                Assertions.assertTrue(
                        comparator.compare(elementList.get(j).getAttribute("value"), elementList.get(j + 1).getAttribute("value")) < 0);
            }
            if (i == elementNumber) {
                break;
            }
            driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
        }
    }
}
