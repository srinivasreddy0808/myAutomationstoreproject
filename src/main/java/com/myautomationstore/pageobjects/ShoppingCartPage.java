package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BaseClass {
    @FindBy(xpath = "//a[@id=\"cart_checkout1\"]")
    WebElement checkOutButton;

    @FindBy(xpath = "//span[@class=\"maintext\"]")
    WebElement shoppingCartHeadText;

    @FindBy(xpath = "//input[@id=\"cart_quantity50\"]")
    WebElement quantityOfItem;

    @FindBy(xpath = "//table//tr[2]/td[4]")
    WebElement unitPriceOfTheItem;

    @FindBy(xpath = "//div[@class=\"container-fluid cart-info product-list\"]//table[@class=\"table table-striped table-bordered\" ]//tr[2]/td[1]/a")
    WebElement imageCell;

    @FindBy(xpath = "//div[@class=\"container-fluid cart-info product-list\"]//table[@class=\"table table-striped table-bordered\" ]//tr[2]/td[2]/a")
     WebElement linkCell;

    @FindBy(xpath = "//span[@class=\"bold totalamout\"]")
    WebElement totalPrice;


    @FindBy(xpath = "//input[@id=\"coupon_coupon\"]")
    WebElement couponInput;

    @FindBy(xpath = "//button[@id=\"apply_coupon_btn\"]")
    WebElement couponApplyButton;

    public ShoppingCartPage ( ) {
        PageFactory.initElements(driver,this);
    }
    public  CheckOutConfirmationPage checkOutTheCart( ) {
        Action.click(driver,checkOutButton);
        return new CheckOutConfirmationPage();
    }
    public String getShoppingCartHeading( ) {
        return shoppingCartHeadText.getText();
    }

    public  String getQuantityOfTheItem( ) {
        return  quantityOfItem.getAttribute("value");
    }




    public double getUnitPrice( ) {
        String  unitPrice1= unitPriceOfTheItem.getText();
        String unit= unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice= Double.parseDouble((unit));
        return finalUnitPrice/100;
    }

    public double getTotalPrice( ) {
        String totalPrice1= totalPrice.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public ShoppingCartPage applyCoupon(String coupon ) {
        Action.type(couponInput,coupon);
        Action.click(driver,couponApplyButton);
        if (driver.getPageSource().contains("Error: Coupon is either invalid, expired or reached it's usage limit!")) {
            throw new RuntimeException("error while applying the coupon");

        }
        return new ShoppingCartPage();

    }

    public ProductLandingPage imageToProductLandingPage() {
        Action.click(driver,imageCell);
        return new ProductLandingPage();
    }
    public ProductLandingPage linkToProductLandingPage() {
        Action.click(driver,linkCell);
        return  new ProductLandingPage();
    }



}
