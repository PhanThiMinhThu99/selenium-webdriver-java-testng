package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Default_Dropdown {
	
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
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");}
		
		//KHOI TAO
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		rand = new Random();
		//Bấm cho maximize brows
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Minh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Phan");
		// Khoi taoj Select dder thao tacs voiw Day dropdown
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		//Chonj item co text = 13
		select.selectByVisibleText("13");
		//Lam sao bieets chonj 13 ddwuocj rooif -->Verify
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "13");
		//Verify 1 dropdown laf single hay multiple
		//-->Single -->False
		//-->Multiple -->True
	   // Assert.assertFalse(select.isMultiple());
		//Khoi taoj select ddeer thao tacs vowis Month dropdown
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("August");
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "August");
		//Year
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1912");
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "1912");
		
		String emailAddress = "Minhthu"+rand.nextInt(9999)+ "@gmail.com";
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Company")).sendKeys("ABC Company");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("minhthu123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("minhthu123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText() , "Your registration completed");
	    driver.findElement(By.cssSelector("a.button-1.register-continue-button")).click();
	    
	    //Verify the value of form
	    Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), "Minh");
	    Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), "Phan");
	    select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
	    Assert.assertEquals(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")).getAttribute("value"), "13");
	    select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
	    Assert.assertEquals(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")).getAttribute("value"), "August");
	    select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
	    Assert.assertEquals(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")).getAttribute("value"), "1912");
	    Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);
	    Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"), "minhthu123");
	    
	
	
	
	
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		sleepInSecond(3);
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	//Sleep cunwgs (Static wait)
			public void sleepInSecond(long timeinSecond){
				try {
					Thread.sleep(timeinSecond*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
}