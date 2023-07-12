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

public class Topic_21_Popup_PartI {
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
		jsExcutor= (JavascriptExecutor) driver;
		action = new Actions(driver);
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
// @Test
// public void TC_01_Pop_up_Fixed_Ngoaingu24hpage() {
//	 driver.get("https://ngoaingu24h.vn/");
//	 By loginPopup = By.xpath("//div[@id='modal-login-v1'][1]");
//	 //Moi vao page thi check popup nay chua hien thi
//	 Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
//	 //Click vao button dang nhap
//	 driver.findElement(By.xpath("//button[@class='login_ icon-before']")).click();
//	 Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
//	 //Nhap thong tin khong hop le
//	 driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("minhthu1234");
//	 driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("minhthu1234");
//	 driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-login-v1")).click();
//	 sleepInsecond(3);
//	 Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.error-login-panel")).getText(), "Tài khoản không tồn tại!");
//	 
// }
//	@Test
//	public void TC_02_Fixed_Popup_Tikipage() {
//		driver.get("https://tiki.vn/");
//		By loginPopup = By.cssSelector("div.styles__Root-sc-2hr4xa-0.jyAQAr");
//		//moi mo ra chua co popup xuat hien chua co trong HTMl
//		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
//
//		driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
//		sleepInsecond(3);
//
//		Assert.assertTrue((driver.findElement(loginPopup)).isDisplayed());
//		driver.findElement(By.cssSelector("p.login-with-email")).click();
//		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
//		sleepInsecond(3);
//		//Verify text hien thi
//		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(), "Email không được để trống");
//		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")).getText(), "Mật khẩu không được để trống");
//		driver.findElement(By.cssSelector("img.close-img")).click();
//		sleepInsecond(3);
//		Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
//	}
//	@Test
//	public void TC_03_KyNaPage() {
//		driver.get("https://skills.kynaenglish.vn/");
//		By loginPopup = By.cssSelector("div.k-popup-account-mb div.modal-content");
//		driver.findElement(By.cssSelector("a.login-btn")).click();
//		sleepInsecond(3);
//		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
//		driver.findElement(By.cssSelector("input#user-login")).sendKeys("minhthu1234");
//		driver.findElement(By.cssSelector("input#user-password")).sendKeys("minhthu1234");
//		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
//	    sleepInsecond(3);
//	    Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
//	    
//	}
	@Test
	public void TC_04_FacebookPage() {
		driver.get("https://en-gb.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Tiếng Việt']")).click();
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/parent::div")).isDisplayed());
		driver.findElement(By.xpath("//div[text()='Đăng ký']/parent::div/parent::div/img")).click();
		Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Đăng ký']/parent::div/parent::div")).size(), 0);
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
