package ru.vitevskiy.guide.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.vitevskiy.guide.selenium.util.Browser;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void start() {
        driver = Browser.getInstance().getDriver();
    }

    @AfterEach
    void stop() {
        Browser.getInstance().driverQuit();
    }
}
