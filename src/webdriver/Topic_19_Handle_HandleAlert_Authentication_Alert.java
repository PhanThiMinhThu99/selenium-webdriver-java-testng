package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Topic_19_Handle_HandleAlert_Authentication_Alert {
	//Khai 
	WebDriver driver;
	//Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;
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
		//driver.manage().window().maximize();
		
		
	}
	//Cancel 1 alert
	//alert.dismiss();
	//Nhap text vafo alert
	//alert.sendKeys("");
	//Get alert title
	//alert.getText();
	
//	@Test
//   public void TC_01_Accept_Alert() {
//	//Alert là thuộc về Browser không phải element(Webelement)nên khhoong thể inspect được
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		sleepInSecond(3);
//		// Switch to Alert khi alert dang xuat hien
//		alert = driver.switchTo().alert();
//		//Verify title truoc khi accept alert
//		Assert.assertEquals(alert.getText(), "I am a JS Alert");
//		//Accept 1 alert
//		alert.accept();
//	    sleepInSecond(3);
//	   //Verify accept alert thanh cong
//	    Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");
//    }
//	@Test
//	   public void TC_02_Confirm_Alert() {
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		sleepInSecond(3);
//		alert = driver.switchTo().alert();
//		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
//		alert.dismiss();
//		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");
//	    }
//	@Test
//	   public void TC_03_Prompt_Alert() {
//		String KeyWord = "MinhThu";
//		driver.get("https://automationfc.github.io/basic-form/index.html");
//		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		sleepInSecond(3);
//		alert= driver.switchTo().alert();
//		Assert.assertEquals(alert.getText(), "I am a JS prompt");
//		alert.sendKeys(KeyWord);
//		alert.accept();
//		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + KeyWord);
//	
//	    }
//	@Test
//	   public void TC_04_Authentication_Alert() {
//		//Pass hawnr user/ password vafo url truowcs khi open nos ra
//		//Url: http://the-internet.herokuapp.com/basic_auth
//		//Pass: username/password vafo url
//		//http://username:password@the-internet.herokuapp.com/basic_auth
//		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
//		sleepInSecond(3);
//		Assert.assertTrue(driver.findElement(By.cssSelector("div.example>p")).getText().contains("Congratulations! You must have the proper credentials."));
//	    }
//	
//	@Test
//	   public void TC_05_Accept_Alert_Login(){
//		driver.get("https://demo.guru99.com/Security/SEC_V1/");
//		driver.findElement(By.name("btnLogin")).click();
//		sleepInSecond(3);
//		alert = driver.switchTo().alert();
//		Assert.assertEquals(alert.getText(), "User or Password is not valid");
//		alert.accept();
//		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/Security/SEC_V1/index.php");
//		
//	}
	@Test
	public void TC_06_Authentication_Alert() {
		driver.get("https://the-internet.herokuapp.com/");
		String basicAuthenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		driver.get(getAuthenticationUrl(basicAuthenUrl, "admin", "admin"));
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.cssSelector("div.example>p")).getText().contains("Congratulations! You must have the proper credentials."));
		
	}
    public void unCheckToCheckBox(String xpathLocator) {
    	WebElement element = driver.findElement(By.xpath(xpathLocator));
    	if (element.getAttribute("aria-checked").equals("true")) {
			element.click();
		}
    }
	private void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
    
	@AfterClass
	public void afterClass() {
		//driver.quit();
	
	}
	public String getAuthenticationUrl(String basicAuthenUrl, String userName, String password) {
		String[] authenUrlArray = basicAuthenUrl.split("//");
		basicAuthenUrl = authenUrlArray[0]+ "//"+ userName+":"+ password +"@"+ authenUrlArray[1];
		return basicAuthenUrl;
		
	}
	}
	