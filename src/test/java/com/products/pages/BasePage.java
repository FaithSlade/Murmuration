package com.products.pages;

import com.products.utilities.ConfigurationReader;
import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']")
    public WebElement shoppingCartBadge;

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    public WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemLink;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartLink;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetLink;
}
