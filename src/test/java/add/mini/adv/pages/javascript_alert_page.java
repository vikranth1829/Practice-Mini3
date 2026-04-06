package add.mini.adv.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import add.mini.adv.base.BaseTest;

public class Javascript_alert_page {
	private WebDriver driver;
	private WebDriverWait wait;
	private Alert alert;

	private By jsAlert = By.cssSelector("button[onclick^='jsAlert']");
	private By jsConfirm = By.cssSelector("button[onclick^='jsConfirm']");
	private By jsPrompt = By.cssSelector("button[onclick^='jsPrompt']");
	private By jsResultText = By.cssSelector("p[id='result']");

	public Javascript_alert_page(WebDriver driver) {
		this.driver = driver;
		this.wait = BaseTest.waitutil();
	}

	public void open() {
		String baseURL = BaseTest.loadConfig("jsalert");
		driver.get(baseURL);
	}

	public void clickJSAlert() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(jsAlert));
		driver.findElement(jsAlert).click();

	}

	public void clickJSConfirm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(jsConfirm));
		driver.findElement(jsConfirm).click();
	}

	public void clickJSPrompt() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(jsPrompt));
		driver.findElement(jsPrompt).click();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlert() {
		this.alert=driver.switchTo().alert();
	}
	
	public String getAlertText() {
		return alert.getText();
	}
	
	public void sendTextToAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public String getResultText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(jsResultText));
		String fullText = driver.findElement(jsResultText).getText();
		int partText = fullText.indexOf(": ") + 2;
		String finalText = fullText.substring(partText).trim();

//		String fullText1 = driver.findElement(jsResultText).getText();
//		String[] partText1=fullText1.split(": ");
//		String finalText1=partText1[1].trim();

		return finalText;
	}
}
