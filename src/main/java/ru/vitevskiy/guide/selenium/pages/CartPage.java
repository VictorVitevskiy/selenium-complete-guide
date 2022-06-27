package ru.vitevskiy.guide.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//*[@class='header']/following-sibling::*/*[@class='item']")
    private List<WebElement> productTypesInCart;

    @FindBy(xpath = "//em")
    private WebElement emptyCart;

    public void clickRemoveButton() {
        removeButton.click();
    }

    public int getNumberOfProductTypes() {
         return productTypesInCart.size();
    }

    public boolean checkForEmptyCart() {
        return isElementPresent(emptyCart);
    }
}
