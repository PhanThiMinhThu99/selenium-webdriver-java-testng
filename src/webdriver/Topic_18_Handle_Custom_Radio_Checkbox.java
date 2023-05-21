package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class Topic_18_Handle_Custom_Radio_Checkbox {
	//Khai 
	WebDriver driver;
	JavascriptExecutor jsExecutor;
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
		jsExecutor = (JavascriptExecutor) driver;
		WebDriverWait expliciWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		
		
	}

	
	@Test
//	public void TC_01_default_Checkbox_Radiobutton() {
//	driver.get("https://material.angular.io/components/checkbox/examples");
//	driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).click();
//	//Verify
//	Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Checked']/preceding-sibling::div/input")).isSelected());
//	}
//	@Test
//    public void TC_02_Custom_Checkbox_Radiobutton(){
//    	driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
//		By CheckedCheckBox = By.xpath("//div[text()='Đăng ký cho người thân']/preceding-sibling::div/input");
//    	jsExecutor.executeScript("arguments[0].click();", driver.findElement(CheckedCheckBox));
//    	sleepInSecond(3);
//    	Assert.assertTrue(driver.findElement(CheckedCheckBox).isSelected());
//    }
//	public void TC_03_Default_RadioButton() {
//	    driver.get("https://material.angular.io/components/radio/examples");
//        By CheckedRadioButton = By.xpath("//label[text()=' Spring ']/preceding-sibling::div/input");
////		driver.findElement(CheckedRadioButton).click();
////		Assert.assertTrue(driver.findElement(CheckedRadioButton).isSelected());
//		//Cach 2
//		jsExecutor.executeScript("arguments[0].click();", driver.findElement(CheckedRadioButton));
//		Assert.assertTrue(driver.findElement(CheckedRadioButton).isSelected());
//	}
	//@Test 
	public void TC_04_Custom_Checkbox_VNDirect(){
		driver.get("https://account-v2.vndirect.com.vn/");
		By CheckedCheckBox = By.xpath("//input[@name='acceptTerms']");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(CheckedCheckBox));
		Assert.assertTrue(driver.findElement(CheckedCheckBox).isSelected());
	}
  @Test
      public void TC_5_Custom_Radio_GoogleForm() {
	  driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
	  By CanThoRadio = By.xpath("//div[@aria-label='Cần Thơ']");
	  //Verify truowc khi click
	  Assert.assertEquals(driver.findElement(CanThoRadio).getAttribute("aria-checked"), "false");
	  driver.findElement(CanThoRadio).click();
	  sleepInSecond(3);
	  //Verify sau khi click
	  Assert.assertEquals(driver.findElement(CanThoRadio).getAttribute("aria-checked"), "true");
      //Cach 2 Dung isDisplay
	  Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='true']")).isDisplayed());
  }
  @Test
  public void TC_6_Custom_Checkbox_GoogleForm() {
	  driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
	  By MyQuangCheckBox = By.xpath("//div[@aria-label='Mì Quảng']");
	  checkToCheckBox("//div[@aria-label='Mì Quảng']");
	  sleepInSecond(3);
	  Assert.assertEquals(driver.findElement(MyQuangCheckBox).getAttribute("aria-checked"), "true");
	   
	  unCheckToCheckBox("//div[@aria-label='Mì Quảng']");
	  sleepInSecond(3);
	  Assert.assertEquals(driver.findElement(MyQuangCheckBox).getAttribute("aria-checked"), "false");
  }
  //Ham gianh rieng cho Checkbox Gooogle Form
    public void checkToCheckBox(String xpathLocator) {
    	WebElement element = driver.findElement(By.xpath(xpathLocator));
    	if (element.getAttribute("aria-checked").equals("false")) {
			element.click();
		}
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
	}
	