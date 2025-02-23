package org.practice.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scrolling {

    private Scrolling(){

    }
    @Step("scrolling to element: {locator}")
    public static void scrollToElement(WebDriver driver, By locator){
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);"
                , ElementActions.findElement(driver,locator));
    }

}
