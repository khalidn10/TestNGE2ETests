package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import e2e_tests.NavigationTest;
import object_repository.RSAcadLandPage;
import object_repository.RSAcadLoginPage;
import resources.CloseResources;
import resources.GlobalData;
import resources.OpenResources;

public class NavValStepDefinition {

	public WebDriver driver;
	public Logger log = LogManager.getLogger(NavigationTest.class.getName());
	RSAcadLandPage landingPage;
	RSAcadLoginPage loginPage;
	SoftAssert sAssert = new SoftAssert();
	
	@Given ("user is on landing page")
	public void user_is_on_landing_page() throws IOException
	{
		// Test for this method
		//System.out.println("Given user is on landing page");
		
		log.info("Initialising driver...");
		driver = OpenResources.open();
		log.debug("Driver initialised");
		
		log.info("Opening landing page...");
		GlobalData.openLandingURL(driver);
		log.debug("Landing page opened");
		
		landingPage = new RSAcadLandPage(driver);
	}
	
	@When ("user presses login button")
	public void user_presses_login_button() throws InterruptedException
	{
		// Test for this method
		//System.out.println("When user presses login button");
		
		log.info("Waiting three seconds for landing page login button...");
		Thread.sleep(3000);
		loginPage = landingPage.getLogin();
		log.debug("Landing page login button clicked");
	}
	
	/* Other method of parameterisation
	@When ("user logs into application with username {word} and password {word}")
	public void user_logs_into_application_with_username_and_password(String word1, String word2)
	{
		// Test for this method
		//System.out.println("And user logs into application with username " + word1 + " and password " + word2);*/
	@When ("^user logs into application with (.+) and (.+)$")
	//@When ("^user logs into application with ([^\"]*) and ([^\"]*)$")
	public void user_logs_into_application_with_username_and_password(String username, /*int*/String password)
	{
		// Test for this method
		//System.out.println("And user logs into application with username " + username + " and password " + password);
		
		loginPage.getEmail().sendKeys(username);
		log.debug("Login page email entered");
		//String pw = String.valueOf(password);
		loginPage.getPassword().sendKeys(password);
		log.debug("Login page password entered");
		loginPage.getLogin().click();
		log.debug("Login page login button clicked");
	}
	
	@Then ("home page is displayed")
	public void home_page_is_displayed()
	{
		// Test for this method
		//System.out.println("Then home page is displayed");
		
		log.info("Tearing down driver...");
		CloseResources.close(driver);
		log.debug("Driver torn down");
	}
	
	@Then("{string} is displayed in {string} page")
	public void web_element_is_displayed_in_page(String webElement, String page)
	{
		// Test for this method
		//System.out.println("Then " + webElement + " is displayed in " + page + " page");
		
		log.info("Carrying out validation on " + webElement + " in " + page + " page...");
		
		if (webElement.equals("Featured Courses header") && page.equals("landing"))
		{
			sAssert.assertEquals(landingPage.getCourseHeading().getText(), "Featured Courses", "Course heading is not \"Featured Courses\"");
		}
		else if (webElement.equals("Create an Account link") && page.equals("login"))
		{
			sAssert.assertTrue(loginPage.getCreateAccount().isDisplayed(), "\"Create an Account\" Link is not displayed");
		}
		
		log.info("Tearing down driver...");
		CloseResources.close(driver);
		log.debug("Driver torn down");
		
		sAssert.assertAll();
	}
}
