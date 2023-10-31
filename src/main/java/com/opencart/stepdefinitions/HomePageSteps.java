package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);
    @Given("The Home page is displayed")
    public void homepageIsDisplayed() {
        driver.get("https://andreisecuqa.host/");
        System.out.println("The driver accessed the home page");

    }


    @When("registerLink from Header menu is clicked")
    public void registerLinkFromHeaderMenuIsClicked() {
        homePage.navigateToRegisterPageFromHeader();
        System.out.println("The register link has been accessed from the Header menu");
    }
}






