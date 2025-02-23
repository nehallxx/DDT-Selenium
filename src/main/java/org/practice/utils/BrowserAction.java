package org.practice.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserAction {

    private BrowserAction(){
    }
    @Step("navigate to: {url}")
    public static void navigateToURL(WebDriver driver, String url){
        driver.get(url);
    }
    @Step ("get current url:")
    public static String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }
    @Step ("get page title:")
    public static String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    @Step ("refresh page:")
    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }
    @Step ("closing browser:")
    public static void closeBrowser(WebDriver driver){
        driver.quit();
    }
}
