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

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> itemsName;

    @FindBy(xpath = "//div[@class='inventory_item_img']")
    public List<WebElement> itemsImage;


    /**
     * - Convert List<String> and List<WebElement> to verify Sorted items by name
     */
    public String [] expectedSortedItemsByNameAscendingOrder() {
        String[] arr = new String[itemsName.size()];
        for (int i = 0; i < itemsName.size(); i++) {
            arr[i] = itemsName.get(i).getText();
        }
        Arrays.sort(arr);
        return arr;
    }

    public String [] expectedSortedItemsByNameDescendingOrder() {
        String[] arr = new String[itemsName.size()];
        for (int i = 0; i < itemsName.size(); i++) {
            arr[i] = itemsName.get(i).getText();
        }
        Arrays.sort(arr);
        String [] descArr = reverse(arr,arr.length);
        return descArr;
    }

    public String[] reverse(String a[], int n) {
        String[] b = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return  b;
    }

    public String[] actualSortedItemsByName() {
        String[] arr = new String[itemsName.size()];
        for (int i = 0; i < itemsName.size(); i++) {
            arr[i] = itemsName.get(i).getText();
        }
        return arr;
    }



    /**
     * - Convert List<Double> and List<WebElement> to verify Sorted items by price
     */

    public double[] expectedSortedItemsByPriceAscendingOrder() {
        double[] arr = new double[itemsPrice.size()];
        for (int i = 0; i < itemsPrice.size(); i++) {
            String text = itemsPrice.get(i).getText().substring(1);
            double value = Double.parseDouble(text);
            arr[i] = value;
        }
        Arrays.sort(arr);
        return arr;
    }

    public double[] expectedSortedItemsByPriceDescendingOrder() {
        double[] arr = new double[itemsPrice.size()];
        for (int i = 0; i < itemsPrice.size(); i++) {
            String text = itemsPrice.get(i).getText().substring(1);
            double value = Double.parseDouble(text);
            arr[i] = value;
        }
        Arrays.sort(arr);
        double [] descArr = reverse(arr,arr.length);
        return descArr;
    }

    public double[] reverse(double a[], int n) {
        double[] b = new double[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return  b;
    }

    public double[] actualSortedItemsByPrice() {
        double[] arr = new double[itemsPrice.size()];
        for (int i = 0; i < itemsPrice.size(); i++) {
            String text = itemsPrice.get(i).getText().substring(1);
            double value = Double.parseDouble(text);
            arr[i] = value;
        }
        return arr;
    }


    public void eachItemClickByName() {
        for (int i = 0; i < itemsName.size(); i++) {
            itemsName.get(i).click();
            Assert.assertTrue(productsDetails.isDisplayed());
            Assert.assertTrue(backToProductsButton.isDisplayed());
            backToProductsButton.click();
        }
    }

    public void eachItemClickByImage() {
        for (int i = 0; i < itemsImage.size(); i++) {
            itemsImage.get(i).click();
            Assert.assertTrue(productsDetails.isDisplayed());
            Assert.assertTrue(backToProductsButton.isDisplayed());
            backToProductsButton.click();
        }
    }



}
