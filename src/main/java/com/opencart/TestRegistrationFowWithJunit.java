package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFowWithJunit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void executeThisMethodBeforeTheTests() {
        System.out.println("The Execution of test suite has started");
    }

    @BeforeEach
    public void executeCodeBeforeEachTest() {
        System.out.println("the code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("http://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
        homePage.navigateToRegisterPageFromHeader();
    }


    @Test
    @DisplayName("The registration of a new user with valid data redirects to the account page")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is the test 1 ");


        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();

        boolean doesTheCorrectUrlContainsSuccessAccountRoute = currentUrl.contains("route=account/success");

        Assertions.assertTrue(doesTheCorrectUrlContainsSuccessAccountRoute, "The current URL contains : " +currentUrl + "route=account/success ");




    }

    @Test
    @DisplayName("The user is remaining on register page when trying to register with invalid password")
    public void registerWithInvalidCredentialsTest() throws InterruptedException {
        System.out.println("This is the test 2 ");


        String randomEmail = RandomDataManager.generateRandomEmail();


        System.out.println(randomEmail);


        registerPage.fillInRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail,"1", true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        Assertions.assertEquals(expectedUrl, actualUrl, "The url should be equals ");

    }


    @Test
    @DisplayName("Error Message is displayed on register page when trying to register with invalid password")
    public void errorMessageIsDisplayedWhenInvalidPasswordIsUsedForRegisterFlow() throws InterruptedException {
        System.out.println("This is the test 3 ");


        String randomEmail = RandomDataManager.generateRandomEmail();


        System.out.println(randomEmail);


        registerPage.fillInRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, "Aa1", true);
        registerPage.clickTheContinueButton();
        Thread.sleep(500);

        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
        String actualErrorMessage = driver.findElement(By.id("error-password")).getText();
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword, actualErrorMessage);
    }

    @AfterEach
    public void afterEachTestCase() {
        DriverManager.getInstance().tearDown();
        System.out.println("Test case execution has been finished");
    }

    @AfterAll
    public static void afterAllTestcase() {
        System.out.println("The test suite execution is finished");
    }

}


