package com.example;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Login {
    @Test
    public void login() {
        System.setProperty("webdriver.chrome.driver", "path of driver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test-phase2.esse-sense.com/login");
        WebElement username=driver.findElement(By.id("account"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement login=driver.findElement(By.name("btn-login"));
        username.sendKeys("achicir2+testregisterga@gmail.com");
        password.sendKeys("1234Abcd");
        login.click();
        String actualUrl="https://test-phase2.esse-sense.com/";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}