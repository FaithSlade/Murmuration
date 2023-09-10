package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TotalPricesAmountPage extends BasePage{

    public TotalPricesAmountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> priceList;

    @FindBy (xpath ="//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;

    @FindBy (xpath ="//div[@class='summary_tax_label']")
    public WebElement tax;

    @FindBy (xpath ="//div[@class='summary_info_label summary_total_label']")
    public WebElement totalPay;

    @FindBy (id ="finish")
    public WebElement finishButton;

    @FindBy (id ="cancel")
    public WebElement cancelButton;

    /**
     *
     */
    public double calculateTotalPrice(List<WebElement> priceList){
        double totalPrice = 0.0;
        for (WebElement each: priceList){
            String priceText = each.getText();
            double itemPrice = Double.parseDouble(priceText);
            totalPrice += itemPrice;
        }
        return totalPrice;
    }
}
