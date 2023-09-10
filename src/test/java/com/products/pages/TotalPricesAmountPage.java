package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

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

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCartButton;


    /**
     *
     */
    public String calculateTotalPriceOnCart(List<WebElement> priceList,int numberOfClick){
        CartPage.addRandomElement(addToCartButton,numberOfClick);

        double totalPrice = 0.0;
           for(WebElement eachPrice: priceList){
               if (eachPrice.isDisplayed()){
                   String priceText = eachPrice.getText();
                   String priceWithOut$ = priceText.substring(1);
                   double itemPrice = Double.parseDouble(priceWithOut$);
                   totalPrice += itemPrice;
               }
        }
        String totalPriceStr = String.valueOf(totalPrice);//convert double -> String
        int decimal = totalPriceStr.indexOf('.');
        if(decimal != -1 && decimal < totalPriceStr.length()-3){
            return totalPriceStr.substring(0,decimal+3);
        }
           return  totalPriceStr;
    }

    /**
     *
     */
    public String actualItemTotal(WebElement itemTotal){
        String str = itemTotal.getText();

        int dollarSign = str.indexOf('$');
        String actualTotalPrice = str.substring(dollarSign+1);

        int decimal = str.indexOf('.');
        if(decimal != -1 && decimal < str.length()-3){
            return str.substring(dollarSign+1,decimal+3);
        }
        return actualTotalPrice;
    }

    public String takeOffDollarSignAndLimitDecimal(WebElement tax){
        String numberWithText = tax.getText();

        int dollarSign = numberWithText.indexOf('$');
        String actualTotalPrice = numberWithText.substring(dollarSign+1);

        int decimal = numberWithText.indexOf('.');
        if(decimal != -1 && decimal < numberWithText.length()-3){
            return numberWithText.substring(dollarSign+1,decimal+3);
        }
        return actualTotalPrice;
    }
}
