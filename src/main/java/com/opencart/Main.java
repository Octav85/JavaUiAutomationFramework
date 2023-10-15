package com.opencart;


import org.openqa.selenium.WebDriver;
import com.opencart.managers.DriverManager;
import org.openqa.selenium.WindowType;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();
        //New window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
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