package webdriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Highlighter.Highlight;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

public class Topic_25_JavaScriptExcutor {
	// Khai bao bien
	WebDriver driver;
	// Khai bao + khoi tao
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		}

		// KHOI TAO
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		WebDriverWait expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
//	public void TC_01_LiveGuruPage() {
//		navigateToUrlByJS("http://live.techpanda.org/");
//		sleepInsecond(3);
//		String liveGuruDomain = (String) executeForBrowser("return document.domain");
//		Assert.assertEquals(liveGuruDomain, "live.techpanda.org");
//
//		// Verify URL
//		String liveGuruURL = (String) executeForBrowser("return document.URL;");
//		Assert.assertEquals(liveGuruURL, "http://live.techpanda.org/");
//		// Highligh element
//		hightlightElement("//a[text()='Mobile']");
//		// Mo ra MObile web
//		// driver.findElement(By.xpath("//a[text()='Mobile']")).click();
//		clickToElementByJS("//a[text()='Mobile']");
//		hightlightElement("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button");
//		clickToElementByJS("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button");
//		// Verify message is display
//		// Cach 1:
//		Assert.assertTrue(getInnerText().contains("Sony Xperia was added to your shopping cart."));
//		// Cach 2:
//		Assert.assertTrue(areExpectedTextInInnerText("Sony Xperia was added to your shopping cart."));
////Click and highlight vao element
//		hightlightElement("//a[text()='Customer Service']");
//		clickToElementByJS("//a[text()='Customer Service']");
//		// Verify title cua page = "abc..."
//		String customerServiceTitle = (String) executeForBrowser("return document.title;");
//		Assert.assertEquals(customerServiceTitle, "Customer Service");
//		// Scroll down xuong cuoi cung
//		hightlightElement("//span[text()='Newsletter']");
//		scrollToElementOnTop("//span[text()='Newsletter']");
//		// Input value into the text field
//		sendkeyToElementByJS("//span[text()='Newsletter']", getRanDomEmailAddress());
//		// Click to Subcribe button
//		hightlightElement("//span[text()='Subscribe']");
//		clickToElementByJS("//span[text()='Subscribe']");
//		// Verify text
//		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
//		// Navigate toi mot trang khac
//		navigateToUrlByJS("http://demo.guru99.com/v4/");
//		sleepInsecond(3);
////		va kiem tra domain
//		String demoGuruDomain = (String) executeForBrowser("return document.domain;");
//		Assert.assertEquals(demoGuruDomain, "http://demo.guru99.com/v4/");
//	}
	@Test
	public void TC_02_WarrantyPage(){
		driver.get("https://warranty.rode.com/");
		driver.findElement(By.xpath("//a[text()=' Create an Account ']")).click();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		sleepInsecond(3);
		
		Assert.assertEquals(getElementValidationMessage("//input[@id='name']"), "Please fill out this field.");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Minhthu");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		sleepInsecond(3);
		
		Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please fill out this field.");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Thuphan");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		sleepInsecond(3);
		Assert.assertEquals(getElementValidationMessage("//input[@id='email']"), "Please include an '@' in the email address. 'thuphan' is missing an '@'.");
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Thu@gmail.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInsecond(3);
		Assert.assertEquals(getElementValidationMessage("//input[@id='password']"), "Please fill out this field.");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("minhthu1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInsecond(3);
		Assert.assertEquals(getElementValidationMessage("//input[@id='password_confirmation']"), "Please fill out this field.");
		
	}

	// Sleep cứng ( static wait)
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
		sleepInsecond(3);
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInsecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
		sleepInsecond(3);
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
		jsExecutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');",
				getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {

		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public String getAttributeInDOM(String locator, String attributeName) {
		return (String) jsExecutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');",
				getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getRanDomEmailAddress() {
		Random rand = new Random();
		return "MinhThu" + rand.nextInt(99999) + "@gmail.com";
	}

	@AfterClass

	public void afterClass() {
		driver.quit();
	}
}
