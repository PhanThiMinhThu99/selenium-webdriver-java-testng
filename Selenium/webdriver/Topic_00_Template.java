package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");}
		driver = new ChromeDriver();
		//Bấm cho maximize brows
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Upload_File_By_SendKey() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/minhthu/Downloads/Upload file/domenico-loia-hGV2TfOh0ns-unsplash.jpg");
		
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
		//driver.quit();
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