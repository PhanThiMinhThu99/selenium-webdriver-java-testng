package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
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
	public void TC_01_Browser() {
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
		driver.get("https://www.facebook.com/");
		// Các hàm tương tác với Element sẽ thông qua các element
		
		// 2 cách để mình thao tác
		// Khai báo biến và dùng lại
		// Dùng đi dùng lại nhiều lần- dùng ít nhất là 2 lần thì mới cần khai báo biên
		
		// Khai báo biến cùng với kiểu dữ liệu trả về của Findelement
         WebElement emailAddressTextbox = driver.findElement(By.id("email"));
         emailAddressTextbox.clear();
         emailAddressTextbox.sendKeys("minhthu@gmail.com");
		
		//Dùng trực tiếp- dùng 1 lần 
         driver.findElement(By.id("email"));
         driver.findElement(By.id("email")).sendKeys("minhthu@gmail.com");
	}
	@Test
	public void TC_03_Element() {
		driver.get("https://www.facebook.com/");
	//Các hàm tương tác với Elementsẽ thông qua các class WebElement 
		// Xoá dữ liệu trong 1 field dạng editable (có thể nhập)
		// textbox/ text area/ editable dropdown
		
	element.clear();
	// nhập dữ liệu vào field dạng editable
	element.sendKeys("minhthu@gmail.com");
	// trả về giá trị nằm trong cái attribute của elemenl
	element.getAttribute("placeholder");
	// Email address orr phone number
	driver.findElement(By.id("firstname")).getAttribute("value");
	
	
	// tra veef thuoocj tinhs css cuar element nafy
	// trar veef mafu neefn cuar element
	element.getCssValue("background-color");
	// trar veef font size cuar element
	element.getCssValue("font-size");
	// test GUI: point/ rectangle/ size
	element.getLocation();
	element.getRect();
		// Chụp màn hình và attach vào HTML report
	element.getScreenshotAs(OutputType.FILE);
	
	// Tra veef ther HTML cuar Element
	WebElement emailAddressTextbox = driver.findElement(By.xpath("//*[@id='email']"));
	emailAddressTextbox = driver.findElement(By.cssSelector("#email"));
	emailAddressTextbox.getTagName();
	
	// trả về text của 1 element (Link/Header/Message lỗi/ mesage success/..)
	element.getText();
	//Trả về giá trị đúng hoặc sai của 1 element có hiể thị hoặc không
	element.isDisplayed();
	//hiển thị là true còn không hiển thị là false
	
	// trả về giá trị đúng hoặc sai của 1 element có thể thao tác được hay không
	element.isEnabled();
	// enabled: true
	// bi disable: false
	
	// tra veeef gias trij ddungs hoacj sai cuar 1 element ddax dduwocj chonj rooif hay chuwa
	// checkbox/radio
	element.isSelected();
	//chonj ra: true
	//chuwa chonj: false
	// dropdown cos mootj thuw vieen rieng ddeer xuwr ly(Select)
	
	
	// Chir lafm vieecj dduwocj vowis Form (Register/login/search,..)
	//submit = Enter owr 1 field naof ddos
	//Submit vaof 1 field nafo ddos trong form
	element.submit();
	
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}