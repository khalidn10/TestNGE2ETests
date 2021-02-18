package mess_about;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

public class Test1 {

	public Test3 test3 = new Test3();
	
	/*@BeforeMethod
	public void initialise()
	{
		System.out.println("Before Test1.initialise(): " + driver);
		Test2.open(driver);
		System.out.println("After Test1.initialise(): " + driver);
	}*/
	
	//@BeforeMethod
	public void initialise()
	{
		System.out.println("Before Test1.open(): " + test3.driver);
		//Test3.getDriver(driver);
		System.out.println("Middle Test1.open(): " + test3.driver);
		//Test3.setImplicitWait(driver);
		System.out.println("After Test1.open(): " + test3.driver);
	}
	
	/*public static void getDriver(Integer driver)
	{
		System.out.println("Before getDriver(): " + driver);
		driver = driver.parseInt("1");
		System.out.println("After getDriver(): " + driver);
		//return driver;
	}
	
	public static void setImplicitWait(Integer driver)
	{
		System.out.println("Before setImplicitWait(): " + driver);
		driver = driver + 1;
		//setDriver("2");
		System.out.println("After setImplicitWait(): " + driver);
	}*/

	//@Test
	public void navRSAcad()
	{
		//System.out.println("Test1.navRSAcad(): "+ driver);
	}
}