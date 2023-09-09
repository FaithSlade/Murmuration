package com.products.pages;

import com.products.utilities.BrowserUtil;
import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

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

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCartButton;

    /**
     * add List<WebElement> random using class(java)
     */
    public void addRandomElement (List<WebElement> addToCartButton,int numberOfClick) {
        Random random = new Random();
        for (int i = 0; i < numberOfClick; i++) {
            int randomIndex = random.nextInt(addToCartButton.size()); // add a random index
            WebElement element = addToCartButton.get(randomIndex);
            element.click();
            BrowserUtil.waitFor(3);
        }


    }
}
