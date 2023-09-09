package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CartPage extends BasePage{

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "remove-sauce-labs-backpack")
    public WebElement backpackRemove;

    @FindBy(name = "remove-sauce-labs-bike-light")
    public WebElement bikeLightRemove;

    @FindBy(name = "remove-sauce-labs-fleece-jacket")
    public WebElement jacketRemove;

    @FindBy(name = "remove-sauce-labs-bolt-t-shirt")
    public WebElement tShirtRemove;

    @FindBy(name = "remove-sauce-labs-onesie")
    public WebElement oneSieRemove;

    @FindBy(name = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement allThingsRemove;

    @FindBy(xpath = "//button[.='Remove']")
    public List<WebElement> removeItemsButton;

    @FindBy (id="checkout")
    public WebElement checkoutButton;

    @FindBy (id="continue-shopping")
    public WebElement continueShoppingButton;

    /**
     * remove List<WebElement> random using class(java)
     */
    public WebElement removeRandomElement (List<WebElement> removeItemsButton){
        if(removeItemsButton.isEmpty()){
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(removeItemsButton.size()); // Generate a random index
        WebElement removeElement = removeItemsButton.remove(randomIndex); // Remove the element and store
      return removeElement;
    }

}
