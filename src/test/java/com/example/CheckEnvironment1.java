package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckEnvironment1 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");
    }

    @Test
    public void TC_01_ValidateCurrentUrl() {
        //Check URL
        String abc = "abc";
        String bcd = "abc";
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://demo.guru99.com/v4/");
    }

    @Test
    public void TC_02_ValidatePageTitle() {
        // Check Title
        //Checl Title Fail
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
    }

    @Test
    public void TC_03_LoginFormDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
    }
    @Test
    public void TC4_LoginFormDisplayed(){
        Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        
    }


}
