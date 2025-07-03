package com.myautomationstore.pageobjects;

import com.myautomationstore.base.BaseClass;
import com.myautomationstore.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialsPage extends BaseClass {

    @FindBy(xpath = "//select[@id='sort']")
    WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='thumbnail']")
    List<WebElement> specialProducts;

    @FindBy(xpath = "//div[@class='thumbnail']//a[@class='prdocutname']")
    List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='thumbnail']//div[@class='price'] | //div[@class='thumbnail']//div[@class='price-old']")
    List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='rating']//img[contains(@src,'star')]")
    List<WebElement> productRatings;

    Action action = new Action();

    public SpecialsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean areSpecialProductsDisplayed() {
        return !specialProducts.isEmpty();
    }

    public void selectSortOption(String visibleText) {
        action.selectByVisibleText(visibleText, sortDropdown);
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement nameElem : productNames) {
            names.add(nameElem.getText().trim());
        }
        return names;
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElem : productPrices) {
            String priceText = priceElem.getText().replaceAll("[^a-zA-Z0-9]","");
            if (!priceText.isEmpty()) {
                prices.add(Double.parseDouble(priceText)/100);
            }
        }
        return prices;
    }




    public boolean isSortedAlphabetically() {
        List<String> names = getProductNames();
        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames, String.CASE_INSENSITIVE_ORDER);
        return names.equals(sortedNames);
    }

    public boolean isSortedByPrice() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);
        return prices.equals(sortedPrices);
    }



    public boolean isSortedAlphabeticallyDescending() {
        List<String> names = getProductNames();
        List<String> sortedNames = new ArrayList<>(names);
        sortedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return names.equals(sortedNames);
    }

    public boolean isSortedByPriceDescending() {
        List<Double> prices = getProductPrices();
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Collections.reverseOrder());
        return prices.equals(sortedPrices);
    }

}
