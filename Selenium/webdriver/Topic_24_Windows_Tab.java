package webdriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

public class Topic_24_Windows_Tab {
	// Khai
	WebDriver driver;
	// Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	private Alert alert;

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
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// @Test
//	public void TC_01_Window_Tab_GithubPage() {
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		// ID cuar trang hien tai maf Driver dang dung
//		String githubID = driver.getWindowHandle();
//
//		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
//		sleepInsecond(3);
//		// 2 tab = 2 ID
//		switchtoWindowByID(githubID);
//
//		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getTitle());
//
//		// Driver dang dung ow trang Google roi
//		String GoogleID = driver.getWindowHandle();
//		switchtoWindowByID(GoogleID);
//		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getTitle());
//
//		// Click tiep Facebook
//		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
//		sleepInsecond(3);
//		switchToWindowByTitle("Facebook – log in or sign up");
//		sleepInsecond(3);
//		driver.findElement(By.cssSelector("input#email")).sendKeys("minhthu@gmail.com");
//		driver.findElement(By.cssSelector("input#pass")).sendKeys("Minhthu1234");
//		sleepInsecond(3);
//
//		switchToWindowByTitle("Selenium WebDriver");
////switch qua Tiki
//		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
//		sleepInsecond(3);
//		switchToWindowByTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
//		// DDong tat ca cac tab lai
//		closeAllWindowWithoutExpectedID(githubID);
//	}
//	@Test
//	public void TC_02_Kynapage() {
//		driver.get("https://skills.kynaenglish.vn/");
//		String kynaID = driver.getWindowHandle();
//		driver.findElement(By.xpath("//div[@class='hotline']//img[@alt='facebook']")).click();
//		sleepInsecond(3);
//		switchToWindowByTitle("Kyna.vn - Home | Facebook");
//		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Kyna.vn']")).isDisplayed());
//
//		switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
//
//		driver.findElement(By.xpath("//div[@class='hotline']//img[@alt='youtube']")).click();
//		sleepInsecond(3);
//		switchToWindowByTitle("Kyna.vn - YouTube");
//		
//		//driver.findElement(By.xpath("//div[text()='Videos']")).click();
//		sleepInsecond(3);
//		
//		switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");
//		closeAllWindowWithoutExpectedID(kynaID);
//	}
//	
	@Test
	public void TC_03_PandaPage() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/ul//li/a[text()='Add to Compare']")).click();
		sleepInsecond(3);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.success-msg")).isDisplayed());

		driver.findElement(By.xpath(
				"//a[text()='IPhone']/parent::h2/following-sibling::div[@class='actions']/ul//li/a[text()='Add to Compare']"))
				.click();
		sleepInsecond(3);
		Assert.assertTrue(driver.findElement(By.cssSelector("li.success-msg")).isDisplayed());

		driver.findElement(By.xpath("//button[@title='Compare']")).click();
		sleepInsecond(3);
		switchToWindowByTitle("Products Comparison List - Magento Commerce");

		Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		//Click close button
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		switchToWindowByTitle("Mobile");

		driver.findElement(By.xpath("//button[@title='Compare']/following-sibling::a")).click();
		sleepInsecond(3);
		//Accept alert
		alert = driver.switchTo().alert();
		alert.accept();
		Assert.assertTrue(driver.findElement(By.cssSelector("li.success-msg")).isDisplayed());
	}

	// Ham dung chung cos the chay cho duy nhat 2 window/tab
	public void switchtoWindowByID(String windowID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}

	}

	// Co the chay cho 2 or nhieu Window/tabs
	public void switchToWindowByTitle(String ExpectedTitle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(ExpectedTitle)) {
				break;
			}
		}
	}

	// Close all windows
	public void closeAllWindowWithoutExpectedID(String ExpectedID) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(ExpectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(ExpectedID);
		}
	}

	@AfterClass

	public void afterClass() {
		// driver.quit();
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
