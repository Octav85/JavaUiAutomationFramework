package com.opencart.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
   private WebElement inputEmail;

    @FindBy(id = "input-password")
   private WebElement inputPassword;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public void fillInLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);

    }


    }




