package com.products.pages;

import com.products.utilities.BrowserUtil;
import com.products.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class ProductPage extends BasePage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> itemsName;

    @FindBy(xpath = "//div[@class='inventory_item_img']")
    public List<WebElement> itemsImage;

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCartButton;

    @FindBy(xpath = "//button[.='Remove']")
    public List<WebElement> removeButton;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> itemsPrices;

    @FindBy(className = "product_sort_container")
    public WebElement sortedButton;
    /**
     * WebElement on product detail page
     */
    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    public WebElement productsDetails;

    /**
     * Method will sort Items by price in AscendingOrder
     * This method will take List<WebElement> and convert to double[]
     * Used double[] -> because sort() method
     * with substring() -> it will take $dollar sign off
     * with parseDouble() -> it will convert to String text
     */
    public double[] expectedSortedItemsByPriceAscendingOrder() {
        double[] price = new double[itemsPrices.size()];
        for (int i = 0; i < itemsPrices.size(); i++) {
            String text = itemsPrices.get(i).getText().substring(1);
            double eachValue = Double.parseDouble(text);
            price[i] = eachValue;
        }
        Arrays.sort(price);
        return price;
    }
    /**
     * Method will sort Items by price in DescendingOrder
     * This method will take List<WebElement> and convert to double[]
     * Used double[] -> because sort() method
     * with substring() -> it will take $dollar sign off
     * with parseDouble() -> it will convert to String text
     *** After sorted price -> used reverse() method for DescendingOrder
     */
    public double[] expectedSortedItemsByPriceDescendingOrder() {
        double[] price = new double[itemsPrices.size()];
        for (int i = 0; i < itemsPrices.size(); i++) {
            String text = itemsPrices.get(i).getText().substring(1);
            double value = Double.parseDouble(text);
            price[i] = value;
        }
        Arrays.sort(price);
        double[] descendingPrice = reverseDouble(price, price.length);
        return descendingPrice;
    }
    /**
     * Method will return a new double[] with the elements in reverse order.
     * numberOfLength => double[] price.length
     */
    public double[] reverseDouble(double[] numArr, int numberOfLength) {
        double[] reverseNum = new double[numberOfLength];
        int temp = numberOfLength;
        for (int i = 0; i < numberOfLength; i++) {
            reverseNum[temp - 1] = numArr[i]; //first element will assign to last index
            temp = temp - 1;
        }
        return reverseNum;
    }
    /**
     * This method is convert List<WebElement> -> double[]
     * This method will get text values of elements from List<WebElement>
     * Then store and return in double[]
     * Ideal -> for comparison with expectedSortedItemsByPrice() method
     */
    public double[] actualSortedItemsByPrice() {
        double[] price = new double[itemsPrices.size()];
        for (int i = 0; i < itemsPrices.size(); i++) {
            String text = itemsPrices.get(i).getText().substring(1);
            double value = Double.parseDouble(text);
            price[i] = value;
        }
        return price;
    }
    /**
     * Method will sort Items by name in AscendingOrder
     * This method will take List<WebElement> and convert to String[]
     * Used String[] -> because sort() method
     */
    public String[] expectedSortedItemsByNameAscendingOrder() {
        String[] itemName = new String[itemsName.size()];
        for (int i = 0; i < itemsName.size(); i++) {
            itemName[i] = itemsName.get(i).getText();
        }
        Arrays.sort(itemName);
        return itemName;
    }
    /**
     * Method will sort Items by name in DescendingOrder
     * This method will take List<WebElement> and convert to String[]
     * Used String[] -> because sort() method
     *** After sorted price -> used reverseString() method for DescendingOrder
     */
    public String[] expectedSortedItemsByNameDescendingOrder() {
        String[] itemName = new String[itemsName.size()];
        for (int i = 0; i < itemsName.size(); i++) {
            itemName[i] = itemsName.get(i).getText();
        }
        Arrays.sort(itemName);
        String[] descendingName = reverseString(itemName, itemName.length);
        return descendingName;
    }
    /**
     * Method will return a new String[] with the elements in reverse order.
     * numberOfLength => String[] itemName.length
     */
    public String[] reverseString(String[] arr, int numberOfLength) {
        String[] reverseStr = new String[numberOfLength];
        int temp = numberOfLength;
        for (int i = 0; i < numberOfLength; i++) {
            reverseStr[temp - 1] = arr[i]; //first element will assign to last index
            temp = temp - 1;
        }
        return reverseStr;
    }
    /**
     * This method is convert List<WebElement> -> String[]
     * It will get text values of elements from List<WebElement>
     * Then store and return in String[]
     * Ideal -> for comparison with expectedSortedItemsByName() method
     */
    public String[] actualSortedItemsByName() {
        String[] itemName = new String[itemsName.size()];
        for (int i = 0; i < itemsName.size(); i++) {
            itemName[i] = itemsName.get(i).getText();
        }
        return itemName;
    }
    /**
     * This Method iterates through list of items by name
     * Then verify product detail on each item is showed
     */
    public void eachItemClickByName() {
        for (int i = 0; i < itemsName.size(); i++) {
            itemsName.get(i).click();
            Assert.assertTrue(productsDetails.isDisplayed());
            Assert.assertTrue(backToProductsButton.isDisplayed());
            backToProductsButton.click();
        }
    }
    /**
     * This Method iterates through list of items by image
     * Then verify product detail on each item is showed
     */
    public void eachItemClickByImage() {
        for (int i = 0; i < itemsImage.size(); i++) {
            itemsImage.get(i).click();
            Assert.assertTrue(productsDetails.isDisplayed());
            Assert.assertTrue(backToProductsButton.isDisplayed());
            backToProductsButton.click();
        }
    }
}
