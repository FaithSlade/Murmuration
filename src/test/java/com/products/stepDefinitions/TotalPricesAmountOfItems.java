package com.products.stepDefinitions;

import com.products.pages.TotalPricesAmountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class TotalPricesAmountOfItems {

    TotalPricesAmountPage totalPricesAmountPage = new TotalPricesAmountPage();
    String expectTotalPrice;

    @Then("verify calculate {int} items price in cart equal to total price before tax")
    public void verify_calculate_items_price_in_cart_equal_to_total_price_before_tax(Integer numberOfClick) {
        String actualTotalPrice = totalPricesAmountPage.actualItemTotal(totalPricesAmountPage.itemTotal);
        expectTotalPrice = totalPricesAmountPage.calculateTotalPriceOnCart(totalPricesAmountPage.priceList,numberOfClick);
        Assert.assertEquals(expectTotalPrice,actualTotalPrice);
    }

    @Then("add tex and verify the total pay")
    public void add_tex_and_verify_the_total_pay() {
        String taxCal = totalPricesAmountPage.takeOffDollarSignAndLimitDecimal(totalPricesAmountPage.tax);
        double texNum = Double.parseDouble(taxCal);
        double netPrice = Double.parseDouble(expectTotalPrice);

            String expectedPay = texNum + netPrice + "";
            String actualPay = totalPricesAmountPage.takeOffDollarSignAndLimitDecimal(totalPricesAmountPage.totalPay);
      if (expectedPay.equals(actualPay)){
          Assert.assertEquals(expectedPay, actualPay);
      } else {
          expectedPay = texNum+0.01+netPrice+"";
          Assert.assertEquals(expectedPay, actualPay);
      }
    }
}
