package webdriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Wait_FindElement_FindElements {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	//WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}
		driver = new FirefoxDriver();
		// Dang apply 15s cho viec tim element
		//explicitWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void TC_01_FindElement() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		// Truong hop thao tac mot lan
		// driver.findElement(By.className(""));
		// Truong hop thao tac nhieu lan
		// WebElement emailTextbox = driver.findElement(By.className(""));
		// Nen gan de khai bao de hon

		// -Tim thay duy nhat 1 element/node
		// Tìm thấy và thao tác trực tiếp lên node đó
		// Vì nó tìm thấy nên không cần chờ hết timeout 15s
		driver.findElement(By.cssSelector("input#email"));
		// -Tim thay nhieu hon 1 element/node
		  //No se thao tac voi node dau tien
		  // Khong quan tam cac node con lai
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("minhthu@123gmail.com");
		//-Khong tim thay element/node nao
		  // Có chơ chế tìm lại = 0,5s tìm lại lần
		  // Nếu trong thời gian tìm lại mà thấy thì thoã mãn điều --> Pass
		  // Nếu trong thời gian tìm lại mà không thấy thì:
		    //+ Đánh fail testcase này tại step này + khong chay step tiep theo
		    //+ Throw ra một ngoại lệ:NoSuchElementExxception
		driver.findElement(By.cssSelector("input[type='check']"));
	}

	@Test
	public void TC_02_FindElements() {
		// -Tim thay duy nhat 1 element/node
		  // Tìm thấy và thao tác trực tiếp lên node đó
		  // Vì nó tìm thấy nên không cần chờ hết timeout 15s
		List<WebElement> elements = driver.findElements(By.cssSelector("input#email"));
		System.out.println("List element number = " + elements.size());
		// -Tim thay nhieu hon 1 element/node
		  //No se thao tac voi node dau tien
		  // Khong quan tam cac node con lai
		elements = driver.findElements(By.cssSelector("input[type='email']"));
		System.out.println("List element number=" + elements.size());
		//-Khong tim thay element/node nao
		  // Có chơ chế tìm lại = 0,5s tìm lại lần
		  // Nếu trong thời gian tìm lại mà thấy thì thoã mãn điều --> Pass
		  // Nếu trong thời gian tìm lại mà không thấy thì:
		    //+ Khong danh fail TCs + van chay step tiep theo
		    //+ Tra mot list roongx (empty) =0
	}

	@Test
	public void TC_03_Invisible_UnDisplayed_Invisibility_Part2() {

	}

	@Test
	public void TC_04_Presence_I() {

	}

	@Test
	public void TC_05_Presence_II() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}