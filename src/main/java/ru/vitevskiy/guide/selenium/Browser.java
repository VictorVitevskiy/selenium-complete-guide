package ru.vitevskiy.guide.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static ru.vitevskiy.guide.selenium.util.PropertyLoader.getProperty;

public class Browser {

    private static final String CHROME_BROWSER = "chrome";
    private static final String SAFARI_BROWSER = "safari";
    private static final String FIREFOX_BROWSER = "firefox";
    private static final String PATH_TO_DRIVER_PACKAGE = "/Users/victor/IdeaProjects/selenium-complete-guide/drivers/chromedriver";
    private static final String TESTING_PROGRAM_URL = "http://localhost/litecart/";

    private static Browser instance;
    private static WebDriver driver;

    private Browser() {}

    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = Browser.getInstance().driverInitialization();
        }
        return driver;
    }

    private WebDriver driverInitialization() {

        if (this.isChrome()) {
            System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER_PACKAGE);
            return new ChromeDriver();
        } else if (this.isSafari()) {
            return new SafariDriver();
        } else if (this.isFirefox()) {
            return new FirefoxDriver();
        } else {
            try {
                throw new Exception("Cannot detect type of the driver. Browser value " + getPlatformVar());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isChrome() {
        return isBrowser(CHROME_BROWSER);
    }

    public boolean isSafari() {
        return isBrowser(SAFARI_BROWSER);
    }

    public boolean isFirefox() {
        return isBrowser(FIREFOX_BROWSER);
    }

    private boolean isBrowser(String myPlatform) {
        return myPlatform.equals(getPlatformVar());
    }

    public String getPlatformVar() {
        return getProperty("browser");
    }
}
