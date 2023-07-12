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

public class Topic_20_User_Interaction_PartIII {
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
//	public void TC_01_Right_Click() {
//		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
//		//Click chuot phai vao button
//		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
//	    //Hover chuot vao context menu: Past
//		action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
//		//Verify Paste co trang thai hover
//		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-paste.context-menu-hover.context-menu-visible")).isDisplayed());
//		//Click vao paste button
//		action.click(driver.findElement(By.cssSelector("li.context-menu-icon-paste"))).perform();
//		//Handel alert
//		driver.switchTo().alert().accept();
//		sleepInsecond(3);
//		//Verify paste co trang thai invisible
//		Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-paste")).isDisplayed());
//		
//		}
//	
//	@Test 
//	public void TC_02_Drag_Drop_HTML4() {
//		driver.get("https://automationfc.github.io/kendo-drag-drop/");
//		WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
//		WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));
//		action.dragAndDrop(smallCircle, bigCircle).perform();
//		sleepInsecond(3);
//		Assert.assertEquals(bigCircle.getText(), "You did great!");
//		//Check background color
//		String rgbaColor = bigCircle.getCssValue("background-color");
//		System.out.println("RGB color =" + rgbaColor);
//		//Convert rgbaColor to Hexacolor
//		String hexaColor = Color.fromString(rgbaColor).asHex().toUpperCase();
//		System.out.println("HexaColor =" + hexaColor );
//		//Verify background color
//		Assert.assertEquals(hexaColor, "#03A9F4");
//	}
	@Test
	public void TC_03_DragDrop_HTML5() {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		
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
