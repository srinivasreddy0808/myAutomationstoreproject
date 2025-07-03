package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckOutConfirmationTest extends BaseClass {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    ProductLandingPage productLandingPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutConfirmationPage checkOutConfirmationPage;


    @BeforeEach
    public  void  setUp() {
        launchApp();
    }

    @AfterEach
    public  void  tearDown( ) {
//        driver.quit();
    }

    @Test
    public  void  validateTheShippingDetails( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        checkOutConfirmationPage=shoppingCartPage.checkOutTheCart();

        String result = checkOutConfirmationPage.getShipmentUserDetails();
        boolean containsAlphanumeric = result != null && result.matches(".*[a-zA-Z0-9].*");
        Assertions.assertTrue(containsAlphanumeric);


    }

    @Test
    public   void  validateThePaymentDetails( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        checkOutConfirmationPage=shoppingCartPage.checkOutTheCart();

        String result = checkOutConfirmationPage.getPaymentUserDetails();
        boolean containsAlphanumeric = result != null && result.matches(".*[a-zA-Z0-9].*");
        Assertions.assertTrue(containsAlphanumeric);

    }
    @Test
    public  void  validateShippingPriceIsIncludedInTheTotalPriceorNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        checkOutConfirmationPage=shoppingCartPage.checkOutTheCart();
        double  subTotalPrice=checkOutConfirmationPage.getSubTotalPrice();
        double  totalPrice= checkOutConfirmationPage.getTotalPrice();
        Assertions.assertTrue((totalPrice-subTotalPrice) == 2.0);

    }



}
