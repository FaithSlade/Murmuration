package com.products.pages;

import com.products.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_label']//a")
    public List<WebElement> itemsName;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(xpath = "//img[@class='inventory_item_img']")
    public List<WebElement> itemsImg;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    public WebElement productsDetails;

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCartButton;

    @FindBy(xpath = "//button[.='Remove']")
    public List<WebElement> removeButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> itemsPrice;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement productsTitle;

    @FindBy(xpath = "//div[@class='inventory_item']//a//div")
    public List<WebElement> actualItemSort;

    @FindBy(className = "product_sort_container")
    public WebElement sortedButton;


    /**
     * - Convert List<String> and List<WebElement> to verify Sorted items by name
     */
    public List<String> SortedItems() {
        List<String> actualSorted = new ArrayList<>();
        for (WebElement eachItem : actualItemSort) {
            actualSorted.add(eachItem.getText());
        }
        return actualSorted;
    }

    /**
     * - Convert List<Double> and List<WebElement> to verify Sorted items by price
     */
    public List<Double> SortedItemsByPrice() {
        List<Double> actualSortedPrice = new ArrayList<>();
        for (WebElement eachItem : itemsPrice) {
            String text = eachItem.getText().substring(1);
            double value = Double.parseDouble(text);
            actualSortedPrice.add(value);
        }
        return actualSortedPrice;
    }

    public WebElement EachItemClickByName() {
        WebElement lastItem = null;
        for (int i = 0; i < itemsName.size(); i++) {
            WebElement eachItem = itemsName.get(i);
            eachItem.click();
            lastItem = eachItem; // Store last clicked item
        }
        return lastItem;
    }

}
