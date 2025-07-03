package com.myautomationstore.pageobjects;

import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourOrderProcessed extends BaseClass {
    @FindBy(xpath = "//span[@class=\"maintext\"]")
    WebElement orderProcessedText;

    public YourOrderProcessed ( ) {
        PageFactory.initElements(driver,this);
    }
    public String getOrderProcessedtext( ) {
        return orderProcessedText.getText();
    }

}
