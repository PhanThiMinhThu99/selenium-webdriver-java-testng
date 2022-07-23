package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Web_Browser {
	
	WebDriver driver;
	WebElement element;
	// Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
	
		//Khoi tao
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);}

	@Test
	public void TC_01_() {
		// Các hàm tương tác với Browser thông qua biến driver
		
		//Đóng tab/windown đang active
		driver.close();
		//Đóng browser
		driver.quit();
		
		//Tìm ra 1 element (single)
	WebElement loginButton = driver.findElement(By.cssSelector(""));
		//Tìm ra nhiều element (multiple)
	   List<WebElement> links = driver.findElements(By.cssSelector(""));
	   
	   //Mở ra cái url truyền vào
	   driver.get("https://www.facebook.com/");
	   // Trả về 1 url tại page đang đứng 
	  String gamPageUrl = driver.getCurrentUrl();
	  String gamPageTitle = driver.getTitle();
	  //Source code cuar page hien tai
	  String gamePageSourceCode = driver.getPageSource();
	  
	  // Laay ra casi ID cuar tab/window dang dung/ active
	  driver.getWindowHandle();
	  driver.getWindowHandles(); //Lay tat ca
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  //Cho cho page load thanh coong sau xx giay
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  //Chowf cho script dduowcj inject thanh coong vao browser/element sau xx giay
	  driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
	  
	  driver.navigate().back();
	  driver.navigate().forward();
	  driver.navigate().refresh();
	  driver.navigate().to("https://www.facebook.com/");
	  
	  //Alert/frame(Iframe)/ Window(Tab)
	  driver.switchTo().alert();
	  driver.switchTo().frame(0);
	  driver.switchTo().window("");
	  
	  
	}

	@Test
	public void TC_02_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}