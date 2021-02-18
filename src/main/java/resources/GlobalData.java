package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GlobalData {

	public static WebDriver driver;
	
	private static String getGlobalValue(String data) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream globalInFile = new FileInputStream("src\\main\\java\\global-data.properties");
		prop.load(globalInFile);
		return prop.getProperty(data);
	}
	
	public static WebDriver getDriver() throws IOException
	{
		String browser = getGlobalValue("browser");
		// If setting global variable from Maven, e.g. mvn test -Dbrowser=chrome
		//String browser = System.getProperty("browser");
		
		if (browser.toLowerCase().contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			if (browser.toLowerCase().contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "src\\main\\java\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	
		return driver;
	}
	
	public static void setImplicitWait(WebDriver driver) throws NumberFormatException, IOException
	{
		Long timeout = Long.parseLong(getGlobalValue("timeout"));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	public static void openLandingURL(WebDriver driver) throws IOException
	{
		driver.get(getGlobalValue("landingUrl"));
		// Test landing url
		//System.out.println(driver.getTitle());
	}
}