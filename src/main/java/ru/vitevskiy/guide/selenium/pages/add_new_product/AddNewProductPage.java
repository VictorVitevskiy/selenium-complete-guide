package ru.vitevskiy.guide.selenium.pages.add_new_product;

import ru.vitevskiy.guide.selenium.pages.BasePage;

public class AddNewProductPage extends BasePage {

    private static final String GENERAL_LINK = "xpath://a[text()='General']";
    private static final String INFORMATION_LINK = "xpath://a[text()='Information']";
    private static final String PRICES_LINK = "xpath://a[text()='Prices']";
    private static final String SAVE_BUTTON = "xpath://button[@name='save']";

    public void clickGeneralLink() {
        waitForElementAndClick(
                GENERAL_LINK,
                "Can't find 'General' link"
        );
    }

    public void clickInformationLink() {
        waitForElementAndClick(
                INFORMATION_LINK,
                "Can't find 'Information' link"
        );
    }

    public void clickPricesLink() {
        waitForElementAndClick(
                PRICES_LINK,
                "Can't find 'Prices' link"
        );
    }

    public void clickSaveButton() {
        waitForElementAndClick(
                SAVE_BUTTON,
                "Can't find 'Save' button"
        );
    }
}
