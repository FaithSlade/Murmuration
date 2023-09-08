package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage extends BasePage{

    public ConfirmPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    public WebElement completeTitle;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    public WebElement completeText;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;
}
