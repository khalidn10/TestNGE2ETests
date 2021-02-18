package resources;

import org.openqa.selenium.WebDriver;

public class CloseResources {

	public static void close(WebDriver driver)
	{
		driver.quit();
	}
}
