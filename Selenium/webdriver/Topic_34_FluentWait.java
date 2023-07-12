package webdriver;

import java.sql.Date;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class Topic_34_FluentWait {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	JavascriptExecutor jsExcutor;
	FluentWait<WebDriver> fluentDriver;
	FluentWait<WebElement> fluentElement;

	long allTime = 15; // (Second)
	long pollingTime = 1000; // (MiliSecond)

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		}

		driver = new FirefoxDriver();

	}

	@Test
	public void TC_01_FluentWait() {

		// Flentwait muc dich vaf cach thuc giongs nhuw implicit, nhung thay vi implicit
		// 0,5s check laij thif thanwg nay cos thuw tuwj dieu chinh time so theo mong
		// muons cua minh
		driver.get("https://automationfc.github.io/dynamic-loading/");
		findElement("//button[text()='Start']").click();
		Assert.assertEquals(findElement("//div[@id='finish']").getText(), "Hello World!");
	}

	@Test
	public void TC_02_Fluent_CountDownTime() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		WebElement CountDownTime = findElement("//div[@id='javascript_countdown_time']");
		fluentElement = new FluentWait<WebElement>(CountDownTime);
		fluentElement.withTimeout(Duration.ofSeconds(allTime)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);

		// Apply dieu kien
		fluentElement.until(new Function<WebElement, Boolean>() {
			@Override
			public Boolean apply(WebElement element) {
				String text = element.getText();
				System.out.println(text);
				return text.endsWith("00");
			}
		});
	}

	// HAM FLUENTWAIT
	public WebElement findElement(final String xpathLocator) {
		fluentDriver = new FluentWait<WebDriver>(driver);
		fluentDriver.withTimeout(Duration.ofSeconds(allTime)).pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);
		// Apply dieu kien
		return fluentDriver.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(xpathLocator));
			}
		});

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}