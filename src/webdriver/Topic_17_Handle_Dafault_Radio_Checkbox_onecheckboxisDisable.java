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

public class Topic_17_Handle_Dafault_Radio_Checkbox_onecheckboxisDisable {
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
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_Checkbox_OneCheckBoxIsDisable() {
	driver.get("https://demos.telerik.com/kendo-ui/checkbox/index/");
	sleepInSecond(5);
	List<WebElement> allCheckboxes = driver.findElements(By.xpath("//div[@class='demo-section']//input[@type='checkbox']"));
	//Vua chon +veriy luon
	for (WebElement checkbox : allCheckboxes) {
		checkToCheckboxorRadio(checkbox);
	}
	}

	
	public void checkToCheckboxorRadio(WebElement element)
	{
		if (!element.isSelected() && element.isEnabled()) {
			System.out.println("Click to element:"+ element);
			element.click();
			Assert.assertTrue(isElementSelected(element));
		}
	}
	public void unCheckToCheckbox(WebElement element) {
		if (element.isSelected() && element.isEnabled()) {
			element.click();
			Assert.assertFalse(isElementSelected(element));
		}
	}
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
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
	}
	