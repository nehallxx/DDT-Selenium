package org.practice.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private Waits(){

    }

    // element present
    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver1.findElement(locator));
    }

    // element visible
    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element = waitForElementPresence(driver, locator);
                    return element.isDisplayed() ? element: null;
                });
    }
    // element clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> {
                    WebElement element = waitForElementVisible(driver, locator);
                    return element.isEnabled() ? element: null;
                });
    }


}