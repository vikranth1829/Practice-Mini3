package add.mini.adv.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Properties config;
	private static ThreadLocal<WebDriver> tldriver= new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return tldriver.get();
	}
	
	public static WebDriverWait waitutil() {
		return wait = new WebDriverWait(tldriver.get(),Duration.ofSeconds(5));
	}
	
	@BeforeMethod
	public void setup() throws IOException  {
		if(config==null) {
		config=new Properties();
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		config.load(fis);
		}
		
		String baseUrl = loadConfig("baseUrl");
		String browserName = loadConfig("browser");
		
		if(browserName.equals(null)||browserName==null) {
			browserName="chrome";
		}
		switch(browserName.toLowerCase())
		{
		case "chrome":
			tldriver.set(new ChromeDriver());
			break;
			
		case "edge":
			tldriver.set(new EdgeDriver());
			break;
			
		case "firefox":
			tldriver.set(new FirefoxDriver());
			break;
		}
	}
	
	public static String loadConfig(String key) {
		return config.getProperty(key);
	}
	
	@AfterMethod
	public void tearDown() {
		if(!getDriver().equals(null)||getDriver()!=null) {
			getDriver().quit();
			tldriver.remove();
		}
	}
}
