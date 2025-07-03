package com.myautomationstore.pageobjects;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.actiondriver.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class RegisterPage extends BaseClass {
    @FindBy(xpath = "//input[@id=\"AccountFrm_firstname\"]")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_lastname\"]")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_telephone\"]")
    WebElement telePhoneInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_address_1\"]")
    WebElement address1Input;

    @FindBy(xpath = "//input[@id=\"AccountFrm_city\"]")
    WebElement cityInput;

    @FindBy(xpath = "//select[@id=\"AccountFrm_zone_id\"]")
    WebElement stateInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_postcode\"]")
    WebElement postId;

    @FindBy(xpath = "//select[@id=\"AccountFrm_country_id\"]")
    WebElement countryInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_loginname\"]")
    WebElement loginNameInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_confirm\"]")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@id=\"AccountFrm_agree\"]")
    WebElement privacyCheckBox;

    @FindBy(xpath = "//button[@title=\"Continue\"]")
    WebElement registerContinueButton;

    public RegisterPage() {
        PageFactory.initElements(driver,this);
    }


    public MyAccountPage fillMandatoryFields( ) {
        Action.type(firstNameInput,"srinivas25");
        Action.type(lastNameInput,"reddy");
        Action.type(telePhoneInput,"9390933877");
        Action.type(emailInput,"srinivas8r751125@gmail.com");
        Action.type(address1Input,"rentachintala");
        Action.type(cityInput,"guntur");
        Action.type(postId,"522426");
        Action.selectByValue(countryInput,"99");// india
        Action.selectByValue(stateInput,"1476");// andhra pradesh

        Action.type(loginNameInput,"srinivas25");
        Action.type(passwordInput,"123456789");
        Action.type(confirmPasswordInput,"123456789");
        Action.click(driver,privacyCheckBox);
        Action.click(driver,registerContinueButton);
        return  new MyAccountPage();
    }

    public MyAccountPage fillMandatoryAndNonMandatoryFields( ) {
        Action.type(firstNameInput,"srinivas20");
        Action.type(lastNameInput,"reddy");
        Action.type(emailInput,"srinivas20@gmail.com");
        Action.type(address1Input,"rentachintala");
        Action.type(cityInput,"guntur");
        Action.type(postId,"522426");
        Action.selectByValue(countryInput,"99");// india
        Action.selectByValue(stateInput,"1476");// andhra pradesh

        Action.type(loginNameInput,"srinivas20");
        Action.type(passwordInput,"123456789");
        Action.type(confirmPasswordInput,"123456789");
        Action.click(driver,privacyCheckBox);
        Action.click(driver,registerContinueButton);
        return  new MyAccountPage();
    }

    public MyAccountPage fillWithOutMandatoryFields( ) {
        Action.type(firstNameInput,"srinivas21");
        Action.type(emailInput,"srinivas21@gmail.com");
        Action.type(address1Input,"rentachintala");
        Action.type(cityInput,"guntur");
        Action.type(postId,"522426");
        Action.selectByValue(countryInput,"99");// india
        Action.selectByValue(stateInput,"1476");// andhra pradesh

        Action.type(loginNameInput,"srinivas21");
        Action.type(confirmPasswordInput,"123456789");
        Action.click(driver,privacyCheckBox);
        Action.click(driver,registerContinueButton);
        if (driver.getPageSource().contains("Your Account Has Been Created!") == false) {
            throw new RuntimeException("Account creation failed — validation did not pass");
        }
        return  new MyAccountPage();
    }

    public MyAccountPage fillWithOutPrivacyCheck( ) {
        Action.type(firstNameInput,"srinivas22");
        Action.type(emailInput,"srinivas22@gmail.com");
        Action.type(address1Input,"rentachintala");
        Action.type(cityInput,"guntur");
        Action.type(postId,"522426");
        Action.selectByValue(countryInput,"99");// india
        Action.selectByValue(stateInput,"1476");// andhra pradesh

        Action.type(loginNameInput,"sriniva22");
        Action.type(passwordInput,"123456789");

        Action.type(confirmPasswordInput,"123456789");
        Action.click(driver,registerContinueButton);
        if (driver.getPageSource().contains("Your Account Has Been Created!") == false) {
            throw new RuntimeException("Account creation failed — validation did not pass");
        }
        return  new MyAccountPage();
    }

    public MyAccountPage fillMisMatchPassword( ) {
        Action.type(firstNameInput,"srinivas23");
        Action.type(emailInput,"srinivas23@gmail.com");
        Action.type(address1Input,"rentachintala");
        Action.type(cityInput,"guntur");
        Action.type(postId,"522426");
        Action.selectByValue(countryInput,"99");// india
        Action.selectByValue(stateInput,"1476");// andhra pradesh


        Action.type(loginNameInput,"srinivas23");
        Action.type(passwordInput,"123456799");

        Action.type(confirmPasswordInput,"123456789");
        Action.click(driver,registerContinueButton);
        if (driver.getPageSource().contains("Your Account Has Been Created!") == false) {
            throw new RuntimeException("Account creation failed — validation did not pass");
        }
        return  new MyAccountPage();
    }



}
