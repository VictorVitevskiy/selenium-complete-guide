package ru.vitevskiy.guide.selenium;

public class LiteCartAdminPage extends BasePage {

    private static final String LINK_LOCATOR_TPL = "xpath://span[contains(text(),'{LINK_TITLE}')]";
    private static final String NESTED_LINK_LOCATOR_TPL = "xpath://ul[@class='docs']//span[contains(text(),'{NESTED_LINK_TITLE}')]";
    private static final String CHECK_FOR_HEADER = "xpath://h1";

    public LiteCartAdminPage openLinkByTitle(String linkTitle) {
        String linkLocator = getLinkLocatorByTitle(linkTitle);
        this.waitForElementAndClick(
                linkLocator,
                "Cannot find link " + linkTitle
        );
        return this;
    }

    public LiteCartAdminPage openNestedLinkByTitle(String nestedLinkTitle) {
        String linkLocator = getNestedLinkLocatorByTitle(nestedLinkTitle);
        this.waitForElementAndClick(
                linkLocator,
                "Cannot find link " + nestedLinkTitle
        );
        return this;
    }

    public void checkForHeaderPresent() {
        waitForElementPresent(
                CHECK_FOR_HEADER,
                "Header not found"
        );
    }

    private static String getLinkLocatorByTitle(String linkTitle) {
        return LINK_LOCATOR_TPL.replace("{LINK_TITLE}", linkTitle);
    }

    private static String getNestedLinkLocatorByTitle(String nestedLinkTitle) {
        return NESTED_LINK_LOCATOR_TPL.replace("{NESTED_LINK_TITLE}", nestedLinkTitle);
    }
}
