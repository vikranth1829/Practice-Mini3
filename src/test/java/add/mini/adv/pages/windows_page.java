package add.mini.adv.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import add.mini.adv.base.BaseTest;

public class windows_page {

	private WebDriver driver = BaseTest.getDriver();
	private WebDriverWait wait;

	private By clickHereButton = By.cssSelector("a[href^='/windows/new']");

	public windows_page(WebDriver driver) {
		this.driver = driver;
		this.wait = BaseTest.waitutil();
	}

	public void open() {
		String baseUrl = BaseTest.loadConfig("windowsUrl");
		driver.get(baseUrl);
	}

	public void clickClickHereButton() {
		wait.until(ExpectedConditions.elementToBeClickable(clickHereButton)).click();
	}

	public String getCurrentWindowTitle() {
		return driver.getTitle();
	}

	public void switchBackToMainWindow(String mainWindow) {
		driver.switchTo().window(mainWindow);
	}
	
}
