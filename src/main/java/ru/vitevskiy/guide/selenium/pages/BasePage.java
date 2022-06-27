package ru.vitevskiy.guide.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.vitevskiy.guide.selenium.util.Browser;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

//import static ru.vitevskiy.guide.selenium.util.Browser.driver;

public class BasePage {

    protected final WebDriver driver = Browser.getInstance().getDriver();

    private static final long DEFAULT_TIMEOUT = 5;

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(getLocatorByString(locator)));
    }

    protected WebElement waitForElementPresent(WebElement element, String errorMessage, long timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElementPresent(String locator, String errorMessage) {
        return waitForElementPresent(locator, errorMessage, DEFAULT_TIMEOUT);
    }

    protected WebElement waitForElementAndClick(String locator, String errorMessage, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    protected WebElement waitForElementAndClick(WebElement element, String errorMessage, long timeoutInSeconds) {

        waitForElementPresent(element, errorMessage, timeoutInSeconds).click();
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

    protected String getElementValue(String locator, String errorMessage){
        return waitForElementPresent(locator, errorMessage).getText();
    }

    protected boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    protected List<WebElement> getAllElementsByLocator(String locator) {
        return driver.findElements(getLocatorByString(locator));
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
