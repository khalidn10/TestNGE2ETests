package e2e_tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import object_repository.RSAcadLandPage;
import object_repository.RSAcadLoginPage;
import resources.CloseResources;
import resources.GlobalData;
import resources.OpenResources;

public class ValidationTest {

	public WebDriver driver;
	public Logger log = LogManager.getLogger(ValidationTest.class.getName());
	
	@BeforeMethod
	public void initialise() throws IOException
	{
		log.info("Initialising driver...");
		driver = OpenResources.open();
		log.debug("Driver initialised");
	}
	
	@Test
	public void valRSAcad() throws IOException, InterruptedException
	{	
		log.info("Opening landing page...");
		GlobalData.openLandingURL(driver);
		log.debug("Landing page opened");
		SoftAssert sAssert = new SoftAssert();
		
		RSAcadLandPage landingPage = new RSAcadLandPage(driver);
		log.info("Waiting three seconds for landing page login button...");
		Thread.sleep(3000);
		log.info("Carrying out validation on text in course heading...");
		sAssert.assertEquals(landingPage.getCourseHeading().getText(), "Featured Courses", "Course heading is not \"Featured Courses\"");
		RSAcadLoginPage loginPage = landingPage.getLogin();
		log.debug("Landing page login button clicked");
		
		log.info("Carrying out validation to check \"Create an Account\" link is displayed...");
		sAssert.assertTrue(loginPage.getCreateAccount().isDisplayed(), "\"Create an Account\" Link is not displayed");
		sAssert.assertAll();
		loginPage.getEmail().sendKeys("three@somewhere.com");
		log.debug("Login page email entered");
		loginPage.getPassword().sendKeys("password3");
		log.debug("Login page password entered");
		loginPage.getLogin().click();
		log.debug("Login page login button clicked");
		
		sAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDown()
	{
		log.info("Tearing down driver...");
		CloseResources.close(driver);
		log.debug("Driver torn down");
	}
}