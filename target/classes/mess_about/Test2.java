package mess_about;

public class Test2 {

	public static void open(String driver)
	{
		System.out.println("Before Test2.open(): " + driver);
		//driver = Test3.getDriver();
		System.out.println("Middle Test2.open(): " + driver);
		//Test3.setImplicitWait(driver);
		System.out.println("After Test2.open(): " + driver);
	}
}
