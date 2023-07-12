package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_26_Upload_File {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;
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
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");}
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		//action = new Actions(driver);
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	}
//		@Test
//		public void TC_01_Upload_File_By_SendKey_OneFilePerTime() {
//			driver.get("https://blueimp.github.io/jQuery-File-Upload/");
//			//Load File len
//			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(anhdaoFilePath);
//			sleepInSecond(1);
//			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(flowersFilePath);
//			sleepInSecond(1);
//			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(computerFilePath);
//			sleepInSecond(1);
//			//Verifile load len thanh cong
//			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + anhdaoFileName + "']")).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + computerFileName + "']")).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + flowersFileName + "']")).isDisplayed());
//			//Click upload
//			List<WebElement> UploadButtons = driver.findElements(By.cssSelector("table button.start"));
//			for (WebElement button : UploadButtons) {
//				button.click();
//				sleepInSecond(3);			}
//			//Upload file thanh cong (Link)
//			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='" + anhdaoFileName + "']")).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='" + computerFileName + "']")).isDisplayed());
//			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='" + flowersFileName + "']")).isDisplayed());
//			
//			//Upload file thanh cong (Image)
//			Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + anhdaoFileName +"')]"));
//			Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + computerFileName +"')]"));
//			Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + flowersFileName +"')]"));
//		}
		@Test
		public void TC_02_Upload_File_By_SendKey_MultipleFilePerTime() {
			driver.get("https://blueimp.github.io/jQuery-File-Upload/");
			//Load File len
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(anhdaoFilePath + "\n" + flowersFilePath + "\n" + computerFilePath);
			sleepInSecond(1);
			
			//Verifile load len thanh cong
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + anhdaoFileName + "']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + computerFileName + "']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + flowersFileName + "']")).isDisplayed());
			//Click upload
			List<WebElement> UploadButtons = driver.findElements(By.cssSelector("table button.start"));
			for (WebElement button : UploadButtons) {
				button.click();
				sleepInSecond(3);			}
			//Upload file thanh cong (Link)
			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='" + anhdaoFileName + "']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='" + computerFileName + "']")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//a[@title='" + flowersFileName + "']")).isDisplayed());
			
			//Upload file thanh cong (Image)
			Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + anhdaoFileName +"')]"));
			Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + computerFileName +"')]"));
			Assert.assertTrue(isImageLoaded("//img[contains(@src,'" + flowersFileName +"')]"));
		}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public boolean isImageLoaded(String locator) {
		
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}
	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
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