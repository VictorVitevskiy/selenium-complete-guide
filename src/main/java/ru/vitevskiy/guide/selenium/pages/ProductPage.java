package ru.vitevskiy.guide.selenium.pages;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART_BUTTON = "xpath://button[@value='Add To Cart']";
    private static final String CHOOSE_PRODUCT_SIZE = "xpath://select/option[@value='Small']";

    public void clickAddToCartButton() {
        if (isElementPresent(CHOOSE_PRODUCT_SIZE)) {
            waitForElementAndClick(
                    CHOOSE_PRODUCT_SIZE,
                    "Can't click product size"
            );
        }
        waitForElementAndClick(
                ADD_TO_CART_BUTTON,
                "Can't find 'Add To Cart' button"
        );
    }
}
