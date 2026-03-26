package add.mini.adv.pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import add.mini.adv.base.BaseTest;

public class upload_page {

	private WebDriver driver = BaseTest.getDriver();
	private WebDriverWait wait;

	private By chooseFilebutton = By.id("input[id='file-upload']");
	private By uploadButton = By.id("file-submit");
	private By uploadedfilelabel = By.id("uploaded-files");

	public upload_page(WebDriver driver) {
		this.driver = driver;
		this.wait = BaseTest.waitutil();
	}

	public void open() {
		String baseUrl = BaseTest.loadConfig("uploadUrl");
		driver.get(baseUrl);
	}

	public void inputFile(String path) {
		String relativefilepath = BaseTest.loadConfig(path);
		String absolutefilepath = Paths.get(relativefilepath).toAbsolutePath().toString();
		wait.until(ExpectedConditions.visibilityOfElementLocated(chooseFilebutton));
		driver.findElement(chooseFilebutton).sendKeys(absolutefilepath);
	}

	public void clickUploadButton() {
		wait.until(ExpectedConditions.elementToBeClickable(uploadButton));
	}
	
	public String getUploadedFileLabel() {
		String label = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedfilelabel)).getText();
		return label;
	}
	
	
}
