package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Checkout_overviewPage extends BasePage {

    public Checkout_overviewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> inventoryItemPrice;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    public List<WebElement> ItemQuantity;

    @FindBy (xpath="//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;

    @FindBy (id="cancel")
    public WebElement cancelButton;

    @FindBy (id="finish")
    public WebElement finishButton;
}
