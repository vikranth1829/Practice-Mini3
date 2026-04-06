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
	
	protected static ThreadLocal<WebDriver> tldriver= new ThreadLocal<>();
	protected static ThreadLocal<WebDriverWait> tlwait= new ThreadLocal<>();
	private static Properties config;
	
	
	public static WebDriver getDriver() {
		return tldriver.get();
	}
	
	public static WebDriverWait waitutil() {
		if(tlwait.get()==null) {
		 tlwait.set(new WebDriverWait(getDriver(),Duration.ofSeconds(5)));
		}
		return tlwait.get();
	}
	
	public static String loadConfig(String key) {
		return config.getProperty(key);
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
		
		if(browserName==null||browserName.trim().isEmpty()) {
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
		default:
			tldriver.set(new ChromeDriver());
		}
		
		getDriver().manage().window().maximize();
		//getDriver().get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() {
		if(getDriver()!=null) {
			getDriver().quit();
			tldriver.remove();
		}
		if(tlwait.get()!=null) {
			tlwait.remove();
		}
	}
}
