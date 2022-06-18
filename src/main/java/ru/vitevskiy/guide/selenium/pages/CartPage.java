package ru.vitevskiy.guide.selenium.pages;

public class CartPage extends BasePage {

    private static final String REMOVE_BUTTON = "xpath://button[text()='Remove']";
    private static final String PRODECT_TYPES_IN_CART = "xpath://*[@class='header']/following-sibling::*/*[@class='item']";
    private static final String EMPTY_CART = "xpath://em";

    public void clickRemoveButton() {
        waitForElementAndClick(
                REMOVE_BUTTON,
                "Can't find 'Remove' button"
        );
    }

    public int getNumberOfProductTypes() {
         return getAllElementsByLocator(PRODECT_TYPES_IN_CART).size();
    }

    public boolean checkForEmptyCart() {
        return isElementPresent(EMPTY_CART);
    }
}
