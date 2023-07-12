package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environmen2_example {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(projectPath))));
	}
	
		@Test
		
		public void Register_01_Empty_Data() {
			driver.get("https://alada.vn/tai-khoan/dang-ky.html");
			//action
			driver.findElement(By.id("txtFirstname")).sendKeys("");
			driver.findElement(By.id("txtEmail")).sendKeys("");
			driver.findElement(By.id("txtCEmail")).sendKeys("");
			driver.findElement(By.id("txtPassword")).sendKeys("");
			driver.findElement(By.id("txtCPassword")).sendKeys("");
			driver.findElement(By.id("txtPhone")).sendKeys("");
			driver.findElement(By.xpath("//form[@id='frmLogin']//Button[text()='ĐĂNG KÝ']")).click();
			//verify

			Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
			Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
			Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
			Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
			Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
			Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại. ");
			}
			public void Register_02_Invalid_Email () {
				
			}
			public void Register_03_Incorrect_Email () {
				
			}
			public void Register_04_Password_Less_Than_6_character() {
				
			}
			public void Register_05_Incorrect_confirm_Password () {
				
			}
			public void Register_06_Invalid_Phone_number () {
				
			
			}
}