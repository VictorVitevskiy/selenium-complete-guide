package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vitevskiy.guide.selenium.pages.CartPage;
import ru.vitevskiy.guide.selenium.pages.HomePage;
import ru.vitevskiy.guide.selenium.pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends BaseTest {

    @Override
    @BeforeEach
    void start() {
        super.start();
        driver.get("http://localhost/litecart/");
    }

    @Test
    void cartTest() {

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        int productsInCart = 0;

        for (int i = 0; i < 3; i++) {
            homePage.clickProductElement();
            productPage.clickAddToCartButton();
            homePage.checkProductAddingToTheCart(++productsInCart + "");
            homePage.clickHomeButton();
        }

        homePage.clickCartButton();

        int numberOfProductTypeInCart = cartPage.getNumberOfProductTypes();

        for (int i = 0; i < numberOfProductTypeInCart; ) {
            cartPage.clickRemoveButton();
            i++;
            while (true) {
                if (cartPage.getNumberOfProductTypes() == numberOfProductTypeInCart - i) {
                    break;
                }
            }
        }

        assertTrue(cartPage.checkForEmptyCart());
    }
}
