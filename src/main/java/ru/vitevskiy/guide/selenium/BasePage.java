package ru.vitevskiy.guide.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class BasePage {

    private static final WebDriver driver = Browser.getDriver();

    private static final long DEFAULT_TIMEOUT = 5;

    protected WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(getLocatorByString(locator)));
    }

    protected WebElement waitForElementPresent(String locator, String errorMessage) {
        return waitForElementPresent(locator, errorMessage, DEFAULT_TIMEOUT);
    }

    protected WebElement waitForElementAndClick(String locator, String errorMessage, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }
    protected WebElement waitForElementAndClick(String locator, String errorMessage) {
        return waitForElementAndClick(locator, errorMessage, DEFAULT_TIMEOUT);
    }

    protected WebElement waitForElementAndSendKeys(String locator, String value, String errorMessage, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    protected WebElement waitForElementAndSendKeys(String locator, String value, String errorMessage) {
        return waitForElementAndSendKeys(locator, value, errorMessage, DEFAULT_TIMEOUT);
    }

    private By getLocatorByString(String locatorWithType) {

        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String type = explodedLocator[0];
        String locator = explodedLocator[1];

        switch (type) {
            case "xpath":
                return By.xpath(locator);
            case "id":
                return By.id(locator);
            case "css":
                return By.cssSelector(locator);
            default:
                throw new IllegalArgumentException("Cannot get typ of locator. Locator: " + locatorWithType);
        }
    }
}
