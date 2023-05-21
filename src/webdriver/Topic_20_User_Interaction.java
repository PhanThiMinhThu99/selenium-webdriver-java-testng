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

public class Topic_20_User_Interaction {
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

//	@Test
//	public void TC_01_HoverToolTip() {
//		driver.get("https://automationfc.github.io/jquery-tooltip/");
//
//		// Hover vafo element
//		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
//		sleepInsecond(3);
//
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(),
//				"We ask for your age only for statistical purposes.");
//
//	}
//	
//	@Test 
//	public void TC_02_Hover_to_Element_myntrapage() {
//		driver.get("https://www.myntra.com/");
//		action.moveToElement(driver.findElement(By.xpath("//a[@data-group='kids']"))).perform();
//		sleepInsecond(3);
//		action.click(driver.findElement(By.xpath("//header[@class='desktop-container']//a[text()='Flats']"))).perform();
//		//driver.findElement(By.xpath("//header[@class='desktop-container']//a[text()='Flats']")).click();
//		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='School Shoes']")).getText(), "School Shoes");
//		
//	}
//	@Test
//	public void TC_03_Hover_To_Element_fahasapage(){
//		driver.get("https://www.fahasa.com/");
//		action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
//		sleepInsecond(3);
//		//action.click(driver.findElement(By.xpath("//div[@class='fhs_center_space']//a[text()='TÂM LÝ - KĨ NĂNG SỐNG']"))).perform();
//		driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']")).click();
//		Assert.assertEquals(driver.findElement(By.xpath("//strong[text()='Kỹ năng sống']")).getText(), "KỸ NĂNG SỐNG");
//	}
//	@Test
//	public void TC_04_Click_And_Hold_Block() {
//		driver.get("https://automationfc.github.io/jquery-selectable/");
//		//Dang can thao tac voi ca 12 soos
//		List<WebElement> listNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
//		System.out.println("The number of the list="+ listNumbers.size());
//		//Click vao so bawt dau va giu chuot trai(chua nha chuot ra)
//		//Di chuot den so ket thuc
//		//nha chuot trai ra
//		action.clickAndHold(listNumbers.get(0)).moveToElement(listNumbers.get(9)).release().perform();
//		sleepInsecond(5);
//	 List<WebElement> listNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
//	System.out.println("The number of the list="+ listNumberSelected.size());
//		//Verify so luowng element dax chon
//		Assert.assertEquals(listNumbers.size(), 6);
//			
//		
//	}
//	@Test
//	public void TC_05_Click_And_Hold_Random() {
//		driver.get("https://automationfc.github.io/jquery-selectable/");
//		// Dang can thao tac voi ca 12 so
//		List<WebElement> listNumbers = driver.findElements(By.cssSelector("ol#selectable>li"));
//		System.out.println("The number of the list=" + listNumbers.size());
//
//		Keys key = null;
//		if (osName.contains("Mac")) {
//			key = Keys.COMMAND;
//		} else {
//			key = Keys.CONTROL;
//		}
//
//		// Nhan phim ctrl xuong chuwa nha ra
//		action.keyDown(key).perform();
//		// Click vao cac so can chon
//		action.click(listNumbers.get(1)).click(listNumbers.get(4)).click(listNumbers.get(7)).click(listNumbers.get(10))
//				.perform();
//		// Nha phim ctrl ra
//		action.keyDown(key.CONTROL).perform();
//
//		List<WebElement> listNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
//		System.out.println("The number of the list=" + listNumberSelected.size());
//		// Verify so luong element da chon
//		Assert.assertEquals(listNumberSelected.size(), 4);
//
//	}
 @Test
 public void TC_06_Double_Click() {
	 driver.get("https://automationfc.github.io/basic-form/index.html");
	 //Scroll toi element can tap truoc
	 jsExcutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[@ondblclick='doubleClickMe()']")));
	 sleepInsecond(3);
	 action.doubleClick(driver.findElement(By.xpath("//button[@ondblclick='doubleClickMe()']"))).perform();
	 sleepInsecond(3);
	 Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
	 
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
