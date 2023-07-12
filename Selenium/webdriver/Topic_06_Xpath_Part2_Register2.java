package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Xpath_Part2_Register2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
	//System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		
		//Bước 1: Mở browser lên
		//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		//driver = new ChromeDriver();
		
		
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Bấm cho maximize browser	
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Empty_Data() {
	driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	driver.findElement(By.id("txtFirstname")).sendKeys("");
	driver.findElement(By.id("txtEmail")).sendKeys("");
	driver.findElement(By.id("txtCEmail")).sendKeys("");
	driver.findElement(By.id("txtPassword")).sendKeys("");
	driver.findElement(By.id("txtCPassword")).sendKeys("");
	driver.findElement(By.id("txtPhone")).sendKeys("");
	driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	
	//verify
	Assert.assertEquals(driver.findElement (By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
	Assert.assertEquals(driver.findElement (By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
	Assert.assertEquals(driver.findElement (By.id("txtCEmail-errorr")).getText(), "Vui lòng nhập lại địa chỉ email");
	Assert.assertEquals(driver.findElement (By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
	Assert.assertEquals(driver.findElement (By.id("txtCPassword-errorr")).getText(), "Vui lòng nhập lại mật khẩu");
	Assert.assertEquals(driver.findElement (By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("tauday");
		driver.findElement(By.id("txtEmail")).sendKeys("123@123@345");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@123@345");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0388870792");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement (By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement (By.id("txtCEmail-errorr")).getText(), "Vui lòng nhập email hợp lệ");
	
	}
	@Test
	public void TC_03_Invalid_Confirm_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("tauday");
		driver.findElement(By.id("txtEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("123@123@345");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0388870792");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement (By.id("txtCEmail-errorr")).getText(), "Email nhập lại không đúng");
		
	}
	@Test
	public void TC_04_Password_less_than_6characters() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("tauday");
		driver.findElement(By.id("txtEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("0388870792");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement (By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement (By.id("txtCPassword-errorr")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	@Test
	public void TC_05_Incorrect_Confirm_Psw() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("tauday");
		driver.findElement(By.id("txtEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123654");
		driver.findElement(By.id("txtPhone")).sendKeys("0388870792");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement (By.id("txtCPassword-errorr")).getText(), "Mật khẩu bạn nhập không khớp");
	
	}
	@Test
	public void TC_06_Invalid_Phone_number() {
		//<10
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("tauday");
		driver.findElement(By.id("txtEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("ducledinhqt@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123654");
		driver.findElement(By.id("txtPhone")).sendKeys("03888707");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		Assert.assertEquals(driver.findElement (By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		//>10
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("038887079234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement (By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("8887079234");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement (By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");

	}
	
	@AfterClass
	public void afterClass() {
		//Bước 6: Đóng browser
		driver.quit();
	}
}