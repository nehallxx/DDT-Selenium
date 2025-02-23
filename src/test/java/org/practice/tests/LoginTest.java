package org.practice.tests;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.practice.drivers.DriverManager;
import org.practice.pages.LoginPage;
import org.practice.utils.BrowserAction;
import org.practice.utils.CustomSoftAssertion;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {


    @Test
    public void successfulLogin(){
        new LoginPage(DriverManager.getDriver()).enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton()
                .assertSuccessfulLogin();
    }

    @BeforeMethod
    public void setUp(){
        DriverManager.createInstance("edge");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown(){
        BrowserAction.closeBrowser(DriverManager.getDriver());

    }
}
