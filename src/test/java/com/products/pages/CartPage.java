package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    public List<WebElement> removeItem;

    @FindBy (id="checkout")
    public WebElement checkoutButton;

    @FindBy (id="continue-shopping")
    public WebElement continueShoppingButton;
}
