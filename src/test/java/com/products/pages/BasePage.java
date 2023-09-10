package com.products.pages;


import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartLink;

    @FindBy(xpath = "//a[@class='shopping_cart_link']//span[@class='shopping_cart_badge']")
    public WebElement shoppingCartBadge;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCartBadgeEmpty;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    public WebElement menuButton;

    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    public WebElement closeMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetLink;

    @FindBy (xpath ="//span[@class='title']")
    public WebElement title;
}
