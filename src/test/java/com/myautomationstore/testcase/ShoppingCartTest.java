package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest extends BaseClass  {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    ProductLandingPage productLandingPage;
    ShoppingCartPage shoppingCartPage;


    @BeforeEach
    public  void  setUp() {
        launchApp();
    }

    @AfterEach
    public  void  tearDown( ) {
//        driver.quit();
    }

    @Test
    public  void  validateTotalPrice() {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("2");
        double unitPrice = shoppingCartPage.getUnitPrice();
        double totalPrice = shoppingCartPage.getTotalPrice();
        double quantity = Double.parseDouble(shoppingCartPage.getQuantityOfTheItem());
        Assertions.assertTrue(totalPrice == (unitPrice*quantity)+2);



    }
    @Test
    public void validateCoupon( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        Assertions.assertThrows(Exception.class,()-> {
            shoppingCartPage.applyCoupon("abcde");
        });

    }

    @Test
    public void imageIsRedirectingToProductLandingPage() {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        productLandingPage=shoppingCartPage.imageToProductLandingPage();
        Assertions.assertTrue(productLandingPage.getProductText().toLowerCase().contains("skinsheen"));
    }
    @Test
    public  void nameIsRedirectingTpProductLandingPage( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        productLandingPage=shoppingCartPage.linkToProductLandingPage();
        Assertions.assertTrue(productLandingPage.getProductText().toLowerCase().contains("skinsheen"));

    }




}
