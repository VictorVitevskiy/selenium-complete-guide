package ru.vitevskiy.guide.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@title='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//*[contains(text(),'Checkout')]")
    public WebElement cartButton;

    @FindBy(css = ".product")
    public WebElement productElement;

    public void clickHomeButton() {
        homeButton.click();
    }

    public void clickCartButton() {
       cartButton.click();
    }

    public void clickProductElement() {
        productElement.click();
    }

    public HomePage checkProductAddingToTheCart(int number) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(String.format("//span[@class='quantity'][text()='%d']", number))));

        return this;
    }
}
