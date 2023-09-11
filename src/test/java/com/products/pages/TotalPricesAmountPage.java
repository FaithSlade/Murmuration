package com.products.pages;

import com.products.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class TotalPricesAmountPage extends BasePage {

    public TotalPricesAmountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement itemTotal;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public WebElement tax;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement totalPay;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[.='Add to cart']")
    public List<WebElement> addToCartButton;

    /**
     * This Method will add item from addRandomElement()method
     * Then iterate all items price if the items price show
     * Covert that price to String to take $ sign off from text price
     * Then convert String -> double to add each item price (calculate)
     * <p>
     * After get total price : Convert double -> string to find decimal index and limit decimal in 2 digit
     * Check String totalPriceStr have decimal or not : if no skip this condition,
     * Check at least 3 characters after the decimal point.
     */
    public String calculateTotalPriceOnCart(List<WebElement> priceList, int numberOfClick) {
        CartPage.addRandomElement(addToCartButton, numberOfClick);

        double totalPrice = 0.0;
        for (WebElement eachPrice : priceList) {
            if (eachPrice.isDisplayed()) {
                String priceText = eachPrice.getText();
                String priceWithOut$ = priceText.substring(1);
                double itemPrice = Double.parseDouble(priceWithOut$);
                totalPrice += itemPrice;
            }
        }
        String totalPriceStr = String.valueOf(totalPrice);//convert double -> String
        int decimal = totalPriceStr.indexOf('.');
        if (decimal != -1 && decimal < totalPriceStr.length() - 3) {
            return totalPriceStr.substring(0, decimal + 3);
        }
        return totalPriceStr;
    }

    /**
     * This method to remove $ sign of string and limit only 2 character after decimal
     * Check String totalPriceStr have decimal or not : if no skip this condition,
     * Check at least 3 characters after the decimal point.
     * Argument as WebElement => tax, itemTotal, etc.
     */
    public String takeOffDollarSignAndLimitDecimal(WebElement number) {
        String str = number.getText();

        int dollarSign = str.indexOf('$');
        String actualTotalPrice = str.substring(dollarSign + 1);

        int decimal = str.indexOf('.');
        if (decimal != -1 && decimal < str.length() - 3) {
            return str.substring(dollarSign + 1, decimal + 3);
        }
        return actualTotalPrice;
    }

    /**
     * Method refer to calculateTotalPriceOnCart() method base on number of items in cart
     * calculate net price + tax => price after tax
     * Then compare with actual total using compareDouble() method
     */
    public void verifyTotalPayWithTax(int numberOfClick) {
        double netPrice = Double.parseDouble(calculateTotalPriceOnCart(priceList, numberOfClick));
        double texNum = Double.parseDouble(takeOffDollarSignAndLimitDecimal(tax));//String -> double
        double priceWithTax = texNum + netPrice;//calculate

        String actualPay = takeOffDollarSignAndLimitDecimal(totalPay);
        double actualTotalPay = Double.parseDouble(actualPay);

        String expectedPay = compareDouble(priceWithTax,actualTotalPay);
        Assert.assertEquals(expectedPay, takeOffDollarSignAndLimitDecimal(totalPay));
    }

    /**
     * Method compare double and return String
     * Find the different between two number and adjust the different
     */
    public String compareDouble(double num1, double num2) {
        double numOfDef = 0.0;
        double priceAdj = 0.0;
        String str = null;
        if (num1 < num2) {
            numOfDef = num2 - num1;
            priceAdj = numOfDef + num1;
            str = String.valueOf(priceAdj);
        } else if (num1 > num2) {
            numOfDef = num1 - num2;
            priceAdj = numOfDef + num2;
            str = String.valueOf(priceAdj);
        } else {
            str = String.valueOf(num1);
        }
        return str;
    }
}
