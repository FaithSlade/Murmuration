package com.products.pages;

import com.products.utilities.BrowserUtil;
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

    @FindBy(xpath = "//button[.='Remove']")
    public List<WebElement> removeItemsButton;

    @FindBy (id="checkout")
    public WebElement checkoutButton;

    @FindBy (id="continue-shopping")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    public List<WebElement> productDetailsList;

    @FindBy(xpath = "//div[@class='cart_item']")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    public List<WebElement> cartQuantity;

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

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCartButton;

    /**
     * This method will remove List<WebElement> randomly by using Random class
     * if condition to ensure that I am not click more elements than are available.
     * This loop will iterate base on numberOfClick times.
     * Then generates a random index from List<WebElement>, and used index to select an element.
     */
    public void removeRandomElement (List<WebElement> removeItemsButton,int numberOfClick){
        if(removeItemsButton.isEmpty()){
            return;
        }
        if(numberOfClick > removeItemsButton.size()){
            numberOfClick = removeItemsButton.size();
        }
        Random random = new Random();
        for (int i = 0; i < numberOfClick; i++) {
            int randomIndex = random.nextInt(removeItemsButton.size()); // add a random index
            WebElement element = removeItemsButton.get(randomIndex); //retrieve webElement from index
            element.click();
            //BrowserUtil.waitFor(2); just for check to see it click
        }
    }

    /**
     * This method will add List<WebElement> randomly by using Random class
     * if condition to ensure that I am not click more elements than are available.
     * This loop will iterate base on numberOfClick times.
     * Then generates a random index from List<WebElement>, and used index to select an element.
     */
    public static void addRandomElement (List<WebElement> addToCartButton,int numberOfClick) {
        if (numberOfClick > addToCartButton.size()) {
            numberOfClick = addToCartButton.size();
        }
        Random random = new Random();
        for (int i = 0; i < numberOfClick; i++) {
            int randomIndex = random.nextInt(addToCartButton.size()); // add a random index
            WebElement element = addToCartButton.get(randomIndex); //retrieve webElement from index
            element.click();
            //BrowserUtil.waitFor(2); just for check to see it click
        }
    }
}
