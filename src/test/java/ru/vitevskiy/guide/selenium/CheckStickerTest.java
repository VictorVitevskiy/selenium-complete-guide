package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckStickerTest extends BaseTest {

    @Test
    void checkStickerPresentTest() throws Exception {
        driver.get("http://localhost/litecart/");

        List<WebElement> products = driver.findElements(By.xpath("//*[@class='image-wrapper']"));

        for (WebElement product : products) {
            List<WebElement> sticker = product.findElements(By.xpath("./*[contains(@class, 'sticker')]"));
            if (sticker == null || sticker.size() > 1) {
                throw new Exception("Wrong number of stickers");
            }
            String stickerText = sticker.get(0).getText();
            Assertions.assertTrue(stickerText.equals("NEW") || stickerText.equals("SALE"));
        }
    }
}
