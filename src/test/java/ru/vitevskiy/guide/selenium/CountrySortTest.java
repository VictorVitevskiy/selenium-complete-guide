package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.vitevskiy.guide.selenium.pages.AdminLoginPage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<String> countryNameList = new ArrayList<>();

        for (WebElement element : elementList) {
            countryNameList.add(element.getText());
        }

        for (int i = 0; i < countryNameList.size() - 1; i++) {
            assertTrue(comparator.compare(countryNameList.get(i), countryNameList.get(i + 1)) < 0);
        }
    }

    @Test
    void countryZonesAlphabeticalOrderTest() {

        Comparator<String> comparator = String::compareTo;

        String countriesWithZonesLocator = "//tr[@class='row']/td[6][not(text()='0')]/..";
        int elementNumber = driver.findElements(By.xpath(countriesWithZonesLocator)).size();

        for (int i = 1; i <= elementNumber; i++) {
            WebElement element = driver.findElement(By.xpath(String.format("(%s)[%d]", countriesWithZonesLocator, i)));
            element.findElement(By.xpath("./td[5]/a")).click();

            List<WebElement> elementList = driver.findElements(By.xpath("//a[@id='remove-zone']/../../td[3]"));
            List<String> geoZoneNameList = new ArrayList<>();

            for (WebElement webElement : elementList) {
                geoZoneNameList.add(webElement.getText());
            }

            for (int j = 0; j < geoZoneNameList.size() - 1; j++) {
                assertTrue(comparator.compare(geoZoneNameList.get(j), geoZoneNameList.get(j + 1)) < 0);
            }
            if (i == elementNumber) {
                break;
            }
            driver.findElement(By.xpath("//span[contains(text(),'Countries')]")).click();
        }
    }
}
