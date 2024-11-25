package com.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestLogin {

    private static final String URL_login = "https://test-phase2.esse-sense.com/login";
    private static final String URL_dashBoard = "https://test-phase2.esse-sense.com/";
    private static final String user_login = "email";
    private static final String user_pass = "password";
    private static final String submitBtn = "btn-login";
    private static WebDriver driver;

    public void login(String email, String password) {
        driver.findElement(By.id(user_login)).sendKeys(email);
        driver.findElement(By.id(user_pass)).sendKeys(password);
        driver.findElement(By.className(submitBtn)).click();
    }

    @BeforeClass
    public static void setUp(){
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
    public static void afterClass() {

        driver.quit();
    }


}

