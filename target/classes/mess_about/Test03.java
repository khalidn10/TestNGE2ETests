package mess_about;

public class Test03 {

	public static String s1;
	public static String s2;	
	
	public static void setDriver(int i)
	{
		int j = i++;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(j);
	}
}
