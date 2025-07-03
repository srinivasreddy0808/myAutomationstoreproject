package com.myautomationstore.testcase;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.pageobjects.AccountLoginPage;
import com.myautomationstore.pageobjects.ChangePasswordPage;
import com.myautomationstore.pageobjects.IndexPage;
import com.myautomationstore.pageobjects.MyAccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChangePasswordTest extends BaseClass {
    IndexPage indexPage;
    AccountLoginPage accountLoginPage;
    MyAccountPage myAccountPage;
    ChangePasswordPage changePasswordPage;


    @BeforeEach
    public  void  setUp() {
        launchApp();
    }

    @AfterEach
    public  void  tearDown( ) {
//        driver.quit();
    }


    @Test
    public  void  changePasswordWithSamePassword( ) {

        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        changePasswordPage =myAccountPage.clickTheChangePasswordButton();
        boolean result=changePasswordPage.submitWithUpdatedPasswords("123456789","123456789","123456789");
        Assertions.assertFalse(result);
    }


    @Test
    public  void  changePasswordWithdifferentConfirmPassword( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        changePasswordPage =myAccountPage.clickTheChangePasswordButton();
        boolean result=changePasswordPage.submitWithUpdatedPasswords("123456789","123456789","123456799");
        Assertions.assertFalse(result);

    }
    @Test
    public  void  changePasswordInvalidOldPassword( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        changePasswordPage =myAccountPage.clickTheChangePasswordButton();
        boolean result=changePasswordPage.submitWithUpdatedPasswords("123456799","123456789","123456789");
        Assertions.assertFalse(result);

    }

    @Test
    public void changePasswordWithOutEnteringTheOldPassword( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        changePasswordPage =myAccountPage.clickTheChangePasswordButton();
        boolean result=changePasswordPage.submitWithUpdatedPasswords("","123456789","123456789");
        Assertions.assertFalse(result);

    }
    @Test
    public  void  changePasswordWithInvalidNewpassword( ) {
        indexPage = new IndexPage();
        accountLoginPage =indexPage.clickOnLogInOrRegisterButton();
        myAccountPage=accountLoginPage.loginWithDetails("srinivas","123456789");
        changePasswordPage =myAccountPage.clickTheChangePasswordButton();
        boolean result=changePasswordPage.submitWithUpdatedPasswords("123456789","123","123");
        Assertions.assertFalse(result);

    }
}
