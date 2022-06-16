package ru.vitevskiy.guide.selenium.pages;

import ru.vitevskiy.guide.selenium.pages.BasePage;

public class AdminLoginPage extends BasePage {

    private static final String ADMIN_USERNAME_FIELD = "css:[name=username]";
    private static final String ADMIN_PASSWORD_FIELD = "css:[name=password]";
    private static final String LOGIN_BUTTON = "css:[name=login]";

    public void enterAdminCredentials() {
        enterAdminUsername();
        enterAdminPassword();
    }

    public void clickLoginButton() {
        waitForElementAndClick(
                LOGIN_BUTTON,
                "Cannot find field login button"
        );
    }

    private void enterAdminUsername() {
        waitForElementAndSendKeys(
                ADMIN_USERNAME_FIELD,
                "admin",
                "Cannot find field to enter admin username"
        );
    }

    private void enterAdminPassword() {
        waitForElementAndSendKeys(
                ADMIN_PASSWORD_FIELD,
                "admin",
                "Cannot find field to enter admin password"
        );
    }
}
