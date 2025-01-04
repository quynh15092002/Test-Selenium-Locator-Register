package com.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    private static WebDriver driver;
    private static final String projectPath = System.getProperty("user.dir");
    private static final String osName = System.getProperty("os.name");

    @BeforeClass
    public static void beforeClass(){
        if (osName.contains("Mac OS")){
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }else{
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public void TC_01_ID(){
        // Muốn thao tác lên Element thì đầu tiên phải tìm được element đó: findElement
        // Find theo cái gì: id/class/name/css/xpath/...
        // Find tìm thấy element rồi thì action lên element đó
        // ID là duy nhất chỉ có 1
          driver.findElement(By.id("FirstName")).sendKeys("Automation");
    }

    @Test
    public void TC_02_Class(){

        driver.findElement(By.className("header-logo"));

    }
    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DataOfBirthDay"));
    }
    @Test
    public void TC_04_TagName(){
     // Tìm xem có bao nhiêu thể input trên màn hình hiện tại số lượng là bao nhiêu

    //System.out.println(driver.findElements(By.tagName("input")).size());
     driver.findElement(By.tagName("input"));
    }
    @Test
    public void TC_05_LinkText(){
        // Click vào đường link Addresses (tuyệt đối)
       // Độ chính xác cao = Tuyệt đối = toàn bộ
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_PartialLinkText(){
        //Click vào đường link Apply for vender account (tương đối)
        // Độ chính xác ko cao = tương đối = 1 phần (đầu/giữa/cuối)
       driver.findElement(By.partialLinkText("for vendor"));
       driver.findElement(By.partialLinkText("vendor account"));
        driver.findElement(By.partialLinkText("Apply for vendor"));
    }
    @Test
    public void TC_07_Css() {

        //Css với ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("inputFirstName"));
        driver.findElement(By.cssSelector("#inputFirstName"));

        //Css với class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //Css với name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css với tagname
        driver.findElement(By.cssSelector("input"));
        
    }
        @Test
        public void TC_08_XPath() {
           // Mở lại trang Register
           driver.get("https://demo.nopcommerce.com/register");
            //1
           driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Selenium");
            //2
            driver.findElement(By.xpath("//input[@data-val-required='Last name is required.']")).sendKeys("Locator");
            //3
            //driver.findElement(By.xpath("//label[text()='Email: ']/following-sibling::input"));
            driver.findElement(By.xpath("//input[@data-val-required='Email is required.']")).sendKeys("quynh@gmail.com");

        }
        @AfterClass
        public static void afterClass() {
          //driver.quit();
        }
    }

