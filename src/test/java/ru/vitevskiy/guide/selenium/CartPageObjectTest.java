package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPageObjectTest extends BaseTest {

    @Override
    @BeforeEach
    void start() {
        super.start();
        driver.get("http://localhost/litecart/");
    }

    @Test
    void cartPageObjectTest() {
        assertTrue(
                application.addProductsToCart(3)
                        .openCart()
                        .removeAllProductsFromCart()
                        .isEmptyCart()
        );
    }
}
