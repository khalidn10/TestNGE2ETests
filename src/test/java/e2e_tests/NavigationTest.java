package e2e_tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import object_repository.RSAcadLandPage;
import object_repository.RSAcadLoginPage;
import resources.CloseResources;
import resources.GlobalData;
import resources.OpenResources;

public class NavigationTest {

	public WebDriver driver;
	public Logger log = LogManager.getLogger(NavigationTest.class.getName());
	
	@BeforeMethod
	public void initialise() throws IOException
	{
		log.info("Initialising driver...");
		driver = OpenResources.open();
		log.debug("Driver initialised");
	}
	
	@Test(dataProvider="getParams")
	public void navRSAcad(String email, String password) throws IOException, InterruptedException
	{	
		log.info("Opening landing page...");
		GlobalData.openLandingURL(driver);
		log.debug("Landing page opened");
		
		RSAcadLandPage landingPage = new RSAcadLandPage(driver);
		log.info("Waiting three seconds for landing page login button...");
		Thread.sleep(3000);
		RSAcadLoginPage loginPage = landingPage.getLogin();
		log.debug("Landing page login button clicked");
		
		loginPage.getEmail().sendKeys(email);
		log.debug("Login page email entered");
		loginPage.getPassword().sendKeys(password);
		log.debug("Login page password entered");
		loginPage.getLogin().click();
		log.debug("Login page login button clicked");
	}
	
	@AfterMethod
	public void tearDown()
	{
		log.info("Tearing down driver...");
		CloseResources.close(driver);
		log.debug("Driver torn down");
	}

	@DataProvider
	public static Object[][] getParams()
	{
		Object[][] params = new Object[2][2];
		
		params[0][0] = "one@somewhere.com";
		params[0][1] = "password1";
		
		params[1][0] = "two@somewhere.com";
		params[1][1] = "password2";
		
		return params;
	}
}