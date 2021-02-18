// Package
package object_repository;

// Imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Class containing objects in Rahul Shetty Academy login page
public class RSAcadLoginPage {

	// Declare local driver
	public WebDriver driver;
	
	// Constructor with WebDriver parameter
	public RSAcadLoginPage(WebDriver driver)
	{
		// Set local driver to driver sent in parameter
		this.driver = driver;
	}
	
	private static By email = By.id("user_email");
	
	private static By password = By.id("user_password");
	
	// Set CSS Selector for Login button
	private static By login = By.cssSelector("[value='Log In']");
	
	private static By createAccount = By.linkText("Create an Account");
	
	public WebElement getEmail()
	{
		// Return Login button
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		// Return Login button
		return driver.findElement(password);
	}
	
	// Get method for Login button
	public WebElement getLogin()
	{
		// Return Login button
		return driver.findElement(login);
	}
	
	public WebElement getCreateAccount()
	{
		return driver.findElement(createAccount);
	}
}
