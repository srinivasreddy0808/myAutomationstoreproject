package com.myautomationstore.pageobjects;

import com.myautomationstore.actiondriver.Action;
import com.myautomationstore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class IndexPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"customer_menu_top\"]/li/a")
     WebElement loginOrRegisterButton ;

    @FindBy(xpath = "//*[@id=\"main_menu_top\"]/li[1]/a")
    WebElement specialsButton;

    @FindBy(xpath = "//*[@id=\"main_menu_top\"]/li[2]/a/span")
    WebElement accountButton;

    @FindBy(xpath = "//*[@id=\"main_menu_top\"]/li[3]/a")
    WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"main_menu_top\"]/li[4]/a/span")
    WebElement checkOutButton;

    @FindBy(xpath = "//input[@id=\"filter_keyword\"]")
    WebElement inputSearchButton;

    @FindBy(xpath = "//div[@title=\"Go\"]/i[@class=\"fa fa-search\"]")
    WebElement searchButton;

    @FindBy(xpath = "/html/body/div/header/div[1]/div/div[2]/div/div[3]/div/ul/li[2]/ul/li[2]/a/span")
    WebElement logOutButton;

    @FindBy(xpath = "//div[@class=\"block_8\"]//a[@title=\"Facebook\"]")
    WebElement faceBookIcon;

    @FindBy(xpath = "//div[@class=\"block_8\"]//a[@title=\"Twitter\"]")
    WebElement twitterIcon;

    @FindBy(xpath = "//img[@title=\"Automation Test Store\"]")
    WebElement storeIcon;


    @FindBy(xpath = "//div[@class=\"block_6\"]//a[@class=\"dropdown-toggle\"]")
    WebElement currencyDropDown;

    @FindBy(xpath = "//div[@class=\"block_6\"]//ul[@class=\"dropdown-menu currency\"]/li[1]/a")
    WebElement euroFilterButton;

    @FindBy(xpath = "//div[@class=\"block_6\"]//ul[@class=\"dropdown-menu currency\"]/li[3]/a")
    WebElement dollarFilterButton;


    public  IndexPage() {
        PageFactory.initElements(driver,this);
    }



    public AccountLoginPage clickOnLogInOrRegisterButton( ) {
        Action.click(driver,loginOrRegisterButton);
        return new AccountLoginPage();

    }

    public ProductLandingPage  searchTheProduct( String productValue) {
        Action.type(inputSearchButton,productValue);
        Action.click(driver,searchButton);
        if (driver.getPageSource().contains("There is no product that matches the search criteria")) {
            throw new RuntimeException("Search failed: No product matched the search criteria for '" + productValue + "'");
        }
        return new ProductLandingPage();
    }

    public  boolean logOutWorkingOrNot( ) {
        Action.mouseOverElement(driver,accountButton);
        Action.click(driver,logOutButton);
        if (driver.getPageSource().contains("You have been logged off your account")) {
            return true;
        }
        return false;
    }


    public boolean navigateToFacebookOrNot() {
        String originalWindow = driver.getWindowHandle();
        Set<String> oldWindowsSet = driver.getWindowHandles();

        Action.click(driver, faceBookIcon);

        // Wait for the new tab to open (you can add explicit wait if needed)
        Set<String> newWindowsSet = driver.getWindowHandles();

        // Find the newly opened window
        newWindowsSet.removeAll(oldWindowsSet);
        if (newWindowsSet.size() != 1) {
            return false; // No new tab or multiple tabs opened
        }

        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);

        // Verify Facebook URL or title
        boolean isFacebook = driver.getCurrentUrl().contains("facebook.com") || driver.getTitle().toLowerCase().contains("facebook");

        // Close the new tab and switch back
        driver.close();
        driver.switchTo().window(originalWindow);

        return isFacebook;
    }

    public boolean navigateToTwitterorNot() {
        String originalWindow = driver.getWindowHandle();
        Set<String> oldWindowsSet = driver.getWindowHandles();

        Action.click(driver, twitterIcon);

        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);

        if (newWindowsSet.size() != 1) {
            return false;
        }

        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);

        boolean isTwitter = driver.getCurrentUrl().contains("x.com") || driver.getTitle().toLowerCase().contains("twitter");

        driver.close();
        driver.switchTo().window(originalWindow);

        return isTwitter;
    }

    public  SpecialsPage navigateToSpecialsPage( ) {
        Action.click(driver,specialsButton);
        return new SpecialsPage();
    }




}
