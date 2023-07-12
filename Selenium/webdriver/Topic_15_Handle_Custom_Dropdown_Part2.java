package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_15_Handle_Custom_Dropdown_Part2 {
	//Khai bao
	Select select;
	WebDriver driver;
	WebDriverWait expliciWait; 
	JavascriptExecutor jsExecutor;
	//Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	private String cssLocator;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");}
		
		//KHOI TAO
	    //rand = new Random();
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		//Khoi tao sau driver
		jsExecutor = (JavascriptExecutor) driver;
	    //set size cho trinhf duyetj
		//driver.manage().window().setSize(new Dimension(1366, 768));
		
		expliciWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}

	
	@Test
	public void TC_01_Custom_tDropdown_part2() {
	driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
	//Sroll de thay cac muc de bam vao
	//scrollToElement("div.carousel-item");
//	sleepInSecond(3);
//	selectItemInCustomDropdown("button#selectize-input", "button#selectize-input+div>a", "ACCORD Ghi Bạc/Đen");
//	sleepInSecond(3);
	//Verify gia tri nhap vao
	//Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "ACCORD Ghi Bạc/Đen");
//    selectItemInCustomDropdown("button#selectize-input", "button#selectize-input+div>a", "CITY RS (Đỏ)");
//    sleepInSecond(3);
	//Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "CITY RS (Đỏ)");
	//Chon tinh thanh (Dang Default dropdownlist)
	
	scrollToElement("div.container");
	sleepInSecond(3);
    Select select = new Select (driver.findElement(By.cssSelector("select#province")));
    select.selectByVisibleText("Đà Nẵng");
    sleepInSecond(3);
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Đà Nẵng");
    
    select = new Select (driver.findElement(By.cssSelector("select#registration_fee")));
    select.selectByVisibleText("Khu vực II");
    sleepInSecond(3);
    Assert.assertEquals(select.getFirstSelectedOption().getText(), "Khu vực II");
		
	}
	
	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	public void scrollToElement(String cssLocator){
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.cssSelector(cssLocator)));
	}
	//Khong dung cho bat ki 1 dropdown nao cu the
	//Dung cho cac dropdown chung cua 1 du an
	public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem) {
		//Click vào 1 thẻ nào đó (parent) để cho nó xổ ra tất cả các 
		driver.findElement(By.cssSelector(parentLocator)).click();
		//Wait cho tất cả các item này có xuất hiện ở trong cây HTML/DOM		
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		//Tìm và lưu lại hết tất cả các item vào 1 list để cho step tiếp theo
		List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
		//Duyệt qua từng phần tử  element trong list 
		for (WebElement item : allItems) {
			//Lấy text 
			String textActualItem = item.getText();
			//So sánh nếu nó bằng với item mình mong muốn
			if (textActualItem.equals(textExpectedItem)) {
			//Click vào
				item.click();
				//Khi đã tìm thấy và thoã màn điều kiện thì không cần  duyệt tiếp nữa 
			break;
			}
	}
	}}
	