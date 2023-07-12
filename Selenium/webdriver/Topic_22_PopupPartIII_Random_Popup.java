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

public class Topic_22_PopupPartIII_Random_Popup {
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

//	@Test
//	public void TC_01_Random_Popup_Indom() {
//		driver.get("https://www.javacodegeeks.com/");
//		sleepInsecond(15);
//		// yêu cầu
//		// 1.Nếu popup xuất hiện thì click Subcribe
//		// 2. Nếu không xuất hiện thì qua step tiếp theo
//		WebElement popup = driver
//				.findElement(By.xpath("//div[@class='lepopup-form-inner']//div[@data-type='rectangle']"));
//
//		if (popup.isDisplayed()) {
//			// Nhap email
//			driver.findElement(By.cssSelector("input.lepopup-ta-left ")).sendKeys(getRanDomEmailAddress());
//			sleepInsecond(3);
//
//			driver.findElement(By.xpath("//span[text()='OK' or text()='Get the books']")).click();
//			sleepInsecond(3);
//			Assert.assertTrue(popup.isDisplayed());
//			sleepInsecond(3);
//			Assert.assertFalse(popup.isDisplayed());
//
//		}
//		sleepInsecond(10);
//		driver.findElement(By.cssSelector("input#search-input"))
//				.sendKeys("Automation Testing Strategies for Microservices");
//		driver.findElement(By.xpath("//button[@id='search-submit']/span[@class='tie-icon-search tie-search-icon']"))
//				.click();
//		sleepInsecond(3);
//		Assert.assertTrue(driver
//				.findElement(By.xpath(
//						"//h2[@class='post-title']//a[text()='Automation Testing Strategies for Microservices']"))
//				.isDisplayed());
//
//	}
//
//	@Test
//	public void TC_02_VNK_in_HTML() {
//		driver.get("https://vnk.edu.vn/");
//		sleepInsecond(10);
//		By popup = By.cssSelector("div.tcb-flex-row");
//		if (driver.findElement(popup).isDisplayed()) {
//			driver.findElement(By.cssSelector("div.tcb-icon-display")).click();
//			sleepInsecond(3);
//			Assert.assertFalse(driver.findElement(popup).isDisplayed());
//		}
//		// Step tiep theo click vao button sau khi popup da an
//		driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
//		sleepInsecond(3);
//		Assert.assertEquals(driver.getCurrentUrl(), "https://vnk.edu.vn/lich-khai-giang/");
//	}
	@Test
	public void TC_03_Dehieupage_Not_in_HTML() {
		driver.get("https://dehieu.vn/");
		List <WebElement> popup = driver.findElements(By.cssSelector("div.popup-content"));
		//Co hien thi popup
		if (popup.size()>0 && popup.get(0).isDisplayed()) {
			//dong popup di
			driver.findElement(By.cssSelector("button.close")).click();
			sleepInsecond(3);
		}
		//Khong hien thi popup
		driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
		sleepInsecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "https://dehieu.vn/khoa-hoc");
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

	public String getRanDomEmailAddress() {
		Random rand = new Random();
		return "MinhThu" + rand.nextInt(99999) + "@gmail.com";
	}
}
