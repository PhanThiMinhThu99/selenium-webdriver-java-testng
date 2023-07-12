package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_14_Dropdownlist {
	
	WebDriver driver;
	Select select;
	Random rand;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");}
		
		//KHOI TAO
	    rand = new Random();
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

	
	@Test
	public void TC_01_DefaultDropdown() {
		
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Joe");
		
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Biden");
		
		String emailAddtess = "Thu" + rand.nextInt(9999)+ "@gmail.com";
		// Dang thao tac voi dropdown nao
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		
		//chon item co text la 13
		
		select.selectByVisibleText("13");
		//Verify da chon gia tri 13 thanh cong
		
		//Khoitao voi dropdown month
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("April");
		//Khoitao voi dropdown year
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1999");
		//Verify Email 
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddtess);
		//Verify Company name
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Viet Nam");
		//Verify Password
		driver.findElement (By.cssSelector("input#Password")).sendKeys("thu123456");
		//Verify Password confirmation
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("thu123456");
		// Click Register
		driver.findElement(By.cssSelector("button#register-button")).click();
		//Verify text 
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		//Click Continue
		driver.findElement(By.cssSelector("a.button-1.register-continue-button")).click();
		//Click login
		driver.findElement(By.cssSelector("a.ico-login")).click();
		//input value
		
		driver.findElement(By.cssSelector("input.email")).sendKeys(emailAddtess);
		driver.findElement(By.cssSelector("input.password")).sendKeys("thu123456");
		driver.findElement(By.cssSelector("button.button-1.login-button")).click();
		driver.findElement(By.cssSelector("a.ico-account")).click();
		//---------------------------//
		//Verify gia tri da dang ky cos dung hay khong
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Joe");
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Biden");
		
		//Verify gia tri trong dropdown list da chon
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"13");
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "April");
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1999");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddtess);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),"Viet Nam");
		
		// verify 1 cai dropdown la sigle hay multiple
	   Assert.assertFalse(select.isMultiple());
	     
		
		
		
		
		
		
			}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//Sleep cứng ( static wait)
	
	public void sleepInsecond(long timeInsecond) {
		try {
		Thread.sleep(timeInsecond * 1000);
		} catch(InterruptedException e) { 
			e.printStackTrace();
		}
	}
}
	