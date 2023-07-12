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

public class Topic_17_Handle_Dafault_Radio_Checkbox {
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
		//driver.manage().window().maximize();
		
		
	}

	
	@Test
	public void TC_01_Checkbox_Radiobutton() {
	driver.get("https://automationfc.github.io/multiple-fields/");
	
	//Co hai cach lay xpath cho thang checkbox: lay cai nao chua gia tri khogn thay doi, neu lay id vaf name laf chua so se de thay doi va bi xoa
	// cach 1: //input[@value='Cancer']//label[contains(text(),'Cancer')]/preceding-sibling::input
	// Chon checkbox Cancer and Fainting Spells
	//cach 2: //label[contains(text(),'Cancer')]/preceding-sibling::input
	// Chon checkbox Cancer and Fainting Spells
//	Cach 1: 
	//driver.findElement(By.xpath("//label[contains(text(),'Cancer')]/preceding-sibling::input")).click();
    //driver.findElement(By.xpath("//label[contains(text(),' Fainting Spells')]/preceding-sibling::input")).click();
	// Cach 2: 
	checkToCheckboxorRadio("//label[contains(text(),'Cancer')]/preceding-sibling::input");
	checkToCheckboxorRadio("//label[contains(text(),' Fainting Spells')]/preceding-sibling::input");
	
	//Verify nos duoc chon thanh cong
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Cancer']")).isSelected());
	Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),' Fainting Spells')]/preceding-sibling::input")).isSelected());
	sleepInSecond(1);
	
	// Chon Radio: 5+days - 1-2 cups/day
//	driver.findElement(By.xpath("//input[@value='5+ days']")).click();
//	driver.findElement(By.xpath("//input[@value='1-2 glasses/day']")).click();
	
	checkToCheckboxorRadio("//input[@value='5+ days']");
	checkToCheckboxorRadio("//input[@value='1-2 glasses/day']");
	sleepInSecond(1);
	
	//Verify no duoc chon thanh cong
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='5+ days']")).isSelected());
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1-2 glasses/day']")).isSelected());
	sleepInSecond(1);
	
	//Bo chon checkbox: Cancer - fainting Spells
//	driver.findElement(By.xpath("//input[@value='Cancer']")).click();
//	driver.findElement(By.xpath("//label[contains(text(),' Fainting Spells')]/preceding-sibling::input")).click();
//	sleepInSecond(1);
	
	unCheckToCheckbox("//input[@value='Cancer']");
	unCheckToCheckbox("//label[contains(text(),' Fainting Spells')]/preceding-sibling::input");
	//Verify no duoc bo chon thanh cong
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Cancer']")).isSelected());
	Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),' Fainting Spells')]/preceding-sibling::input")).isSelected());
	sleepInSecond(1);
	//Bo chon radio
	driver.findElement(By.xpath("//input[@value='1-2 days']")).click();
	driver.findElement(By.xpath("//input[@value='3-4 glasses/day']")).click();
	sleepInSecond(1);
	
	//Verify bo chon thanh cong
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='5+ days']")).isSelected());
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='1-2 glasses/day']")).isSelected());
	}
	
	@Test
    public void TC_02_JotFormPage_Select_All(){
    	driver.get("https://automationfc.github.io/multiple-fields/");
    	List<WebElement> allCheckboxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
    	//Dung vong lap de duyet qua va click chon
    	for (WebElement checkbox : allCheckboxs) {
    		checkToCheckboxorRadio(checkbox);
    		sleepInSecond(1);
			}
		
    	//Dung vong lap duyet qua va kiem tra gia tri
    	for (WebElement checkbox : allCheckboxs) {
			Assert.assertTrue(isElementSelected(checkbox));
		}
    	//Bo chon het
    	for (WebElement checkbox : allCheckboxs) {
    		unCheckToCheckbox(checkbox);
    		sleepInSecond(1);
		}
    	//Dung vong lap duyet qua va kiem tra gia tri da bo chon
    	for (WebElement checkbox : allCheckboxs) {
			Assert.assertFalse(isElementSelected(checkbox));
		}
    	
    }
	public void TC_03_TapOnSelectAllbutton() {
		//click vao button Select All
		//Verify luon tat ca cac gia tri
	}
public void checkToCheckboxorRadio(String xpathLocator) {
		//Kiểm tra trước nó đã chọn hay chưa
		//Nêu chọn rồi thì khong cần click nữa
		//Nếu chưa chọn thì click vào --> được chọn
		if (!driver.findElement(By.xpath(xpathLocator)).isSelected()) {
			driver.findElement(By.xpath(xpathLocator)).click();
		}
	}
	public void unCheckToCheckbox(String xpathLocator) {
		if (driver.findElement(By.xpath(xpathLocator)).isSelected()) {
			driver.findElement(By.xpath(xpathLocator)).click();
		}
	}
	public void checkToCheckboxorRadio(WebElement element)
	{
		if (!element.isSelected()) {
			System.out.println("Click to element:"+ element);
			element.click();
		}
	}
	public void unCheckToCheckbox(WebElement element) {
		if (element.isSelected()) {
			element.click();
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
	