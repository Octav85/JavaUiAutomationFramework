package com.opencart;


import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.ExistingAccountPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import com.opencart.pageobjects.LoginPage;
import org.openqa.selenium.*;


public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

        //New window Code
        driver.get("http://andreisecuqa.host/");
        Thread.sleep(1000);

        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);

//       WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
//        myAccountIcon.click();
//        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
//        registerOption.click();


        String randomEmail = RandomDataManager.generateRandomEmail();
        String password = RandomDataManager.generatePassword();

        System.out.println(randomEmail);
        System.out.println(password);

        registerPage.fillInRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);

//        JavascriptExecutor je = (JavascriptExecutor)  driver;
//        je.executeScript("arguments[0].scrollIntoView(true);" , termsAndConditionsToggleBar);
//        Thread.sleep(1000);
//        termsAndConditionsToggleBar.click();


 // Existing account logout
        Thread.sleep(500);
        ExistingAccountPage existingAccountPage = new ExistingAccountPage(driver);
       existingAccountPage.logoutAlreadyRegistered();
        System.out.println("Logout successful");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPageFromHeader();
        loginPage.fillInLoginForm(randomEmail,password);
        Thread.sleep(500);




        DriverManager.getInstance().tearDown();
        System.out.println("The execution is over");


    }
}