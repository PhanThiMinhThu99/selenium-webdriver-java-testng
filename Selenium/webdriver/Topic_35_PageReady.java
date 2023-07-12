package webdriver;

import java.sql.Date;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class Topic_35_PageReady {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}

		driver = new FirefoxDriver();
		action = new Actions(driver);
		explicitWait = new WebDriverWait(driver, 30);
	}

	// @Test
	public void TC_01_PageReady_OrangeHRM() {
		driver.get("https://api.orangehrm.com/");
//Wait cho icon loading bien mat
//Vi khi no bien mat thi trang no se load het duw lieeu ve thanh cong
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner")));
		Assert.assertEquals(driver.findElement(By.cssSelector("div#project>div.pull-left>h1")).getText(),
				"OrangeHRM REST API Documentation");

	}

	// @Test
	public void TC_02_PageReady_nopCommerce() {
		driver.get("https://admin-demo.nopcommerce.com/login");
		// Click chuyen trang tu login vao dashboard
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(waitForAjaxBusyLoadingInvisible());

		// Click chuyen trang tu dashboard ve login
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Assert.assertTrue(waitForAjaxBusyLoadingInvisible());

		Assert.assertEquals(driver.getTitle(), "Your store. Login");

	}

	@Test
	public void TC_03_Blog_Test_Project() {
		driver.get("https://blog.testproject.io/");
		// Hover chuot vao 1 element bat ky taij page nafy de page ready
		action.moveToElement(driver.findElement(By.cssSelector("h1.main-heading.with-subheading"))).perform();
		Assert.assertTrue(isPageLoadedSuccess());
		String keyWord = "Selenium";
		driver.findElement(By.cssSelector("section#search-2 input.search-field")).sendKeys(keyWord);
		driver.findElement(By.cssSelector("section#search-2 span.glass")).click();
		Assert.assertTrue(isPageLoadedSuccess());
		List<WebElement> portArticles = driver.findElements(By.cssSelector("h3.post-title>a"));
		for (WebElement article : portArticles) {
			Assert.assertTrue(article.getText().contains(keyWord));
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

	public boolean waitForAjaxBusyLoadingInvisible() {
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
	}

	public boolean isPageLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

}