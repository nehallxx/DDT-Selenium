package org.practice.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){
    }
    @Step("validate true")
    public static void validateTrue(boolean condition, String message){
        Assert.assertTrue(condition,message);
    }
    @Step("validate false")
    public static void validateFalse(boolean condition, String message){
        Assert.assertFalse(condition,message);
    }
    @Step("validation equals")
    public static void validateEquals(String actual, String expected, String message){
        Assert.assertEquals(actual,expected,message);
    }
    @Step("validate not equals")
    public static void validateNotEquals(String actual, String expected, String message){
        Assert.assertNotEquals(actual,expected,message);
    }
    @Step("validate page url")
    public static void validatePageUrl(WebDriver driver,String expected){
        Assert.assertEquals(BrowserAction.getCurrentURL(driver),expected);
    }
    @Step("validate page title")
    public static void validatePageTitle(WebDriver driver,String expected){
        Assert.assertEquals(BrowserAction.getPageTitle(driver),expected);
    }

}
