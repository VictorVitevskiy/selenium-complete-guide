package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.vitevskiy.guide.selenium.pages.AdminLoginPage;
import ru.vitevskiy.guide.selenium.pages.CatalogPage;
import ru.vitevskiy.guide.selenium.pages.add_new_product.AddNewProductPage;
import ru.vitevskiy.guide.selenium.pages.add_new_product.GeneralPage;
import ru.vitevskiy.guide.selenium.pages.add_new_product.InformationPage;
import ru.vitevskiy.guide.selenium.pages.add_new_product.PricesPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNewProductTest extends BaseTest {

    @Override
    @BeforeEach
    void start() {
        super.start();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.enterAdminCredentials();
        adminLoginPage.clickLoginButton();
    }

    @Test
    void addNewProductTest() {

        String productName = "Lego";

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickAddNewProductButton();

        AddNewProductPage addNewProductPage = new AddNewProductPage();
        addNewProductPage.clickGeneralLink();

        GeneralPage generalPage = new GeneralPage();
        generalPage.clickStatusEnabledRadioButton();
        generalPage.enterProductName(productName);
        generalPage.enterProductCode("112233");
        generalPage.selectUnisexGender();
        generalPage.enterProductQuantity("100");
        generalPage.uploadProductImage();
        generalPage.enterDateValidFrom("22.06.2022");
        generalPage.enterDateValidTo("22.06.2023");

        addNewProductPage.clickInformationLink();

        InformationPage informationPage = new InformationPage();
        informationPage.chooseManufacture();
        informationPage.enterKeywords(readProperty("keywords"));
        informationPage.enterShortDescription(readProperty("shortDescription"));
        informationPage.enterDescription(readProperty("description"));
        informationPage.enterHeadtitle("Pirate ship");

        addNewProductPage.clickPricesLink();

        PricesPage pricesPage = new PricesPage();
        pricesPage.enterPrice("234");
        pricesPage.selectCurrency("usd");

        addNewProductPage.clickSaveButton();

        assertEquals(1, driver.findElements(By.xpath(String.format("//a[text()='%s']", productName))).size());
    }
}
