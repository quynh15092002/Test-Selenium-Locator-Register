package com.web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_WebElement_Excercise {
    WebDriver driver;
    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Displayed() {


        //
        driver.close();



    }
    @Test
    public void TC_02_Enabled() {


    }

    @Test
    public void TC_03_Selected() {

    }

    @AfterClass
    public void afterClass() {

        driver.quit();
    }
}
