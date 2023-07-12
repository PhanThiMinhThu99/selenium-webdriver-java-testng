package Tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopper_02_Manage_Cart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeTest(alwaysRun = true)
	public void initBrowser() {
		System.out.println("Open browser and driver");
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

	}

	@Test(groups = { "admin", "Cart" })
	public void Cart_01_Create_group() {
	}

	@Test(groups = { "admin", "Cart" })
	public void Cart_01_Delete_group() {
	}

	@Test(groups = { "admin", "Cart" })
	public void Cart_01_Update_group() {
	}

	@AfterTest (alwaysRun = true)
	public void CleanBrowser() {
		System.out.println("Clean browser and driver");
		driver.quit();
	}

}
