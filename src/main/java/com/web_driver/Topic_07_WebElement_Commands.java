package com.web_driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Topic_07_WebElement_Commands {
    //Chứa các hàm để tương tác với Browser

    WebDriver driver;
    WebElement element;
    public void initialBrowser() throws MalformedURLException {
        driver = new FirefoxDriver();

    }
    @Test
    public void TC_01_WebElement() {
        // Tương tự thằng nào mà thao tác Element thì nó sẽ thông qua WebElement

        //Dùng 1 lần
        driver.findElement(By.xpath("")).click();  //**

        //Tìm xong và lưu trữ lại thao tác sau. Dùng được các element.
        element = driver.findElement(By.xpath(""));

        // Click vào các element dạng: button/radio/link/image/icon...(Textbox ko dùng được click)
        element.click();

        //Nhập liệu vào các element dạng: textbox/textarea/dropdown (edit)
        element.clear(); // Dùng để xóa dữ liệu trước khi sendkey  //*
        element.sendKeys("quynh@gmail.com"); //**
        element.sendKeys(Keys.ENTER); //**

        driver.findElement(By.cssSelector("dev.login-page"))
                .findElement(By.cssSelector("div.customer-blocks"))
                .findElement(By.id("Email"));
        driver.findElement(By.cssSelector("div.login-page div.customer-blocks input#Email"));

        // Tác dụng với form (SignUp/ Login/ Search/...)
        // thẻ form
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("Password")).submit();

        //Áp dụng cho tất cả element
        //Kiểm tra 1 element có hiển thị hay ko
        //Size > 0: width/height >0
        // Nhìn thấy/ thao tác được
        //is: đại diện cho kiểu boolean
        element.isDisplayed();  //**
        Assert.assertTrue(element.isDisplayed());
        Assert.assertFalse(element.isDisplayed());

        //Áp dụng cho duy nhất 3 loại: checkbox/radio/dropdown (default)
        // Kiem tra 1 element đã được chọm rồi hay chưa chọn
        element.isSelected(); //*

        //Áp dụng cho tất cả các loa
        //Kiểm tra 1 element có bị disable hay ko (read-only)
        element.isEnabled();

        element.getCssValue("background-color"); //*
        //#f82573

        //GUI: locator/size/color/font
        element.getCssValue("font-size");
        // 14px

        //Áp dụng cho element chứa text (link/Button/Header/Label/...)
        element.getText(); //**

        //Search store
        element.getAttribute("placeholder"); //**


        Dimension dimensionBrowser = driver.manage().window().getSize();

        //Chiều rộng/cao của element
        Dimension dimensionElement = element.getSize();


        Point pointBrowser = driver.manage().window().getPosition();

        // Vị trí của Element so với viewport
        Point pointElement = element.getLocation();

        //Tổng hợp của getsize + getlocation
        Rectangle rectangle = element.getRect();

        //Size
        rectangle.getWidth();
        rectangle.getHeight();
        rectangle.getDimension();

        //Location
        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();

      //Lấy ra cái thẻ html của thẻ element đó
        //Element A
        String tagname = driver.findElement(By.cssSelector("#FirstName")).getTagName();

        //Element B
        driver.findElement(By.xpath("//" + tagname + "[@id='LastName']"));

        element.getAccessibleName();

        element.getAriaRole();

        element.getDomAttribute("data-val-required");

        element.getDomProperty("formAction"); //*

        //Popup
        element.getShadowRoot(); //**

        //Framework: HTML Report
        element.getScreenshotAs(OutputType.FILE); //*
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);  //*




    }





}
