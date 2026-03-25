package add.mini.adv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import add.mini.adv.base.BaseTest;

public class iframe_page {

	private WebDriver driver;
	private WebDriverWait wait;

	private By iframeOuter = By.id("mce_0_ifr");
	private By iframeInner = By.id("tinymce");
	
	public void iframe_Page(WebDriver driver) {
		this.driver = driver;
		this.wait = BaseTest.waitutil();
	}

	public void open() {
		String baseUrl = BaseTest.loadConfig("iFrameUrl");
		driver.get(baseUrl);
	}
	
	public void switchtoEditorFrame() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeOuter));
	}
	
	public void clearEditor() {
		driver.findElement(iframeInner).clear();
	}
	
	public void typeEditor(String text) {
		driver.findElement(iframeInner).sendKeys(text);
	}
	
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
}
