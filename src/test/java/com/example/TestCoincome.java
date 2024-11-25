package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCoincome {
    private static WebDriver driver;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://pm-dev-jp.makersfarminc.com/?login=error&redirect=%2Fmypage%2Fnotificatio");

    }
    @Test
    public void TC_01_ValidateCurrenUrl() {
        String abc = "abc";
        String bcd = "abc";
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://pm-dev-jp.makersfarminc.com/?login=error&redirect=%2Fmypage%2Fnotificatio");
    }
    @AfterClass
    public static void afterClass(){
        driver.quit();
    }
    }

