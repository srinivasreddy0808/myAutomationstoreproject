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

public class RegisterTest extends BaseClass {
    RegisterPage registerPage;
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
    public  void registerWithMandatoryFields( ) {
        indexPage = new IndexPage();
        accountLoginPage = indexPage.clickOnLogInOrRegisterButton();
        registerPage  = accountLoginPage.clickOnRegisterContinueButton();
        myAccountPage = registerPage.fillMandatoryFields();
        Assertions.assertEquals(myAccountPage.getMaintext(),"Your Account Has Been Created!".toUpperCase());
    }
    @Test
    public void  registerWithBothMandatoryAndNonMandatory( ) {
        indexPage = new IndexPage();
        accountLoginPage = indexPage.clickOnLogInOrRegisterButton();
        registerPage  = accountLoginPage.clickOnRegisterContinueButton();
        myAccountPage = registerPage.fillMandatoryAndNonMandatoryFields();
        Assertions.assertEquals(myAccountPage.getMaintext(),"Your Account Has Been Created!".toUpperCase());

    }
    @Test
    public void  registerWithOutMandatoryFields( ) {
        indexPage = new IndexPage();
        accountLoginPage = indexPage.clickOnLogInOrRegisterButton();
        registerPage  = accountLoginPage.clickOnRegisterContinueButton();
        Assertions.assertThrows(Exception.class,()-> {
            registerPage.fillWithOutMandatoryFields();
        });


    }

    @Test
    public  void  registerWithoutPrivacycheck( ) {
        indexPage = new IndexPage();
        accountLoginPage = indexPage.clickOnLogInOrRegisterButton();
        registerPage  = accountLoginPage.clickOnRegisterContinueButton();

        Assertions.assertThrows(Exception.class,()-> {
            registerPage.fillWithOutPrivacyCheck();
        });

    }

    @Test
    public  void  registerWithMisMatch( ) {
        indexPage = new IndexPage();
        accountLoginPage = indexPage.clickOnLogInOrRegisterButton();
        registerPage  = accountLoginPage.clickOnRegisterContinueButton();

        Assertions.assertThrows(Exception.class,()-> {
            registerPage.fillMisMatchPassword();
        });


    }


}
