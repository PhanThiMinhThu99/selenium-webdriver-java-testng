package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Textbox_Textarea {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, employeeID, editFirstName, editLastName;
    String immigrationNumber, comments;
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
		firstName = "PhanThi";
		lastName = "MinhThu";
		editFirstName = "Emy";
		editLastName = "Phan";
		immigrationNumber = "12141414";
		comments = "79 Madeira Way\nMadeira Beach\nFL 233708 AD";
		
	}

	@Test
	public void TC_01_Textbox_TextArea() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php");
		//Nhap vao User/Password textbox
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		sleepInSecond(5);
		//Open the Add Employee screen
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
		//Input data into FirstName/Lastname textbox
		driver.findElement(By.cssSelector("input#firstName")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#lastName")).sendKeys(lastName);
		//Save the value of EmployeeID into the variable
		//B1: Get the value
		//driver.findElement(By.cssSelector("input#employeeId")).getAttribute("value");
		//B2: Assig the var
		employeeID = driver.findElement(By.cssSelector("input#employeeId")).getAttribute("value");
		//click Save button
		driver.findElement(By.cssSelector("input#btnSave")).click();
		
		//Verify some fields are disable
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
		
		//Verify actual value equal expected value
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getAttribute("value"), employeeID);
		//Click on the Save button
		driver.findElement(By.cssSelector("input#btnSave")).click();
		
		//Verify the fields are enable
		Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
		Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
		Assert.assertTrue(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
		//Edit fields are Enable
		driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).clear();
		driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).sendKeys(editFirstName);
		driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).clear();
		driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).sendKeys(editLastName);
		//Click on the Save button
		driver.findElement(By.cssSelector("input#btnSave")).click();
	    sleepInSecond(3);
	  //Verify some fields are disable
	  		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).isEnabled());
	  		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).isEnabled());
	  		Assert.assertFalse(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).isEnabled());
	  	//Verify actual value equal expected value
			
			Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpFirstName")).getAttribute("value"), editFirstName);
			Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmpLastName")).getAttribute("value"), editLastName);
			Assert.assertEquals(driver.findElement(By.cssSelector("input#personal_txtEmployeeId")).getAttribute("value"), employeeID);
			
		//Open immigration tab
			driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		//Click Add button
			driver.findElement(By.cssSelector("input#btnAdd")).click();
		//Input the data into the required fields
			driver.findElement(By.cssSelector("input#immigration_number")).sendKeys(immigrationNumber);
			driver.findElement(By.cssSelector("textarea#immigration_comments")).sendKeys(comments);
			sleepInSecond(5);
		//Click Save button
			driver.findElement(By.cssSelector("input#btnSave")).click();
			sleepInSecond(5);
			
	    //Click to Passport link
			driver.findElement(By.xpath("//a[text()='Passport']")).click();
		//Verify Actual value the same expected value
			Assert.assertEquals(driver.findElement(By.cssSelector("input#immigration_number")).getAttribute("value"), immigrationNumber);
			Assert.assertEquals(driver.findElement(By.cssSelector("textarea#immigration_comments")).getAttribute("value"), comments);
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
		driver.quit();
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