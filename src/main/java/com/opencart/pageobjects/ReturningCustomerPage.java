package com.opencart.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturningCustomerPage extends Page {
    public ReturningCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    public void fillInLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);

    }

        public void clickTheLoginButton(){
           loginButton.click();


        }
    }




