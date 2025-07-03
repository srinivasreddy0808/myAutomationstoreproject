package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BaseClass  {
    @FindBy(xpath = "//input[@id=\"PasswordFrm_current_password\"]")
    WebElement currentPassword;

    @FindBy(xpath = "//input[@id=\"PasswordFrm_password\"]")
    WebElement newPassword;

    @FindBy(xpath = "//input[@id=\"PasswordFrm_confirm\"]" )
    WebElement newPasswordConfirm;

    @FindBy(xpath = "//button[@title=\"Continue\"]")
    WebElement continueButton;

    public  ChangePasswordPage( ) {
        PageFactory.initElements(driver,this);
    }

    public boolean  submitWithUpdatedPasswords(String currentPasswordPara,String newPasswordPara,String newPasswordConfirmPara ) {
        Action.type(currentPassword,currentPasswordPara);
        Action.type(newPassword,newPasswordPara);
        Action.type(newPasswordConfirm,newPasswordConfirmPara);
        Action.click(driver,continueButton);
        if (!driver.getPageSource().contains("Success: Your password has been successfully updated")) {
            return false;
        }
        return true;

    }


}
