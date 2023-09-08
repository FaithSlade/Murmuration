package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_infoPage extends BasePage{

    public Checkout_infoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy (id="last-name")
    public WebElement lastName;

    @FindBy (id="postal-code")
    public WebElement zipCode;

    @FindBy (id="cancel")
    public WebElement cancelButton;

    @FindBy (id="continue")
    public WebElement continueButton;

    @FindBy (xpath="//button[@class='error-button']")
    public WebElement errorButton;


}
