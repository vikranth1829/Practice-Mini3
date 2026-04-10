package add.mini.adv.pages;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import add.mini.adv.base.BaseTest;

public class upload_page {

	private WebDriver driver = BaseTest.getDriver();
	private WebDriverWait wait;

	private By chooseFilebutton = By.id("file-upload");
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

	public void inputFile() {
		String relativefilepath = BaseTest.loadConfig("fileUrl");
		String absolutefilepath = Paths.get(relativefilepath).toAbsolutePath().toString();
		WebElement fileupload = wait.until(ExpectedConditions.visibilityOfElementLocated(chooseFilebutton));
		//wait.until(ExpectedConditions.elementToBeClickable(chooseFilebutton)).click();
		fileupload.sendKeys(absolutefilepath);
	}

	public void clickUploadButton() {
		wait.until(ExpectedConditions.elementToBeClickable(uploadButton)).click();
	}
	
	public String getUploadedFileLabel() {
		String label = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedfilelabel)).getText();
		return label;
	}
	
	
}
