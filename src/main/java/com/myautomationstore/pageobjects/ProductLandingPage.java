package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLandingPage extends BaseClass {
    @FindBy(xpath = "//input[@id=\"product_quantity\"]")
    WebElement productQuantity;

    @FindBy(xpath = "//span[@class=\"total-price\"]")
    WebElement totalPrice;

    @FindBy(xpath = "//a[@class=\"cart\"]")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class=\"productfilneprice\"]")
    WebElement unitPrice;



    @FindBy(xpath = "//h1[@class=\"productname\"]/span")
    WebElement productName;

    @FindBy(xpath = "//div[@class=\"wishlist\"]/a[@class=\"wishlist_add btn btn-large\"]")
    WebElement wishListButton;

    @FindBy(xpath = "//a[@class=\"wishlist_remove btn btn-large\"]")
    WebElement removeWishListButton;



    @FindBy(xpath = "//ul[@class=\"productinfo\"]//li[1]")
    WebElement modelElement;



    public ProductLandingPage() {
        PageFactory.initElements(driver,this);
    }

    public  ShoppingCartPage setQuantityAndAddToCart( String quantity ) {
        Action.type(productQuantity,quantity);
        Action.click(driver,addToCartButton);
        return  new  ShoppingCartPage();

    }
    public String getProductText( ) {
        return  productName.getText();
    }

    public void clickTheWishListButton( ) {
        Action.click(driver,wishListButton);
    }


    public double getTotalPrice( ) {
        String totalPrice1= totalPrice.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public String getTotalQuantity( ){
        return  productQuantity.getText();
    }

    public double getUnitPrice( ) {
        String  unitPrice1= unitPrice.getText();
        String unit= unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice= Double.parseDouble((unit));
        return finalUnitPrice/100;
    }

    public String getModelInformation( ) {
        return modelElement.getText();
    }

    public  void addToWhishList() {
        Action.click(driver,wishListButton);
    }
    public void removeWishList( ) {
        Action.click(driver,removeWishListButton);
    }
}
