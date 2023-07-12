package webdriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_23_Frame_iFrame {
	// Khai
	WebDriver driver;
	// Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Actions action;
	JavascriptExecutor jsExcutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}

		// KHOI TAO
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		jsExcutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//   @Test
//   public void TC_01_iframe_Kyna() {
//	   driver.get("https://skills.kynaenglish.vn/");
//	   //Verify Iframe hien thi tren trang Kyna
//	   driver.findElement(By.cssSelector("div.fanpage iframe")).isDisplayed();
//	   //can phai switch qua frame/iframe
//	   
//	   driver.switchTo().frame(driver.findElement(By.cssSelector("div.fanpage iframe")));
//	   String facbookLike = driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText();
//	   System.out.println(facbookLike);
//	   //Switch ve page truoc do
//	   driver.switchTo().defaultContent();
//	   //Switch vao iframe chatbox
//	   driver.switchTo().frame(driver.findElement(By.id("cs_chat_iframe")));
//	   //Click vao button iframe chatbox
//	   driver.findElement(By.cssSelector("div.meshim_widget_Widget")).click();
//	   sleepInsecond(2);
//	   driver.findElement(By.xpath("//input[@ng-model='login.username']")).sendKeys("MinhThu");
//	   driver.findElement(By.xpath("//input[@ng-model='login.phone']")).sendKeys("0947134090");
//	   new Select(driver.findElement(By.cssSelector("select#serviceSelect"))).selectByVisibleText("TƯ VẤN TUYỂN SINH");
//	   driver.findElement(By.name("message")).sendKeys("MinhthuLoveDuc");
//	   sleepInsecond(3);
//	   
//	   //Switch ve lai trang chu
//	   driver.switchTo().defaultContent();
//	   driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
//	   driver.findElement(By.cssSelector("button.search-button")).click();
//	   sleepInsecond(3);
//	   //Verify same text get from many items
//	   List <WebElement> courseNameExcel = driver.findElements(By.cssSelector("div.content>h4"));
//	   //Verify course number
//	   Assert.assertEquals(courseNameExcel.size(), 9);
//	   //Verify course name
//	   for (WebElement course: courseNameExcel) {
//		   //in ra ket qua
//		 System.out.println(course.getText());
//	     Assert.assertTrue(course.getText().contains("Excel"));
//	}
//   }
   @Test
   public void TC_02_Frame_HDFCbankpage() {
	   driver.get("https://netbanking.hdfcbank.com/netbanking/");
	   //Switch vao frame
	 driver.switchTo().frame("login_page");
	 //Nhap vao Userid
	 driver.findElement(By.cssSelector("input.form-control.text-muted")).sendKeys("Thu123");
	 driver.findElement(By.cssSelector("a.btn")).click();
	 //Switch ve case truoc do
	 driver.switchTo().defaultContent();
	 Assert.assertTrue(driver.findElement(By.id("keyboard")).isDisplayed());
	 driver.findElement(By.id("keyboard")).sendKeys("thu123");
	 sleepInsecond(3);
   }

	@AfterClass

	public void afterClass() {
		driver.quit();
	}
	// Sleep cứng ( static wait)

	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
