package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Check {
    public static void main(String[] arStrings) {
        //Check Search
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q")); //Locating by name
        element.sendKeys("Hello Selenium Webdriver");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
