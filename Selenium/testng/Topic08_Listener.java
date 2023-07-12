package testng;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Listener.ExtentReportListener;
@Listeners(ExtentReportListener.class)
public class Topic08_Listener {
	public static WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
			driver = new FirefoxDriver();
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test 
	public void Register(){
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");

		driver.findElement(By.id("firstname")).sendKeys("MinhThu");
		driver.findElement(By.id("lastname")).sendKeys("Automation");
		String emailAddress = "mthu"+ getRanDomNumber() + "@gmail.com";
		System.out.println("Email Address= " + emailAddress);
		driver.findElement(By.id("email_address")).sendKeys(emailAddress);
		driver.findElement(By.id("password")).sendKeys("Abc1234!");
		driver.findElement(By.id("confirmation")).sendKeys("Abc1234!");
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());

	}
public int getRanDomNumber() {
	Random rand= new Random();
	return rand.nextInt(9999);
}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
