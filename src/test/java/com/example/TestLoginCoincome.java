package com.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestLoginCoincome {

    static final String URL_login = "https://pm-dev-jp.makersfarminc.com/sign-in?automationtest=1";
    static final String URL_dashBoard = "https://pm-dev-jp.makersfarminc.com/";
    static final String user_login = "account";
    static final String user_pass = "password";
    static final String submitBtn = "btn-submit-default";
    static WebDriver driver;

    public void login(String account, String password) {
        driver.findElement(By.id(user_login)).sendKeys(account);
        driver.findElement(By.id(user_pass)).sendKeys(password);
        driver.findElement(By.className(submitBtn)).click();
    }

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.get(URL_login);
    }
    //Check space
    @Test
    public void TC01_LoginFailWithBlankField() {
        login("", "");
        Assert.assertEquals(driver.getCurrentUrl(), URL_login);
    }
    //Check validate email
    @Test
    public void TC02_LoginSuccesful() {
        login("tu.nguyen@tomosia.com", "12345678");
        driver.get(URL_dashBoard);
        Assert.assertEquals(driver.getCurrentUrl(), URL_dashBoard);
    }



    @AfterClass
    public static void afterClass() {

        driver.quit();
    }


}

