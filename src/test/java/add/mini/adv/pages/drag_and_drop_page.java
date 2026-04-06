package add.mini.adv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import add.mini.adv.base.BaseTest;

public class Drag_and_drop_page {

	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	
	private By dragandroplink = By.cssSelector("a[href^='/drag_and_drop']");
	private By boxa = By.cssSelector("#column-a.column");
	private By boxb = By.cssSelector("#column-b.column");		
	
	public Drag_and_drop_page(WebDriver driver) {
		this.driver = driver;
		this.wait = BaseTest.waitutil();
		this.actions=new Actions(this.driver);
	}
	
	public void open() {
		String baseUrl=BaseTest.loadConfig("baseUrl");
		driver.get(baseUrl);
		wait.until(ExpectedConditions.elementToBeClickable(dragandroplink));
		driver.findElement(dragandroplink).click();
	}
	
	public boolean dragAtoB() {
		WebElement box1 = wait.until(ExpectedConditions.visibilityOfElementLocated(boxa));
		WebElement box2 = wait.until(ExpectedConditions.visibilityOfElementLocated(boxb));
		actions.moveToElement(box1).clickAndHold().moveToElement(box2).release().build().perform();
		//actions.dragAndDrop(box1, box2).perform();
		return true;
	}
}
