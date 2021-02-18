package mess_about;

public class Test3 {

	public Integer driver;
	
	public void setDriver(int i)
	{
		System.out.println("Before Test3.getDriver(): " + driver);
		driver = i;
		System.out.println("After Test3.getDriver(): " + driver);
		//return driver;
	}
	
	/*public static void setDriver(Integer driver, String i)
	{
		System.out.println("Before Test3.setDriver(): " + driver);
		driver = Integer.parseInt(i);
		System.out.println("After Test3.setDriver(): " + driver);
	}*/
	
	public static void setImplicitWait(Integer driver)
	{
		System.out.println("Before Test3.setImplicitWait(): " + driver);
		driver = driver++;
		//setDriver("2");
		System.out.println("After Test3.setImplicitWait(): " + driver);
	}
}