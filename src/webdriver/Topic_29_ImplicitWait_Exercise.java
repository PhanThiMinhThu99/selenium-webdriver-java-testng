package webdriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_29_ImplicitWait_Exercise {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	//WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		driver = new FirefoxDriver();
		// Anh huowng truc tiep toi hai ham FindElement/FindElements
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Ngoại lệ: Impliciwait apply set ở đâu thì apply từ chỗ đó 
		// Nếu bị gán lại thì dùng giá trị mới/không dùng lại giá trị cũ
		// Nếu mà không set implicitwait thì mặc định là = 0
	}

	@Test
	public void TC_01_Not_EnoughTime() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		//Get text and verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	@Test
	public void TC_02_EnoughTime() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		//Get text and verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}


	@Test
	public void TC_03_MoreTime() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://automationfc.github.io/dynamic-loading/");
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		//Get text and verify
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}