package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.AccountLoginPage;
import com.myautomationstore.pageobjects.IndexPage;
import com.myautomationstore.pageobjects.MyAccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IndexPageTest extends BaseClass  {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;


    @BeforeEach
    public  void  setUp() {
        launchApp();
    }

    @AfterEach
    public  void  tearDown( ) {
//        driver.quit();
    }

    @Test
    public void  userIsAbleToLogOutOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
       Assertions.assertTrue( indexPage.logOutWorkingOrNot());

    }
    @Test
    public  void  userIsAbleToNavigateToFaceBookOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        Assertions.assertTrue( indexPage.navigateToFacebookOrNot());


    }

    @Test
    public void userIsAbleToNavigateToTwitterOrNot( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        Assertions.assertTrue( indexPage.navigateToTwitterorNot());
    }

}
