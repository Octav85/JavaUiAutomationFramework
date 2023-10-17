package com.opencart;


import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.*;
import com.opencart.managers.DriverManager;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();
        //New window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://andreisecuqa.host/");
        Thread.sleep(1000);

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        myAccountIcon.click();
        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        String randomEmail = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(randomEmail);
        System.out.println(randomEmail);



        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        System.out.println(password);







        WebElement termsAndConditionsToggleBar = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
        JavascriptExecutor je = (JavascriptExecutor)  driver;
        je.executeScript("arguments[0].scrollIntoView(true);" , termsAndConditionsToggleBar);
        Thread.sleep(1000);
        termsAndConditionsToggleBar.click();

        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));
        registerButton.click();


        Thread.sleep(1000);
        System.out.println(driver.getTitle());

        driver.close();


        driver.switchTo().window(currentWindowName);
        driver.get("https://meduza.io/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit();
        System.out.println("The execution is over");


    }
}