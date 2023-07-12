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

public class Topic_32_ExplicitWait2_Exercise {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	String  anhdaoFileName = "anhdaoflower.jpg";
	String flowersFileName = "flowers.jpg";
	String computerFileName = "Computer.jpg";
	
	String anhdaoFilePath = projectPath + "/Upload Files/" + anhdaoFileName;
	String flowersFilePath = projectPath + "/Upload Files/" + flowersFileName;
	String computerFilePath = projectPath + "/Upload Files/" + computerFileName;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");}
		
		driver = new FirefoxDriver();
		
		
	}
	@Test
	public void TC_01_ExplicitWait_TC_06_Exercise_LoadingAnimation() {
		
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		explicitWait = new WebDriverWait(driver, 15);
		//Wait cho DateTime picker hien thi
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar.RadCalendar_Silk")));
		
		//Verify text truowcs khi click vao ngay o DateTime
	    Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
		
		//Wait cho ngay 19 duoc phep click
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='19']")));
		//Click vao ngay 19
		driver.findElement(By.xpath("//a[text()='19']")).click();
		//Wait cho Ajax icon loading bieen mat
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar']>div.raDiv")));
		//Wait cho ngay được chon duoc phep click lai
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[@class='']/a[text()='19']")));
		// Verify text hien thi cho Selected day
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Monday, June 19, 2023");
		
		
	}
	@Test
	public void TC_02_ExplicitWait_TC_07_upLoadFile() {
		driver.get("https://gofile.io/uploadFiles");
		explicitWait = new WebDriverWait(driver, 15);
		//Doi cho upload file button visible
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#filesUpload button.filesUploadButton")));
		//Upload file
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(anhdaoFilePath + "\n" + flowersFilePath + "\n" + computerFilePath);
		//Wait cho cacs loading icon cuar tuwng load file bien mat
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.progress-bar.bg-primary")));
		//Wait cho upload msg thanh cong duocj hien thhi
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.mainUploadSuccess div.alert.alert-secondary")));
		//Verify msg hien thi
		Assert.assertTrue(driver.findElement(By.cssSelector("div.mainUploadSuccess div.alert.alert-secondary")).isDisplayed());
		//Wait + Click cho link clickable
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.row.mb-2.mainUploadSuccessLink a.ajaxLink"))).click();
		//Click vao link 
		//driver.findElement(By.cssSelector("div.row.mb-2.mainUploadSuccessLink a.ajaxLink")).click();
		
		// Wait + Verify luon cho file name voi button download/play hien thi
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+anhdaoFileName+"']//parent::a//parent::div//following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 text-white']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+flowersFileName+"']//parent::a//parent::div//following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 text-white']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+computerFileName+"']//parent::a//parent::div//following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 text-white']"))).isDisplayed());
		//Wait + Verify button Play hien thi
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+anhdaoFileName+"']//parent::a//parent::div//following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 me-1 filesContentOption filesContentOptionPlay text-white']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+flowersFileName+"']//parent::a//parent::div//following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 me-1 filesContentOption filesContentOptionPlay text-white']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+computerFileName+"']//parent::a//parent::div//following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 me-1 filesContentOption filesContentOptionPlay text-white']"))).isDisplayed());
		
		
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}