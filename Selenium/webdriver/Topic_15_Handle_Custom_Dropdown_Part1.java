package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Topic_15_Handle_Custom_Dropdown_Part1 {
	//Khai bao
	Select select;
	WebDriver driver;
	WebDriverWait expliciWait; 
	//Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

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
		expliciWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

	
	@Test
	public void TC_01_DefaultDropdown() {
	driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	//Goi ham: 1 ham cos the goi 1 ham khac de dung trong 1 class
	selectItemInCustomDropdown("span#number-button","ul#number-menu div","7");
	sleepInSecond(3);
	//Verify gia tri 
	Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "7");
	selectItemInCustomDropdown("span#number-button","ul#number-menu div","5");
	sleepInSecond(3);
	//Verify gia tri 
	Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "5");
	selectItemInCustomDropdown("span#number-button","ul#number-menu div","3");
	sleepInSecond(3);
	//Verify gia tri 
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "3");
	//Chọn speed
	selectItemInCustomDropdown("span#speed-button", "ul#speed-menu div", "Fast");
	sleepInSecond(3);
	//Verify gia tri 
	Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Fast");
	selectItemInCustomDropdown("span#speed-button", "ul#speed-menu div", "Slow");
	// Chon (select) a title
	selectItemInCustomDropdown("span#salutation-button", "ul#salutation-menu div", "Mrs.");
	sleepInSecond(3);
	selectItemInCustomDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");
	// 1 - Click vào 1 phần tử nào đó thuộc dropdown để cho nó xổ ra
	//driver.findElement(By.cssSelector("span#number-button")).click();
//	// 2 - Chờ cho tất cả các item trong dropdown được load ra 
//	//Ham presenceOfAllElementsLocatedBy la ham cho cho tat ca element duoc load ra thanh cong trong cay HTML/DOM
//	// Lưu ý: Không dùng sleep cứng
//	// Phải có hàm wait nào để nó linh động:
//	   // Nếu như chưa tìm thấy thì sẽ tìm lại trong khoảng time được set
//	 // Nếu như tìm thấy rồi thì không cần phải chờ hết khoảng time 
//	// Bat duoc 1 locator dai dien tat ca item
//	expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
//	
//	// 3.1 - Nếu item cần chọn đang hiển thị
//	// 3.2 - Nếu item cần chọn không hiển thị thì cần cuộn chuột xuống - scroll down
//	// 4 - Kiểm tra text của item - nếu đúng với cái mình cần thì click
//    
//	//Luu tru tat car cac item lai thi moi duyet qua duoc
//	List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
//	// Duyet qua tung item - lay ra text va kiem tra neu no bang voiw text minh mong muon thi click vao
//	
//	//Duyet qua tung item thi dung vong lap
//	for (WebElement item : allItems) {
//		//Dung bien item de thao tac trong vong lap for
//		//Lay text ra
//		String textItem = item.getText();
//		if (textItem.equals("7")) {
//			//No se nhan vao dieu kien booolean (True or False)
//			//Neu nhu dieu kien maf dung thi mooi vao trong ham if
//			//Dieu kien ma sai thi bor qua
//			//Thi click vao
//			item.click();
//		}
//		System.out.println();
	//}
	
	}

	


	private void sleepInSecond(int i) {
		// TODO Auto-generated method stub
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
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
	