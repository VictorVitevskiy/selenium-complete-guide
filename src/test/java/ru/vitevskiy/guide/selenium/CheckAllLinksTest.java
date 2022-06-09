package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.Test;

public class CheckAllLinksTest extends BaseTest{

    @Test
    void checkAllLinksTest() {

        AdminLoginPage adminLoginPage = new AdminLoginPage();
        adminLoginPage.enterAdminCredentials();
        adminLoginPage.clickLoginButton();

        LiteCartAdminPage adminPage = new LiteCartAdminPage();
        adminPage.openLinkByTitle("Appearence").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Template").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Logotype").checkForHeaderPresent();
        adminPage.openLinkByTitle("Catalog").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Product Groups").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Option Groups").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Manufacturers").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Suppliers").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Delivery Statuses").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Sold Out Statuses").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Quantity Units").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("CSV Import/Export").checkForHeaderPresent();
        adminPage.openLinkByTitle("Countries").checkForHeaderPresent();
        adminPage.openLinkByTitle("Currencies").checkForHeaderPresent();
        adminPage.openLinkByTitle("Customers").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("CSV Import/Export").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Newsletter").checkForHeaderPresent();
        adminPage.openLinkByTitle("Geo Zones").checkForHeaderPresent();
        adminPage.openLinkByTitle("Languages").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Storage Encoding").checkForHeaderPresent();
        adminPage.openLinkByTitle("Modules").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Customer").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Shipping").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Payment").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Order Total").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Order Success").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Order Action").checkForHeaderPresent();
        adminPage.openLinkByTitle("Orders").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Order Statuses").checkForHeaderPresent();
        adminPage.openLinkByTitle("Pages").checkForHeaderPresent();
        adminPage.openLinkByTitle("Reports").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Most Sold Products").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Most Shopping Customers").checkForHeaderPresent();
        adminPage.openLinkByTitle("Settings").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Defaults").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("General").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Listings").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Images").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Checkout").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Advanced").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Security").checkForHeaderPresent();
        adminPage.openLinkByTitle("Slides").checkForHeaderPresent();
        adminPage.openLinkByTitle("Tax").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Tax Rates").checkForHeaderPresent();
        adminPage.openLinkByTitle("Translations").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("Scan Files").checkForHeaderPresent();
        adminPage.openNestedLinkByTitle("CSV Import/Export").checkForHeaderPresent();
        adminPage.openLinkByTitle("Users").checkForHeaderPresent();
        adminPage.openLinkByTitle("vQmods").checkForHeaderPresent();
    }
}
