package ru.vitevskiy.guide.selenium.pages;

public class HomePage extends BasePage {

    private static final String HOME_BUTTON = "xpath://*[@title='Home']";
    private static final String CART_BUTTON = "xpath://*[contains(text(),'Checkout')]";
    private static final String PRODUCT_LOCATOR = "css:.product";
    private static final String CART_ADDING_ITEMS = "xpath://span[@class='quantity'][text()='{NUMBER}']";


    public void clickHomeButton() {
        waitForElementAndClick(
                HOME_BUTTON,
                "Can't find 'Home' button"
        );
    }

    public void clickCartButton() {
        waitForElementAndClick(
                CART_BUTTON,
                "Can't find 'Checkout' button"
        );
    }

    public void clickProductElement() {
        waitForElementAndClick(
                PRODUCT_LOCATOR,
                "Can't find product"
        );
    }

    public boolean checkProductAddingToTheCart(String number) {
        waitForElementPresent(
                CART_ADDING_ITEMS.replace("{NUMBER}", number),
                "Can't find number of cart adding items"
        );
        return true;
    }
}
