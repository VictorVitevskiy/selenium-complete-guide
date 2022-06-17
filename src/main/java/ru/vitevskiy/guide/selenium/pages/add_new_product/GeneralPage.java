package ru.vitevskiy.guide.selenium.pages.add_new_product;

import org.openqa.selenium.WebElement;
import ru.vitevskiy.guide.selenium.pages.BasePage;

import java.io.File;

public class GeneralPage extends BasePage {

    private static final String STATUS_ENABLED_RADIO_BUTTON = "xpath://strong[text()='Status']/following-sibling::*[2]";
    private static final String ENTER_PRODUCT_NAME_FIELD = "xpath://strong[text()='Name']/following-sibling::*/input";
    private static final String ENTER_PRODUCT_CODE_FIELD = "xpath://strong[text()='Code']/following-sibling::input";
    private static final String PRODUCT_GENDER_GROUP_TPL = "xpath://td[text()='{GENDER}']/preceding-sibling::*";
    private static final String ENTER_PRODUCT_QUANTITY_FIELD = "xpath://strong[text()='Quantity']/following-sibling::input";
    private static final String UPLOAD_PRODUCT_IMAGE_FIELD = "xpath:(//strong[text()='Upload Images']/following-sibling::*//input)[1]";
    private static final String ENTER_DATE_VALID_FROM_FIELD = "xpath://input[@name='date_valid_from']";
    private static final String ENTER_DATE_VALID_TO_FIELD = "xpath://input[@name='date_valid_to']";

    public void clickStatusEnabledRadioButton() {
        waitForElementAndClick(
                STATUS_ENABLED_RADIO_BUTTON,
                "Can't find status 'Enabled' radio button"
        );
    }

    public void enterProductName(String productName) {
        waitForElementAndSendKeys(
                ENTER_PRODUCT_NAME_FIELD,
                productName,
                "Can't find field 'Name'"
        );
    }

    public void enterProductCode(String productCode) {
        waitForElementAndSendKeys(
                ENTER_PRODUCT_CODE_FIELD,
                productCode,
                "Can't find field 'Code'"
        );
    }

    public void selectFemaleGender() {
        clickGenderCheckbox("Female");
    }

    public void selectMaleGender() {
        clickGenderCheckbox("Male");
    }

    public void selectUnisexGender() {
        clickGenderCheckbox("Unisex");
    }

    public void enterProductQuantity(String quantity) {
        waitForElementAndSendKeys(
                ENTER_PRODUCT_QUANTITY_FIELD,
                quantity,
                "Can't find field 'Quantity'"
        );
    }

    public void uploadProductImage() {
        File image = new File("src/main/resources/images/Lego.jpeg");
        waitForElementAndSendKeys(
                UPLOAD_PRODUCT_IMAGE_FIELD,
                image.getAbsolutePath(),
                "Can't upload image"
        );
    }

    public void enterDateValidFrom(String date) {
        waitForElementAndSendKeys(
                ENTER_DATE_VALID_FROM_FIELD,
                date,
                "Can't find field 'Date valid from'"
        );
    }

    public void enterDateValidTo(String date) {
        waitForElementAndSendKeys(
                ENTER_DATE_VALID_TO_FIELD,
                date,
                "Can't find field 'Date valid to'"
        );
    }


    private void clickGenderCheckbox(String gender) {
        String genderLocator = getGenderLocator(gender);
        waitForElementAndClick(
                genderLocator,
                String.format("Can't find %s gender checkbox", gender)
        );
    }

    private String getGenderLocator(String gender) {
        return PRODUCT_GENDER_GROUP_TPL.replace("{GENDER}", gender);
    }
}
