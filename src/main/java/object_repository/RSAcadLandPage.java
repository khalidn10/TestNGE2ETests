// Package
package object_repository;

// Imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Class containing objects in Rahul Shetty Academy landing page
public class RSAcadLandPage {

	// Declare local driver
	public WebDriver driver;
	
	// Constructor with WebDriver parameter
	public RSAcadLandPage(WebDriver driver)
	{
		// Set local driver to driver sent in parameter
		this.driver = driver;
	}
	
	// Set CSS Selector for Login button
	private static By login = By.cssSelector(".icon.fa.fa-lock");
	
	private static By courseHeading = By.cssSelector(".pull-left h2");
	
	// Get method for Login button
	public RSAcadLoginPage getLogin()
	{
		// Return Login button
		driver.findElement(login).click();
		RSAcadLoginPage loginPage = new RSAcadLoginPage(driver);
		return loginPage;
	}
	
	public WebElement getCourseHeading()
	{
		return driver.findElement(courseHeading);
	}
}
