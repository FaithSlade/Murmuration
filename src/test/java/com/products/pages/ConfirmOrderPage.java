package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConfirmOrderPage extends BasePage {

    public ConfirmOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    @FindBy (xpath="//h2[@class='complete-header']")
    public WebElement thankYouText;
}
