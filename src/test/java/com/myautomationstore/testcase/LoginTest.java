package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.AccountLoginPage;
import com.myautomationstore.pageobjects.IndexPage;
import com.myautomationstore.pageobjects.MyAccountPage;
import com.myautomationstore.pageobjects.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseClass {

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
    public  void  logInWithValid( ) {
        indexPage = new IndexPage();
         accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
         myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        Assertions.assertEquals(myAccountPage.getMaintext(),"My Account".toUpperCase());


    }

    @Test
    public  void logInWithInvalidUserName( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        Assertions.assertThrows(Exception.class,()-> {
            accountLoginPage.loginWithDetails("srinivasinvalid","123456789");
        });


    }

    @Test
    public  void logInWithInvalidPassword( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        Assertions.assertThrows(Exception.class,()-> {
            accountLoginPage.loginWithDetails("srinivas","123456799");
        });


    }

}
