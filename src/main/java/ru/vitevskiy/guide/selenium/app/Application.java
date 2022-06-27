package ru.vitevskiy.guide.selenium.app;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.vitevskiy.guide.selenium.pages.AdminLoginPage;
import ru.vitevskiy.guide.selenium.pages.CartPage;
import ru.vitevskiy.guide.selenium.pages.HomePage;
import ru.vitevskiy.guide.selenium.pages.ProductPage;
import ru.vitevskiy.guide.selenium.util.Browser;

public class Application {

    private final AdminLoginPage adminLoginPage;
    private final CartPage cartPage;
    private final HomePage homePage;
    private final ProductPage productPage;


    public Application() {
        adminLoginPage = new AdminLoginPage();
        cartPage = new CartPage();
        homePage = new HomePage();
        productPage = new ProductPage();
    }

    public Application addProductsToCart(int number) {
        for (int i = 0; i < number;) {
            homePage.clickProductElement();
            productPage.clickAddToCartButton();
            homePage.checkProductAddingToTheCart(++i).clickHomeButton();
        }
        return this;
    }

    public Application openCart() {
        homePage.clickCartButton();
        return this;
    }

    public Application removeAllProductsFromCart() {
        int numberOfProductTypeInCart = cartPage.getNumberOfProductTypes();

        for (int i = 0; i < numberOfProductTypeInCart; ) {
            cartPage.clickRemoveButton();
            i++;
            while (true) {
                if (cartPage.getNumberOfProductTypes() == numberOfProductTypeInCart - i) {
                    break;
                }
            }
        }
        return this;
    }

    public boolean isEmptyCart() {
        return cartPage.checkForEmptyCart();
    }
}
