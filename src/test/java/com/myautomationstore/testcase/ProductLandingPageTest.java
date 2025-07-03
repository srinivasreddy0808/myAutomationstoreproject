package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductLandingPageTest extends BaseClass  {
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
    public void modelInfoIsCorrectlyDisplaying( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        productLandingPage.setQuantityAndAddToCart("2");
        Assertions.assertEquals("558003",productLandingPage.getModelInformation());

    }


    @Test
    public  void  validateQuantityChangesLeadsTotalPrice() {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        productLandingPage.setQuantityAndAddToCart("2");
        double quantity = Double.parseDouble(productLandingPage.getTotalQuantity());
        double totalPrice = productLandingPage.getTotalPrice();
        double unitPrice=productLandingPage.getUnitPrice();

        Assertions.assertTrue(totalPrice == (unitPrice*quantity));

    }
    @Test
    public  void  addAndRemoveWhishlistWorkingOrnot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        productLandingPage.setQuantityAndAddToCart("2");
        productLandingPage.addToWhishList();
        productLandingPage.removeWishList();

    }


}
