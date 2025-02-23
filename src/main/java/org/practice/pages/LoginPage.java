package org.practice.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.practice.utils.BrowserAction;
import org.practice.utils.CustomSoftAssertion;
import org.practice.utils.ElementActions;
import org.practice.utils.Validations;
import org.testng.Assert;

public class LoginPage {
    private final WebDriver driver;
    private final By username= By.id("user-name");
    private final By password= By.id("password");
    private final By loginbutton= By.id("login-button");
    private final By errormsg=By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    @Step("navigate to login page")
    public LoginPage navigateToLoginPage(){
        BrowserAction.navigateToURL(driver,"https://www.saucedemo.com/");
        return this;
    }

    @Step("entering username")
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver,this.username,username);
        return this;
    }

    @Step("entering password")
    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver,this.password,password);
        return this;
    }

    @Step("click login button")
    public LoginPage clickLoginButton(){
        ElementActions.clickElement(driver,loginbutton);
        return this;
    }

    @Step("get error msg")
    public String getErrorMsg(){
        return ElementActions.getText(driver,errormsg);
    }

    @Step("assert successful login")
    public LoginPage assertSuccessfulLogin(){
        Validations.validatePageUrl(driver,"https://www.saucedemo.com/inventory.html");
        return this;
    }

    @Step("assert login page url")
    public LoginPage assertLoginPageURL(){
        CustomSoftAssertion
                .softAssertion
                .assertEquals(BrowserAction.getCurrentURL(driver),
                "https://www.saucedemo.com/inventory.html"
                        , "URL is not as expected");
        return this;
    }

    @Step("assert login page title")
    public LoginPage assertLoginPageTitle(){
        CustomSoftAssertion
                .softAssertion
                .assertEquals(BrowserAction.getPageTitle(driver),
                        "Swag Labs"
                ,"Title is not as expected");
        return this;
    }

    @Step("assert Successful Login Soft")
    public LoginPage assertSuccessfulLoginSoft(){
        assertLoginPageURL().assertLoginPageTitle();
        return this;
    }

    @Step("assert Unsuccessful Login Soft")
    public LoginPage assertUnsuccessfulLogin(){
        Validations.validateEquals(getErrorMsg(),"Epic sadface: Username and password do not match any user in this service","error msg not expected");
        return this;
    }


}
