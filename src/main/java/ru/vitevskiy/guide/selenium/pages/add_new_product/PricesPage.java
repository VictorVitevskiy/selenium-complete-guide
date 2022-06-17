package ru.vitevskiy.guide.selenium.pages.add_new_product;

import ru.vitevskiy.guide.selenium.pages.BasePage;

public class PricesPage extends BasePage {

    private static final String ENTER_PRICE_FIELD = "xpath://input[@name='purchase_price']";
    private static final String SELECT_CURRENCY = "xpath://option[@value='{CURRENCY}']";


    public void enterPrice(String price) {
        waitForElementAndSendKeys(
                ENTER_PRICE_FIELD,
                price,
                "Can't find field 'Price'"
        );
    }

    public void selectCurrency(String currency) {
        waitForElementAndClick(
                SELECT_CURRENCY.replace("{CURRENCY}", currency.toUpperCase()),
                String.format("Can't select '%s'", currency)
        );
    }

}
