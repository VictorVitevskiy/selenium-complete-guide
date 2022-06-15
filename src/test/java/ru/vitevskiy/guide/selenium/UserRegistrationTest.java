package ru.vitevskiy.guide.selenium;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserRegistrationTest extends BaseTest {

    @Test
    void userRegistrationTest() {

        String email = getRandomEmail();
        String password = "12341234";

        driver.get("http://localhost/litecart/en/create_account");

        enterTextIntoTheField("First Name", "Anna");
        enterTextIntoTheField("Last Name", "Kozlova");
        enterTextIntoTheField("Address 1", "East street 124");
        enterTextIntoTheField("Postcode", "22334");
        enterTextIntoTheField("City", "Nampa");

        WebElement countriesList = driver.findElement(By.xpath("//td[contains(text(), 'Country')]/span[2]"));
        countriesList.click();

        WebElement selectCountry = driver.findElement(By.xpath("//input[@type='search']"));
        selectCountry.sendKeys("united states");
        selectCountry.findElement(By.xpath("./../following-sibling::span//li[1]")).click();

        enterTextIntoTheField("Email", email);
        enterTextIntoTheField("Phone", "+12223334455");
        enterTextIntoTheField("Desired Password", password);
        enterTextIntoTheField("Confirm Password", password);

        WebElement createAccount = driver.findElement(By.xpath("//button[@type='submit']"));
        createAccount.click();

        WebElement logoutAfterRegistration = driver.findElement(By.xpath("//a[text()='Logout']"));
        logoutAfterRegistration.click();

        enterTextIntoTheField("Email", email);
        enterTextIntoTheField("Password", password);

        WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));
        login.click();

        WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
        logout.click();
    }

    private void enterTextIntoTheField(String fieldName, String text) {
        WebElement firstNameField = driver.findElement(By.xpath(String.format("//td[contains(text(), '%s')]/input", fieldName)));
        firstNameField.sendKeys(text);
    }

    private String getRandomEmail() {

        String[] mailDomain = new String[] {"mail", "gmail", "yandex", "outlook"};
        String[] domain = new String[] {".ru", ".com"};

        String emailString = "xv" + RandomString.make(8).toLowerCase() + "@" +
                mailDomain[(int) (Math.random() * 4)] +
                domain[(int) (Math.random() * 2)];

        return emailString;
    }
}

