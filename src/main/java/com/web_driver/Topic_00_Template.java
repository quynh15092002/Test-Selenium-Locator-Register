package com.web_driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {

        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fcustomer%2Finfo");
    }

    @Test
    public void TC_01() {


        /// Java Document
        driver.close();


    }
    @Test
    public void TC_02() {


    }

    @Test
    public void TC_03() {




    }
    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
