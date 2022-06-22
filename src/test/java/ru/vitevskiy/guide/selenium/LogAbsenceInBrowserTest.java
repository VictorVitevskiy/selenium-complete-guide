package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.vitevskiy.guide.selenium.pages.AdminLoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogAbsenceInBrowserTest extends BaseTest {

    @BeforeEach
    @Override
    void start() {
        super.start();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.enterAdminCredentials();
        adminLoginPage.clickLoginButton();
    }

    @Test
    void logAbsenceInBrowserTest() {

        int productElements = driver.findElements(By.xpath("//td/img/following-sibling::a")).size();

        for (int i = 1; i <= productElements; i++) {
            driver.findElement(By.xpath(String.format("(//td/img/following-sibling::a)[%d]", i))).click();
            driver.findElement(By.xpath("//*[@value='Cancel']")).click();
        }

        assertEquals(0, driver.manage().logs().get("browser").getAll().size());
    }
}
