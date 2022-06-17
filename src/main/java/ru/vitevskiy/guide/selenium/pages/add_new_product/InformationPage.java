package ru.vitevskiy.guide.selenium.pages.add_new_product;

import ru.vitevskiy.guide.selenium.pages.BasePage;

public class InformationPage extends BasePage {

    private static final String MANUFACTURER_SELECTOR = "xpath://select[@name='manufacturer_id']/option[2]";
    private static final String ENTER_KEYWORDS_FIELD = "xpath://input[@name='keywords']";
    private static final String ENTER_SHORT_DESCRIPTION_FIELD = "xpath://input[contains(@name,'short_description')]";
    private static final String ENTER_DESCRIPTION_FIELD = "xpath://*[@class='trumbowyg-editor']";
    private static final String ENTER_HEAD_TITLE = "xpath://input[contains(@name,'head_title')]";

    public void chooseManufacture() {
        waitForElementAndClick(
                MANUFACTURER_SELECTOR,
                "Can't choose manufacture"
        );
    }

    public void enterKeywords(String keywords) {
        waitForElementAndSendKeys(
                ENTER_KEYWORDS_FIELD,
                keywords,
                "Can't find field 'Keywords'"
        );
    }

    public void enterShortDescription(String shortDescription) {
        waitForElementAndSendKeys(
                ENTER_SHORT_DESCRIPTION_FIELD,
                shortDescription,
                "Can't find field 'Short Description'"
        );
    }


    public void enterDescription(String description) {
        waitForElementAndSendKeys(
                ENTER_DESCRIPTION_FIELD,
                description,
                "Can't find field 'Description'"
        );
    }

    public void enterHeadtitle(String title) {
        waitForElementAndSendKeys(
                ENTER_HEAD_TITLE,
                title,
                "Can't find field 'Head Title'"
        );
    }

}
