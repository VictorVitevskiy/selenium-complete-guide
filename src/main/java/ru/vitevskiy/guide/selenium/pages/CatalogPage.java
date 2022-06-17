package ru.vitevskiy.guide.selenium.pages;

public class CatalogPage extends BasePage {

    private static final String ADD_NEW_PRODUCT_BUTTON = "xpath://a[contains(text(),'Add New Product')]";

    public void clickAddNewProductButton() {
        waitForElementAndClick(
                ADD_NEW_PRODUCT_BUTTON,
                "Can't find 'Add New Product' button"
        );
    }
}
