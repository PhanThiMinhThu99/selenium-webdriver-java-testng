package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_13_TextBox_Textarea {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String Firstname, lastName, employeeID, editFirstName, editLastName;
	
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");}
		
		//KHOI TAO
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		Firstname = "Luis";
		
		lastName = "Suarez";
		
		editFirstName = "Mohammed";
		
		editLastName = "Salah";
	}

	
	@Test
	public void TC_01_Textbox_Textarea() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		//Nhap user vaf password
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		
		
		// click vao login button
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		sleepInsecond(5);
		
		
		// Mo man hinh add employee
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
		// Nhap du lieu vaof man hinh add Employee
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(Firstname);
		
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		
		//Luu gia tri cuar employee id vafo bien
		
		
		employeeID = driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).getAttribute("");
		
		// CLICK SAVE BUTTON
		
		driver.findElement(By.xpath("//button[@Type='submit']")).click();
		
	// VERIFY THE FIELDS ARE DISABLE
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='firstName']")).isEnabled());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='lastName']")).isEnabled());
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='firstName']")).isEnabled());
		
		
		
		
		
		
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
	