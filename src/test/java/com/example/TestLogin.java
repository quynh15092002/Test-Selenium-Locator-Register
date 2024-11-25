package com.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestLogin {

    String URL_login = "https://test-phase2.esse-sense.com/login";
    String URL_dashBoard = "https://test-phase2.esse-sense.com/";
    String user_login = "email";
    String user_pass = "password";
    String submitBtn = "btn-login";
    WebDriver driver;

    public void login(String email, String password) {
        driver.findElement(By.id(user_login)).sendKeys(email);
        driver.findElement(By.id(user_pass)).sendKeys(password);
        driver.findElement(By.className(submitBtn)).click();
    }

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(URL_login);
    }
    @Test
    public void TC01_LoginFailWithBlankField() {
        login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login);
    }
    @Test
    public void TC02_LoginSuccesful() {
        login("achicir2+testregisterga@gmail.com", "1234Abcd");
        driver.get(URL_dashBoard);
        Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard);
    }



    @AfterClass
    public void afterClass() {

        driver.quit();
    }


}

