package org.practice.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private ElementActions(){

    }
    @Step("sending data: {data} to element: {locator}")
    public static void sendData(WebDriver driver, By locator, String Data){
       Waits.waitForElementVisible(driver, locator);
       Scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).sendKeys(Data);
    }
    @Step("clicking on element: {locator}")
    public static void clickElement(WebDriver driver, By locator){
        Waits.waitForElementToBeClickable(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver,locator).click();
    }
    @Step("getting text from element: {locator}")
    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver, locator);
        return findElement(driver,locator).getText();
    }
    @Step("finding element: {locator}")
    public static WebElement findElement(WebDriver driver, By locator){
        return driver.findElement(locator);
    }


}
