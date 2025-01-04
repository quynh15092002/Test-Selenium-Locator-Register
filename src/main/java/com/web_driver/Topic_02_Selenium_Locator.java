package com.web_driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;
public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        /// Mở trang  Register ra:
        driver.get("https://demo.nopcommerce.com/register");

    }

    ///<input type="text" data-val="true" data-val-required="First name is required." id="FirstName"
    //name="FirstName" class="input-validation-error" aria-describedby="FirstName-error" aria-invalid="true">
     //Selenium version: 1.x/2,3,4.x
    // 8 loại Locator
    //Selenium Locator = HTML Attribute
    // Id/Class/Name = trùng vơ 3 attribute của HTML
    // Linktext/Partial Linktext: HTML Link (thẻ a)
    // Tagname: HTML Tagname
    // Css/XPath

    //Selenium version 4.x - GUI(Graphic User Interface)
    //Class - Relative Locator
    // above/below/near/leftOf/rightOf

    //UI testing
    //FUI: Function UI
    //GUI: Graphic UI - Visualize Testing
    //Font/Size/Color/Postion/Location/Resolution/Responsive


    // TestNG: Order testcase theo Alphabet (0-9 A-z)
    // Firstname textbox - HTML Code
    // HTML Element: <tagname attribute_name_1 ='attribute_value' attribute_name_2 ='attribute_value'...>
    /*
    *<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
   */
    @Test
    public void TC_01_ID() {
        //findElement: tìm 1 Element
        //findElements: tìm nhiều Element
        //By: Selenium Locator By
        //By: Class
        //icon c: class, m: method, i: interface, E: Enum, R: Record, A: Annotation, f: biến final
        driver.findElement(By.id("FirstName")).sendKeys("Automation");
    }
    @Test
    public void TC_02_Class() {
        //<input class="search-text" type="text" id="q" name="q">
        driver.get("https://demo.nopcommerce.com/search");
        driver.findElement(By.className("search-text")).sendKeys("Macbook");
    }

    @Test
    public void TC_03_Name() {

        //Click vao Advaned Search checkbox
        ///<input type="checkbox" data-val="true" data-val-required="The Advanced search field is required." id="advs" name="advs" value="true">
        ///<label for="advs">Advanced search</label>
        driver.findElement(By.name("advs")).click();
    }

    @Test
    public void TC_04_TagName() {

        /// tim ra bao nhieu the input tren man hinh hien tai

        System.out.print(driver.findElements(By.tagName("input")).size());

    }

    @Test
    public void TC_05_LinkText() {

        ///Click vao duong link Addresses ( truyen text tuyet doi)

        driver.findElement(By.linkText("Addresses")).click();
    }

    @Test
    public void TC_06_PartiaLinktext() {

        //// Click vao duong link addree ( tuong doi  Apply for vendor account )
        driver.findElement(By.partialLinkText("vendor account")).click();
    }

    @Test
    public void TC_07_Css() {


        // Mo lai trang register
        driver.get("https://demo.nopcommerce.com/register");

        // 1 :

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("selenium");

        //2 :
        driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");

        //3:
        driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("automation@gmail.com");



    }

    @Test
    public void TC_08_Xpath() {
        driver.get("https://demo.nopcommerce.com/register");




        ///  1:
        ///<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">

        driver.findElement(By.xpath("//input[@data-val-required= 'First name is required.'] ")).sendKeys("Day la Xpath");

        /// 2:
        //<input type="text" data-val="true" data-val-required="Last name is required." id="LastName" name="LastName">

        driver.findElement(By.xpath("//input[@id ='LastName']")).sendKeys("Day la Xpath 2");

        /// 3:

        ///<input type="email" data-val="true" data-val-email="Wrong email" data-val-required="Email is required." id="Email" name="Email">
// <label for="Email">Email:</label>

        //driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input ")).sendKeys("abc@gmail.com");

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[5]/input")).sendKeys("abc@gmail.com");


    }




   @AfterClass
    public void afterClass() {
      driver.quit();
    }
}
