package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckStickerTest extends BaseTest {

    @Test
    void checkStickerPresentTest() {
        driver.get("http://localhost/litecart/");

        List<WebElement> products = driver.findElements(By.cssSelector("li.product"));

        for (WebElement product : products) {
            List<WebElement> sticker = product.findElements(By.cssSelector(".sticker"));
            assertNotNull(sticker);
        }
    }
}
