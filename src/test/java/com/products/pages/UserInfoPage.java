package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage extends BasePage{
    public UserInfoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@class='error-button']")
    public WebElement closeErrorButton;

    @FindBy(xpath = "//h3[.='Error: Last Name is required']")
    public WebElement lastNameErrorMessage;

    @FindBy(xpath = "//h3[.='Error: First Name is required']")
    public WebElement firstErrorMessage;

    @FindBy(xpath = "//h3[.='Error: Postal Code is required']")
    public WebElement zipCodeErrorMessage;
}
