package ru.vitevskiy.guide.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//button[@value='Add To Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//select/option[@value='Small']")
    private WebElement chooseProductSize;

    public void clickAddToCartButton() {
        if (isElementPresent(chooseProductSize)) {
            chooseProductSize.click();
        }
        addToCartButton.click();
    }
}
