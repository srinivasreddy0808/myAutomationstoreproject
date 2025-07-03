package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

public class AddToCartTest extends BaseClass {
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
    public void addToCartWithSingleQuantity( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        Assertions.assertEquals(shoppingCartPage.getShoppingCartHeading().toLowerCase(),"shopping cart");
    }

    @Test
    public void addToCartWithMultipleQuantity( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("2");
        Assertions.assertEquals(shoppingCartPage.getShoppingCartHeading().toLowerCase(),"shopping cart");

    }
    @Test
    public  void  addToCartWithZeroQuantity( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("0");
        Assertions.assertEquals(shoppingCartPage.getShoppingCartHeading().toLowerCase(),"shopping cart");

    }
    @Test
    public void addToCartByWhishList( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        shoppingCartPage=productLandingPage.setQuantityAndAddToCart("1");
        productLandingPage.clickTheWishListButton();
        Assertions.assertEquals(shoppingCartPage.getShoppingCartHeading().toLowerCase(),"shopping cart");

    }





}
