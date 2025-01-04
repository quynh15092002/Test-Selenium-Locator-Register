package com.web_driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;
    //Manage: Gồm 3 cái
    //1. Timeout
    //2. Window
    //3. Log
    //Nếu như dùng tới: *, dùng nhiều **, ko đánh là ko dùng
    @BeforeClass
    public void initialBrowser() throws MalformedURLException {
        // Run with browser (local)
        driver = new FirefoxDriver();
        driver = new EdgeDriver();
        driver = new ChromeDriver();
        driver = new SafariDriver();
        driver = new InternetExplorerDriver();
        // Remote (Grid/Docker/Cloud Testing)
        //  Cần kiến thức của Networking (LAN/WAN/IP/Port) mới demo đưc Grid
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
    }

    @Test
    public void TC_01() {


        // Mở ra 1 Url bất kỳ (lưu ý phải bắt đầu bằng http/https )
        driver.get("https://demo.nopcommerce.com"); //**
        driver.get("https://live.techpanda.org/index.php/catalog/seo_sitemap/category");


        // Đóng browser (nó chỉ đóng cái nào nó đang đứng, tại cái window đấy thôi)
        driver.close();
        //Đóng browser (bao gồm tất cả các tab/window)
        driver.quit(); //**

        //Lấy ra title của page hiện tại
        // Mình cần kiểm tra làm cái gì?
        // 1 - Lưu dữ liệu lại rồi kiểm tra sau
       String homePageTitle =  driver.getTitle();  // Lấy cái A sau đấy gán dữ liệu vo biến homePageTitle bằng cái toán tử =
       Assert.assertEquals(homePageTitle, "nopCommerce demo store");
       Assert.assertTrue(homePageTitle.contains("demo store"));

       // 2 - Kiểm tra trực tiếp >> Cách này hiệu quả hơn(vì dùng có 1 lần cái trên thêm 1 dòng code tốn bộ nhớ: 1 dòng lưu trữ)
       // kiểm tra tương đối
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");
     // >> Tóm lại Khi dữ liệu dùng 1 lần ko nên khai báo biến, còn dùng 2 dữ liệu tro len mới dùng khai báo biến để tái sử dụng lại

        // Lấy ra URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");

        // Lấy ra Page Source Code
       String homePageSourceCode = driver.getPageSource();

        // Kiểm tra tương đối
        Assert.assertTrue(homePageSourceCode.contains("Conditions of Use"));

        // Lấy ra ID của tab/window đang actrive
        driver.getWindowHandle();

        // Lấy ra tất cả các tab/window đang có
        driver.getWindowHandles();

        // Đi tìm 1 element
        driver.findElement(By.xpath(""));  //**

        // Đi tìm n element
        driver.findElements(By.xpath("")); //**

        //Selenium ver 3
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.DAYS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.HOURS);

        //Selenium version 4
        //Dùng để chờ cho viec tìm element (findElement/ findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(15));

        // Dùng để chờ cho việc page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        //Dùng để chờ cho 1 đoạn script được thực thi xong
        //JavascriptExecutor - js
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        WebDriver.Window window= driver.manage().window();

        // Thu nhỏ về taskbar để chạy
        window.minimize();

        //Phóng to lên (vẫn còn taskbar) >> Hay dùng cái này
        window.maximize(); //*

        //Tràn màn hình ko có taskbar
        window.fullscreen();

        // Test GUI: Graphic User Interface
        //Font/Color/Size/Position/Location/..

        //Responsive: Chạy auto có thể giả lập kích thuoc để chạy
        driver.manage().window().setSize(new Dimension(1920, 1080));
        Dimension dimension = driver.manage().window().getSize();

        //Position: cái mép bên ngoài, size: kích thước màn hình
        driver.manage().window().setPosition(new Point(0, 0));
        Point point = driver.manage().window().getPosition();

        // Lấy hết tất cả cookie: Test Class 01 (Register tài khoản - lưu cookie lại)
       Set<Cookie> cookies = driver.manage().getCookies();

        driver.manage().getCookieNamed(".Nop.Antiforgery");

        //Xóa hết cookie
        driver.manage().deleteAllCookies();


        //Dùng vòng lặp để xóa và xóa theo thứ tự
        for (Cookie cookie: cookies){
            // Xóa cookie theo thứ tự
            driver.manage().deleteCookie(cookie);
        }

        // Xóa cookie theo tên
        driver.manage().deleteCookieNamed(".Nop.Antiforgery");

       // /Đến 1 Test Class khác 02/03/04/.. (Không cần login - set cookie đã có vào đây rồi refresh lại)
        for (Cookie cookie: cookies){
            // Add cookie theo thứ tự
            driver.manage().addCookie(cookie); //*
        }
        driver.navigate().refresh(); //login thành công
        //Define
        Logs log = driver.manage().logs();
        LogEntries logEntries = log.get("BROWSER");
        for (LogEntry logEn: logEntries){
            System.out.println(logEn);
        }
        // Trả về cái list mà LogType có bao nhieu cái đang hỗ trợ
        log.getAvailableLogTypes();

        WebDriver.Navigation navigation = driver.navigate();

        //Những cái này rất ít khi dùng
        // Refresh/F5
        navigation.refresh();
        //Quay lại trang trước đó
        navigation.back();
        // Chuyển tới trang trước đó
        navigation.forward();
        // Mở Url bất kỳ
        navigation.to("https://demo.nopcommerce.com/login?ReturnUrl=%2Fcustomer%2Finfo");

        // Alert/Iframe/Windows (Tab)
        WebDriver.TargetLocator targetLocator = driver.switchTo();

        //Alert
        targetLocator.alert().accept();//*
        targetLocator.alert().dismiss();//*
        //Frame/Iframe
        targetLocator.frame("");//*
        targetLocator.defaultContent();//*

        //Windows
        targetLocator.window("");//*
        // Lấy ra ID của tab/window đang active
        driver.getWindowHandle(); //*

        // Lấy ra tất cả các tab/window đang có
        driver.getWindowHandles(); //*
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
