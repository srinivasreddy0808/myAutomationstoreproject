package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutConfirmationPage extends BaseClass {
    @FindBy(xpath = "//button[@title=\"Confirm Order\"]")
    WebElement confirmOrderButton;


    @FindBy(xpath = "//table[@class=\"table confirm_shippment_options\"]//tr[1]/td[1]")
    WebElement shipmentUserDetails;

    @FindBy(xpath = "//table[@class=\"table confirm_payment_options\"]//tr[1]/td[1]")
    WebElement paymentUserDetails;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div[1]/table[2]/tbody/tr[1]/td[2]/span")
    WebElement subTotalPrice;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div[1]/table[2]/tbody/tr[3]/td[2]/span")
    WebElement totalPrice;


    public CheckOutConfirmationPage( ) {
        PageFactory.initElements(driver,this);
    }

    public  YourOrderProcessed confirmOrder( ) {
        Action.click(driver,confirmOrderButton);
        return new YourOrderProcessed();
    }

    public  String getShipmentUserDetails( ) {
        return shipmentUserDetails.getText();

    }
    public String getPaymentUserDetails( ) {
        return  paymentUserDetails.getText();
    }
    public double getTotalPrice( ) {
        String totalPrice1= totalPrice.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public double getSubTotalPrice( ) {
        String totalPrice1= subTotalPrice.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }
}
