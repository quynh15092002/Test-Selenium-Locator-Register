package com.web_driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_WebBrowser_Exercise {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {

        driver = new ChromeDriver();
    }

    @Test
    public void TC_01_Url() {
        //Step1
        driver.get("https://live.techpanda.org/");

        //Step2
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        //Step3
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        //Step4
        driver.findElement(By.xpath("//a[@title ='Create an Account']")).click();

        //Step5
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC_02_Title() {
        //Step1
        driver.get("https://live.techpanda.org/");

        //Step2
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        //Step3
        Assert.assertEquals(driver.getTitle(), "Customer Login");
        //Step4
        driver.findElement(By.xpath("//a[@title ='Create an Account']")).click();

        //Step5
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");


    }

    @Test
    public void TC_03_Navigate() {
        //Step1
        driver.get("https://live.techpanda.org/");

        //Step2
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        //Step3
        driver.findElement(By.xpath("//a[@title ='Create an Account']")).click();

        //Step4
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/create/");

        //Step5
        driver.navigate().back();

        //Step6
        Assert.assertEquals(driver.getCurrentUrl(), "https://live.techpanda.org/index.php/customer/account/login/");

        //Step7
        driver.navigate().forward();

        //Step8
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");


    }

    @Test
    public void TC_04_Page_Source() {
        //Step1
        driver.get("https://live.techpanda.org/");

        //Step2
        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();


        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title ='Create an Account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
