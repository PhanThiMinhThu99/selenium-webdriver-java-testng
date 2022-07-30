package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Web_Element_Exercise {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");}
		driver = new FirefoxDriver();
		//Bấm cho maximize brows
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_is_Displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Email Textbox
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing");
			System.out.println("Email textbox is displayed");
		} else {
            System.out.println("Email textbox is not displayed");
		} 
		//Age under 18
		WebElement ageUnder18Radio = driver.findElement(By.xpath("//label[text()='Under 18']"));
		if (ageUnder18Radio.isDisplayed()) {
			ageUnder18Radio.click();
			System.out.println("Age under 18 radio is displayed");
			
		} else {
			System.out.println("Age uner 18 radio is not displayed");

		}
		//Education
		WebElement Education = driver.findElement(By.cssSelector("textarea#edu"));
		if (Education.isDisplayed()) {
			Education.sendKeys("Automation Testing");
			System.out.println("Education textbox is displayed");
			
		} else {
			System.out.println("Education textbox is not displayed");
		}
		//Image 5(Undisplayed)
		WebElement ImageUndisplayed = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if (ImageUndisplayed.isDisplayed()) {
			
			System.out.println("Image5 is displayed");
		} else {
			System.out.println("Image5 is not displayed");

		}
		
	}

	@Test
	public void TC_02_Is_Enable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Email
		WebElement EmailTextbox = driver.findElement(By.cssSelector("input#mail"));
		if (EmailTextbox.isEnabled()) {
			System.out.println("The emailTextbox is enable");
			
		} else {
			System.out.println("Email textbox is disable");

		}
		//AgeUnder 18
		WebElement ageUnder18 = driver.findElement(By.xpath("//label[text()='Under 18']"));
		if (ageUnder18.isEnabled()) {
			System.out.println("Age under 18 textarea is enable");
		} else {
			System.out.println("Age under 18 textarea is disable");

		}
		//Biography textbox
		WebElement biographyTextbox = driver.findElement(By.cssSelector("textarea#bio"));
		if (biographyTextbox.isEnabled()) {
			System.out.println("Biography textbox is displayed");
		} else {
           System.out.println("Biography textbox is not displayed");
		}
		//Password
		WebElement passWord = driver.findElement(By.cssSelector("input#disable_password"));
		if (passWord.isEnabled()) {
			System.out.println("Password is enable");
			
		} else {
            System.out.println("Password is disable");
		}
		//Job Role 01
		WebElement jobRole = driver.findElement(By.cssSelector("select#job1"));
		if (jobRole.isEnabled()) {
			System.out.println("JobRole Dropdown is enable");
			
		} else {
			System.out.println("JobRole Dropdown is disable");
			
		}
	}

	@Test
	public void TC_03_is_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement radioButtonSelected = driver.findElement(By.cssSelector("input#under_18"));
		radioButtonSelected.click();
		if (radioButtonSelected.isSelected()) {
			System.out.println("Radio Button is selected");
			
		} else {
           System.out.println("Radio Button is not selected");
		}
		//Checkbox
		WebElement CheckboxSelected = driver.findElement(By.cssSelector("input#java"));
		if (CheckboxSelected.isSelected()) {
			System.out.println("Checkbox is selected");
			
		} else {
           System.out.println("Checkbox is not selected");
		}
	}
	@Test
	public void TC_04_Mail_Chimp() {
		driver.get("https://login.mailchimp.com/signup/");
		driver.findElement(By.cssSelector("input#email")).sendKeys("minhthu@gmail.com");
		sleepInSecond(3);
		
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
		//Check lowercase
		passwordTextbox.sendKeys("aaa");
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char not-completed\"]")).isDisplayed());
		
		//Check Uppercase
		passwordTextbox.clear();
		passwordTextbox.sendKeys("AAA");
		sleepInSecond(2);
				
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"lowercase-char not-completed\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char not-completed\"]")).isDisplayed());
		//Check Number
				passwordTextbox.clear();
				passwordTextbox.sendKeys("123445");
				sleepInSecond(2);
						
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"lowercase-char not-completed\"]")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char not-completed\"]")).isDisplayed());
				//Check special char
				passwordTextbox.clear();
				passwordTextbox.sendKeys("@#$$%%");
				sleepInSecond(2);
						
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"lowercase-char not-completed\"]")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char not-completed\"]")).isDisplayed());
				//Check 8 characters
				passwordTextbox.clear();
				passwordTextbox.sendKeys("aaa1234453");
				sleepInSecond(2);
						
				Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//li[@class=\"8-char completed\"]")).isDisplayed());
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
