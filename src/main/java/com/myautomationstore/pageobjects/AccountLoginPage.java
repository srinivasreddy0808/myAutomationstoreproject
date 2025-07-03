package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountLoginPage  extends BaseClass {
    @FindBy(xpath = "//input[@id=\"loginFrm_loginname\"]")
    WebElement loginInput;

    @FindBy(xpath = "//input[@id=\"loginFrm_password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@title=\"Login\"]")
    WebElement logInButton;

    @FindBy(xpath = "//button[@title=\"Continue\"]")
    WebElement registerContinueButton;

    public AccountLoginPage() {
        PageFactory.initElements(driver,this);

    }

    public RegisterPage clickOnRegisterContinueButton() {
        Action.click(driver,registerContinueButton);
        return new RegisterPage();

    }

    public MyAccountPage loginWithDetails(String userName ,String passWord) {
      Action.type(loginInput,userName);
      Action.type(passwordInput,passWord);
      Action.click(driver,logInButton);
        // Validate if login succeeded — e.g. check if account welcome text is present
        if (!driver.getPageSource().contains("Your Account Has Been Created!") &&
                !driver.getPageSource().contains("My Account") // whatever your success page contains
        ) {
            throw new RuntimeException("Login failed: invalid username or password");
        }

        return  new MyAccountPage();


    }

}
