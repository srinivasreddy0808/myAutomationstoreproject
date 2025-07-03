package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BaseClass {
    @FindBy(xpath = "//span[@class=\"maintext\"]")
    WebElement mainText;

    @FindBy(xpath = "//ul[@class=\"side_account_list\"]/li[4]/a")
    WebElement changePasswordButton;

    public  MyAccountPage( ) {
        PageFactory.initElements(driver,this);
    }

    public  String getMaintext() {
        return  mainText.getText();
    }


    public  ChangePasswordPage clickTheChangePasswordButton( ) {
        Action.click(driver,changePasswordButton);
        return  new ChangePasswordPage();
    }

}
