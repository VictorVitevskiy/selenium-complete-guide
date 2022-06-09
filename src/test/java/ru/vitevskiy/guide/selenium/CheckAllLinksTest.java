package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckAllLinksTest extends BaseTest{

    @Test
    void checkAllLinksTest() {

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.enterAdminCredentials();
        adminLoginPage.clickLoginButton();

        List<WebElement> elementList = driver.findElements(By.xpath("//li[@id='app-']/a/span[@class='name']"));

        for (int i = 0; i < elementList.size(); i++) {
            List<WebElement> element = driver.findElements(By.xpath(String.format("(//li[@id='app-']/a/span[@class='name'])[%d]", i + 1)));
            element.get(0).click();
            Assertions.assertNotNull(driver.findElements(By.xpath("//h1")));
            List<WebElement> element1 = driver.findElements(By.xpath("//ul[@class='docs']//span[@class='name']"));
            if (element1 != null) {
                for (int i1 = 0; i1 < element1.size(); i1++) {
                    List<WebElement> element2 = driver.findElements(By.xpath(String.format("(//ul[@class='docs']//span[@class='name'])[%d]", i1 + 1)));
                    element2.get(0).click();
                    Assertions.assertNotNull(driver.findElements(By.xpath("//h1")));
                }
            }
        }
    }
}
