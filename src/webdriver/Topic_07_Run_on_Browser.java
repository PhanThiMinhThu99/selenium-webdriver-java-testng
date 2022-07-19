package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Run_on_Browser {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
//
////	@BeforeClass
////	public void beforeClass() {
////		if (osName.contains("Mac")) {
////			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
////		} else {
////		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");}
////		driver = new ChromeDriver();
////		//Bấm cho maximize brows
////		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////		driver.manage().window().maximize();
//		
//	}

	@Test
	public void TC_01_Run_on_FireFox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
	}

	@Test
	public void TC_02_Run_on_Chrome() {
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
	}

	@Test
	public void TC_03_Run_on_Edge() {
		System.setProperty("webdriver.edge.driver", projectPath + "/browserDrivers/msedgedriver");
		driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
	}
}