package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Selenium_By {
//	Map từ manual test qua:
//		- Bước 1: Mở browser lên
//		- Bước 2: Nhập vào Url
//		- Bước 3: Click vào My Account để mở trang login ra
//		- Bước 4: Click login
//		- Bước 5: Verify lỗi hiển thị
//		- Bước 6: Đóng browser
	
	//Khai báo 1 biến để đại diện cho thư viện Selenium 
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		driver = new FirefoxDriver();
		
		//Bước 1: Mở browser lên
		System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		driver = new ChromeDriver();
		
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Bấm cho maximize browser	
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01() {
		//Bước 2: Nhập vào Url
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		//Bước 3: Click vào My ACCOUNT để mở trang login 
		
		//HTML của element (Email Textbox)
//		<input type="email" autocapitalize="off" autocorrect="off" 
//		spellcheck="false" name="login[username]" value="" id="email" 
//				class="input-text required-entry validate-email" 
//				title="Email Address">
		
		
		// input-thẻ của element này (tagname)
		// attribute - name,value,id, class,..
		//attribute value-email, email address,...
		
		
		//Xpath Format
		//tagname[@attribute-name='attribute-value']
		
		
		//Tìm 1 element 
		driver.findElement(By.id(""));
		//  CSS Format: tagname[attribute-name='attribute-value']
		
		//ID
		driver.findElement(By.id("email"));
		//Class:
		//1-Giá trị không có khoảng trắng-->lấy hết
		//2-Giá trị có khoảng trắng-->Lấy 1 phần
		driver.findElement(By.className("new-users"));
		//Name-Email textbox
		driver.findElement(By.name("login[username]"));
		//Tagname-Tìm xem có bao nhiêu element/page
		driver.findElements(By.tagName("a"));
		//Linktext (Link)-Text tuyệt đối
		driver.findElement(By.linkText("Search Terms"));
		//Partial linktext(Link) -Text tương đối/tuyệt đối
		driver.findElement(By.partialLinkText("Search Terms"));
		driver.findElement(By.partialLinkText("Terms"));
		driver.findElement(By.partialLinkText("rch rms"));
		
		//Css - Cover được hết cả 6 loại trên
		driver.findElement(By.xpath("input[@name='login[username]']"));
		driver.findElement(By.xpath("input[@id='email']"));
		//xpath
		driver.findElement(By.xpath("//input[@name='login[username]']"));
		driver.findElement(By.xpath("//input[@id='email']"));
		//driver.findElement(null)
		//Tìm nhiều element
		//driver.findElements(null)
	} 

	@Test
	public void TC_02() {
		
	}

	@AfterClass
	public void afterClass() {
		//Bước 6: Đóng browser
		driver.quit();
	}
}