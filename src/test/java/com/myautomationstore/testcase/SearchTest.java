package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.AccountLoginPage;
import com.myautomationstore.pageobjects.IndexPage;
import com.myautomationstore.pageobjects.MyAccountPage;
import com.myautomationstore.pageobjects.ProductLandingPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest extends BaseClass {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    ProductLandingPage productLandingPage;


    @BeforeEach
    public  void  setUp() {
        launchApp();
    }

    @AfterEach
    public  void  tearDown( ) {
//        driver.quit();
    }

    @Test
    public void searchValidProduct( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen");
        Assertions.assertTrue(productLandingPage.getProductText().toLowerCase().contains("skinsheen"));
    }

    @Test
    public void searchInvalidProduct( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        Assertions.assertThrows(Exception.class,()-> {
            indexPage.searchTheProduct("invalid");
        });

    }
    @Test
    public void searchValidProductWithUpperCase( ){
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        accountLoginPage.loginWithDetails("srinivas","123456789");
        productLandingPage=indexPage.searchTheProduct("skinsheen".toUpperCase());
        Assertions.assertTrue(productLandingPage.getProductText().toLowerCase().contains("skinsheen"));
    }

}
