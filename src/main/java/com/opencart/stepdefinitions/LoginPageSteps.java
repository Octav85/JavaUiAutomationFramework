package com.opencart.stepdefinitions;
import com.opencart.pageobjects.ReturningCustomerPage;
import com.opencart.managers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class LoginPageSteps {
    private ReturningCustomerPage loginPage = new ReturningCustomerPage(DriverManager.getInstance().getDriver());


    @When("the login form is populated with following details:")
    public void theLoginFormIsPopulatedWithFollowingDetails(List<String> loginCredentials) {
        loginPage.fillInLoginForm(loginCredentials.get(0), loginCredentials.get(1));
    }


    @And("the Login button is clicked")
    public void theLoginButtonIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.clickTheLoginButton();
    }
}
