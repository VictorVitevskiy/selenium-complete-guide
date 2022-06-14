package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class CheckProductPageTest extends BaseTest {

    private WebElement productLink;

    @BeforeEach
    void start() {
        super.start();
        driver.get("http://localhost/litecart/");
        productLink = driver.findElement(By.cssSelector("div#box-campaigns a.link"));
    }

    @Test
    void checkProductNameTest() {

        String productNameMainPage = productLink.findElement(By.cssSelector(".name")).getText();
        productLink.click();
        String productNameProductPage = driver.findElement(By.cssSelector("h1.title")).getText();

        assertEquals(productNameMainPage, productNameProductPage);
    }

    @Test
    void checkProductPrice() {

        String regularPriceMainPage = productLink.findElement(By.cssSelector(".regular-price")).getText();
        String salePriceElementMainPage = productLink.findElement(By.cssSelector(".campaign-price")).getText();

        productLink.click();

        String regularPriceProductPage = driver.findElement(By.cssSelector(".information .regular-price")).getText();
        String salePriceElementProductPage = driver.findElement(By.cssSelector(".information .campaign-price")).getText();

        assertAll(
                () -> assertEquals(regularPriceMainPage, regularPriceProductPage),
                () -> assertEquals(salePriceElementMainPage, salePriceElementProductPage)
        );
    }

    @Test
    void checkRegularPriceTest() {

        WebElement priceElementMainPage = productLink.findElement(By.cssSelector(".regular-price"));

        String[] regularPriceColorMainPage = priceElementMainPage.getCssValue("color").split("[^\\d]+");
        String crossedOutMainPage = priceElementMainPage.getTagName();

        productLink.click();

        WebElement priceElementProductPage = driver.findElement(By.cssSelector(".information .regular-price"));

        String[] regularPriceColorProductPage = priceElementProductPage.getCssValue("color").split("[^\\d]+");
        String crossedOutProductPage = priceElementProductPage.getTagName();

        assertAll(
                () -> assertEquals(regularPriceColorMainPage[1], regularPriceColorMainPage[2]),
                () -> assertEquals(regularPriceColorMainPage[1], regularPriceColorMainPage[3]),
                () -> assertEquals("s", crossedOutMainPage),
                () -> assertEquals(regularPriceColorProductPage[1], regularPriceColorProductPage[2]),
                () -> assertEquals(regularPriceColorProductPage[1], regularPriceColorProductPage[3]),
                () -> assertEquals("s", crossedOutProductPage)
        );
    }

    @Test
    void checkCampaignPriceTest() {

        WebElement campaignPriceMainPage = productLink.findElement(By.cssSelector(".campaign-price"));
        String[] campaignPriceColorMainPage = campaignPriceMainPage.getCssValue("color").split("[^\\d]+");
        String boldMainPage = campaignPriceMainPage.getTagName();

        productLink.click();

        WebElement campaignPriceProductPage = driver.findElement(By.cssSelector(".information .campaign-price"));
        String[] campaignPriceColorProductPage = campaignPriceProductPage.getCssValue("color").split("[^\\d]+");
        String boldProductPage = campaignPriceProductPage.getTagName();

        assertAll(
                () -> assertEquals("0", campaignPriceColorMainPage[2]),
                () -> assertEquals("0", campaignPriceColorMainPage[3]),
                () -> assertEquals("strong", boldMainPage),
                () -> assertEquals("0", campaignPriceColorProductPage[2]),
                () -> assertEquals("0", campaignPriceColorProductPage[3]),
                () -> assertEquals("strong", boldProductPage)
        );
    }

    @Test
    void checkPriceSizeTest() {

        double regularPriceSizeMainPage = Double.parseDouble(
                productLink
                        .findElement(By.cssSelector(".regular-price"))
                        .getCssValue("font-size")
                        .replaceAll("[a-zA-Z]", "")
        );

        double salePriceSizeMainPage = Double.parseDouble(
                productLink
                        .findElement(By.cssSelector(".campaign-price"))
                        .getCssValue("font-size")
                        .replaceAll("[a-zA-Z]", "")
        );

        productLink.click();

        double regularPriceSizeProductPage = Double.parseDouble(
                driver
                        .findElement(By.cssSelector(".information .regular-price"))
                        .getCssValue("font-size")
                        .replaceAll("[a-zA-Z]", "")
        );

        double salePriceSizeProductPage = Double.parseDouble(
                driver
                        .findElement(By.cssSelector(".information .campaign-price"))
                        .getCssValue("font-size")
                        .replaceAll("[a-zA-Z]", "")
        );

        assertAll(
                () -> assertTrue(salePriceSizeMainPage > regularPriceSizeMainPage),
                () -> assertTrue(salePriceSizeProductPage > regularPriceSizeProductPage)
        );
    }
}
