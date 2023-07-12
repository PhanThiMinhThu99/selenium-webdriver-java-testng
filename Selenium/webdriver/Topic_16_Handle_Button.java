package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_16_Handle_Button {
	//Khai 
	WebDriver driver;
	//Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");}
		
		//KHOI TAO
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		
		WebDriverWait expliciWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

	
	@Test
	public void TC_01_Custom_tDropdown_part2() {
	driver.get("https://www.fahasa.com/customer/account/create");
	//TRUONG HOP COS POPUP hien thi thi phai dong popup 
	//Switch qua Iframe neeu popup do nam trong iframe
	 //driver.switchTo().frame("preview-notification-frame");
	//close popup
	// driver.findElement(By.cssSelector("a#NC_CLOSE_ICON>img")).click();
	//sleepInSecond(3);
	
	
	driver.findElement(By.cssSelector("li.popup-login-tab-item.popup-login-tab-login")).click();
	
	//Verify Dang Nhap button iss disable
	Assert.assertFalse(driver.findElement(By.cssSelector("button.fhs-btn-login ")).isEnabled());
	//Enter value to Email/Password textbox
	driver.findElement(By.cssSelector("input#login_username")).sendKeys("Minhthu@gmail.com");
	driver.findElement(By.cssSelector("input#login_password")).sendKeys("Minhthu1234");
	//Verify Dang Nhap button is Enable
	Assert.assertTrue(driver.findElement(By.cssSelector("button.fhs-btn-login")).isEnabled());
	
	//Verify Dang Nhap button cos background color laf mau do
	String rgbaColor = driver.findElement(By.cssSelector("button.fhs-btn-login")).getCssValue("background-color");
	//System.out.println(rgbaColor);
	
	//Convert from rgbacolor to Hexa color
	String hexaColor = Color.fromString(rgbaColor).asHex().toUpperCase();
	//Verify backgroud color
	Assert.assertEquals(hexaColor, "#C92127");
	
	}
	
	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	
	}
	}
	