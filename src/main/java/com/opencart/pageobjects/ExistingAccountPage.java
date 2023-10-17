package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExistingAccountPage extends Page {


    public ExistingAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //a[@class='dropdown-item'][normalize-space()='Logout']")
    private WebElement logoutButton;

    public void logoutAlreadyRegistered() {
        myAccountIcon.click();
        logoutButton.click();

    }



}


