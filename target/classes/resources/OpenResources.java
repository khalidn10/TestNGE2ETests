package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class OpenResources {

	public static WebDriver open() throws IOException
	{
		WebDriver driver = GlobalData.getDriver();
		
		GlobalData.setImplicitWait(driver);
		// Test implicit wait
		/*driver.get("https://www.rahulshettyacademy.com/seleniumPractise/");
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div.cart-preview.active button[type='button']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");*/
		
		return driver;
	}
}
