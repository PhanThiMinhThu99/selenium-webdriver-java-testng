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

public class Topic_15_Handle_Custom_Dropdown_Exercise_vueJS {
	//Khai bao
	Select select;
	WebDriver driver;
	WebDriverWait expliciWait; 
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
		expliciWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

	
	@Test
	public void TC_01_Custom_tDropdown_part2() {
	driver.get("https://mikerodham.github.io/vue-dropdowns/");
    selectItemInCustomDropdown("div.btn-group", "div.btn-group li", "First Option");
    sleepInSecond(3);
    Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group")).getText(), "First Option");
    sleepInSecond(3);
    selectItemInCustomDropdown("div.btn-group", "div.btn-group li", "Second Option");
    sleepInSecond(3);
    Assert.assertEquals(driver.findElement(By.cssSelector("div.btn-group")).getText(), "Second Option");
		
	}
	@Test
	public void TC_02_Editable_Sendkey() {
	driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
	enterItemInCustomDropdown("div.dropdown input.search", "div.item span.text", "Aland Islands");
	sleepInSecond(3);
	Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Aland Islands");
	sleepInSecond(3);
	enterItemInCustomDropdown("div.dropdown input.search", "div.item span.text", "Albania");
	sleepInSecond(3);
	Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Albania");
	sleepInSecond(3);
		
	}
	
	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
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
	}
	public void enterItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem) {
		//Click vào 1 thẻ nào đó (parent) để cho nó xổ ra tất cả các 
		driver.findElement(By.cssSelector(parentLocator)).clear();
		driver.findElement(By.cssSelector(parentLocator)).sendKeys(textExpectedItem);
		sleepInSecond(1);
		
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
			}}}}
	