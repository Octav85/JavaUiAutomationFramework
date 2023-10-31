package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);


    @When("the registration form is populated with valid random data")
    public void theRegistrationFormIsPopulatedWithValidRandomData() throws InterruptedException {
        Thread.sleep(1000);

        String email = RandomDataManager.generateRandomEmail();
        System.out.println(email);

        String password = RandomDataManager.generatePassword();
        System.out.println(password);

        registerPage.fillInRegisterForm(RandomDataManager.generateFirstName(),
                RandomDataManager.generateLastName(), email, password, true);
        System.out.println("The Register form is populated with random data.");
    }

    @And("continueButton is clicked")
    public void continueButtonIsClicked() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.clickTheContinueButton();
        System.out.println("The Continue button was clicked.");
    }

    @When("the register form is populated with following data:")
    public void theRegisterFormIsPopulatedWithFollowingData(Map<String ,String> formDataMap  ) {
        String firstNameValue = formDataMap.get("firstName");
        if(firstNameValue !=null && firstNameValue.equalsIgnoreCase("RANDOM")){
            firstNameValue = RandomDataManager.generateFirstName();
        }


        String lastNameValue = formDataMap.get("lastName");
        if(lastNameValue !=null && lastNameValue.equalsIgnoreCase("RANDOM")) {
            lastNameValue = RandomDataManager.generateLastName();
        }
        String emailInput = formDataMap.get("email");
            if(emailInput !=null && emailInput.equalsIgnoreCase("RANDOM")) {
                emailInput = RandomDataManager.generateRandomEmail();
            }
        String password = formDataMap.get("password");
                if(password !=null && password.equalsIgnoreCase("RANDOM")) {
                    password = RandomDataManager.generatePassword();
                }
        registerPage.fillInRegisterForm(firstNameValue,lastNameValue,emailInput,password,true);
    }
}


