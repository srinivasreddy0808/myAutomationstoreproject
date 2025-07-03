package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.AccountLoginPage;
import com.myautomationstore.pageobjects.IndexPage;
import com.myautomationstore.pageobjects.MyAccountPage;
import com.myautomationstore.pageobjects.SpecialsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpecialsPageTest extends BaseClass  {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    SpecialsPage specialsPage;


    @BeforeEach
    public  void  setUp() {
        launchApp();
    }

    @AfterEach
    public  void  tearDown( ) {
//        driver.quit();
    }

    @Test
    public  void  specialProductsDisplayedOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        specialsPage=indexPage.navigateToSpecialsPage();
        Assertions.assertTrue(specialsPage.areSpecialProductsDisplayed());

    }
    @Test
    public  void  productsSortedAlphabeticallyOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        specialsPage=indexPage.navigateToSpecialsPage();
        Assertions.assertTrue(specialsPage.isSortedAlphabetically());


    }
    @Test
    public  void  productsSortedAlphabeticallyIndescendingOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        specialsPage=indexPage.navigateToSpecialsPage();
        Assertions.assertTrue(specialsPage.isSortedAlphabeticallyDescending());


    }
    @Test
    public  void  productsSortedPriceWiseorNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        specialsPage=indexPage.navigateToSpecialsPage();
        Assertions.assertTrue(specialsPage.isSortedByPrice());



    }
    @Test
    public  void  productsSortedPriceWiseInDescendingOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        specialsPage=indexPage.navigateToSpecialsPage();
        Assertions.assertTrue(specialsPage.isSortedByPriceDescending());



    }

}
