package com.web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Selenium_Text {
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
  }

  @Test
  public void TC_01() {


    /// Ví dụ về Nested Text là dòng text hiển thị trên web là 1 đoạn text bt nhưng trong html là text cắt nhỏ và có đoạn có thẻ chứa

    // tren web : Hello word! (Ignore Me) @04: 45 PM

    // Html :
    //<h5 id = "nested">
    // Hello word!
    //<span>(Ignore Me)  </span>
    //<span class= "date" >@04: 45 PM  </span>

    //driver.get("https://automationfc.github.io/basic-form/");
    //System.out.print("Đây là hiển thị "+ driver.findElement(By.xpath("//h5[@id='nested']")).getText());

    //driver.get("http://live.techpanda.org/index.php/customer/account/login/");
    //driver.findElement(By.xpath("//div[text()='This is a required field.']")).getText(); >>> lay gia tri tuyet doi

    //h5[text()='abc'];

    //h5[contains(text(),'abc')];


    //span[contain(text(),'(ignore me)')]>>>>text thuoc node con cua h5 la span


    //span[@id='one' and contain(text(),'(ignore me)')]


    /// <h5>
    ///<span class='concat'>Hello "John", What's happend? </span>

    ///>> cach giai quyet text có dấu '' và ""

    /// span[text()=concat('Hello "John", Wha',"'s happend?"] >> nối chuỗi


    //h5 [text()='ABC' and @id='BDC']
    //h5 [text()='ABC' or @id='BDC']


    //// Lấy ngày tháng năm trong lịch = cách ấn lựa chọn

    ///div [not @style='display:non;']/div[@class='raDiv']>>> có 1 hoặc nhiều đk trùng nhau, mình phủ định để lấy ra đk muốn


    /////<span> add to cart </span>

    /// Những phần tử khác cha nhưng trùng với node con

    //(span[text()='add to cart'])[1]


    //li[last()]>>> lấy phần tử cuối cùng


    //@AfterClass
    //public void afterClass() {
    //    driver.quit();
    //}

  }
}
