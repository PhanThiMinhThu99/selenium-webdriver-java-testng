package webdriver;

import java.util.List;
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

public class Topic_14_Dropdownlist_Exercise2 {
	
	WebDriver driver;
	Select select;
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
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
	}

	
	@Test
	public void TC_01_DefaultDropdown() {
		driver.get("https://www.rode.com/wheretobuyName");
		select = new Select(driver.findElement(By.id("country")));
		select.selectByValue("Vietnam");
		sleepInSecond(3);
		//Kiem tra gia tri dax chon thanh cong
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
		
		
		//get ra ket qua voi nhieu gia tri
		List<WebElement> dearlers = driver.findElements(By.xpath("//div[@class='col-lg-6 p-1 my-1']"));
		//muon in ra duoc ket qua thif dung vong lap
		for (WebElement element : dearlers) {
			System.out.println(element.getText()); 
			
			break;
		}
			}
	
	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
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
	