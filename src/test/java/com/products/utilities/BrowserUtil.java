package com.products.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    /**
     * return a list of string from a list of elements
     * @param list of webElements
     * @return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getAllSelectOptions(WebElement element){
        Select select=new Select(element);
        return getElementsText(select.getOptions());
    }

    public static void selectOptionDropdown(WebElement element,String category){
        Select select=new Select(element);
        select.selectByVisibleText(category);
    }

    public static String getSelectedOption(WebElement element){
        Select select = new Select(element);
        return  select.getFirstSelectedOption().getText();
    }

}
