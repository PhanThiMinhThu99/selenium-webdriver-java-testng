package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_12_Web_browser_b3 {
	
	WebDriver driver;
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
		
	}

	
	@Test
	public void TC_01_Current_Url() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		WebElement EmailTextbox = driver.findElement(By.cssSelector("Input#mail"));
		
		if (EmailTextbox.isDisplayed()) {
			
			EmailTextbox.sendKeys("Automation Testing Textbox");
			System.out.println("Email textbox is displayed");
			
		} else {
			System.out.println("Email textbox is not displayed");

		}
		// age under 18 radio button
		
		WebElement ageuUnder18Radio = driver.findElement(By.cssSelector("input#mail"));
			if (ageuUnder18Radio.isDisplayed()) {
				
				ageuUnder18Radio.click();
				
				System.out.println ("Age Under 1 Radio is displayed");
				
			} else {System.out.println ("Age Under 1 Radio is  not displayed");

			}
			// Education TextArea
			
			WebElement educationTextarea = driver.findElement(By.cssSelector("textarea#edu"));
			
			if (educationTextarea.isDisplayed()) {
				
				educationTextarea.sendKeys("Automation Testing TextArea");
				
				System.out.println ("Educations TextArea is displayed");
				
			} else {
				
				System.out.println ("Educations TextArea is not displayed");

			}
	
		// image
	
			WebElement image5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
			
			if (image5.isDisplayed()) {
				System.out.println ("Image 5 is displayed");
				
			} else {	System.out.println ("Image 5 is not displayed");

			}
	}
			
			@Test
			public void TC_02_Is_Enabe() {
				
				driver.get("https://automationfc.github.io/basic-form/index.html");
				
				//Email text box
				
				WebElement EmailTextbox = driver.findElement(By.cssSelector("Input#mail"));
				
				if (EmailTextbox.isEnabled()) {
					
					System.out.println("Email textbox is Enabled");
					
				} else {
					
					System.out.println("Email textbox is Disable");

				}
				
				//Password textbox
				
				WebElement PasswordTextbox = driver.findElement(By.cssSelector("Input#disable_password"));
				
				if (PasswordTextbox.isEnabled()) {
					
					System.out.println("Password textbox is Enabled");
					
				} else {
					
					System.out.println("Password textbox is Disable");

				}
	
	}
			@Test
			public void TC_03_Is_Selected() {
				
				driver.get("https://automationfc.github.io/basic-form/index.html");
				
				WebElement Under18Radio = driver.findElement(By.cssSelector("Input#under_18"));
				
				
				Under18Radio.click();
				
				
				if (Under18Radio.isSelected()) {
					
					
					System.out.println("Age Under 18 is Selected");
					
				} else {
					
					System.out.println("Age Under 18 is not Selected");
					
					
					//Java check box
					
				WebElement javaCheckbox = driver.findElement(By.cssSelector("Input#java"));
					
					
						javaCheckbox.click();
					
					
					if (javaCheckbox.isSelected()) {
						
						
						System.out.println("Java checkbox is Selected");
						
					} else {
						
						System.out.println("Java checkbox is not Selected");
				}
				}
			}
			
			
			@Test
			public void TC_04_MailChimp() {
				
				driver.get("https://login.mailchimp.com/signup/");
				
				// email/user name text box
				driver.findElement(By.cssSelector("input#email")).sendKeys("automaitonfc@gmail.net");
				sleepInsecond(3);
				
				WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
				
				
				// check lowercase
				
				passwordTextbox.sendKeys("aa");
				
				sleepInsecond(2);
				
				
				Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
				
			
			
			// Check uppercase (viet hoa)
				passwordTextbox.clear();
				passwordTextbox.sendKeys("AAA");
				sleepInsecond(2);
				
				Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
				

				// Check Number 
					passwordTextbox.clear();
					passwordTextbox.sendKeys("123456");
					sleepInsecond(2);
					
					Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
					
					
					// Special char
					passwordTextbox.clear();
					passwordTextbox.sendKeys("@#$%!");
					sleepInsecond(2);
					
					Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
					
					// 8 char
					passwordTextbox.clear();
					passwordTextbox.sendKeys("ABCabc@@@");
					sleepInsecond(2);
					
					Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
					Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
				
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
	