package webdriver;

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

public class Topic_27_Wait_PartI2 {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");}
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01_Visible_Display_Visibility() {
		driver.get("https://www.facebook.com/");
		//1. Co tren UI (bat buoc)
		//1. Co tren HTML (bat buoc)
		//Cho cho email address hien thij trong vong 10s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("minhthu@gmail.com");
		
	}

	@Test
	public void TC_02_Invisible_UnDisplayed_Invisibility() {
		driver.get("https://www.facebook.com/");
		//2. Khong cos tren UI (bat buoc)
		//1. Co tren HTML
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		//Cho cho Re-enter email textbox khong hien thi trong 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}

	@Test
	public void TC_03_Invisible_UnDisplayed_Invisibility_Part2() {
		driver.get("https://www.facebook.com/");
		//2. Khong cos tren UI (bat buoc)
		//1. Khong Co tren HTML
	
		//Cho cho Re-enter email textbox khong hien thi trong 10s
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}
	@Test
	public void TC_04_Presence_I() {
		driver.get("https://www.facebook.com/");
		//1. Co tren UI 
		//2. Co trong cay HTML(bat buoc)
		//Cho cho email address textbox presence trong HTML trong vongf 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		
		
		
	}
	@Test
	public void TC_05_Presence_II() {
		driver.get("https://www.facebook.com/");
		//1. Khong co tren UI
		//2. Co trong cay HTML (bat buoc)
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		//Cho cho Re-enter email textbox khong hien thi trong 10s
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	}
    @Test
    public void TC_06_Staleness() {
    	//2. Khong cos tren UI (batbuoc)
    	//2. Khong co tren HTML
    	driver.get("https://www.facebook.com/");
    	driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
    	//Phase 1: Element co trong cay HTML
    	WebElement reEnterEmailAddressTextbox = driver.findElement(By.name("reg_email_confirmation__"));
    	// Thao tac voi Element khac lam cho element Re-enter email khong con trong DOM nk
    	//Ex: Close popup 
    	
    	driver.findElement(By.cssSelector("img._8idr")).click();
    	
    	//Cho cho Re-enter Email textbox khong con trong DOM trong vong 10s
    	
    	explicitWait.until(ExpectedConditions.stalenessOf(reEnterEmailAddressTextbox));
    	
    	
    }
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}