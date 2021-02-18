package mess_about;

public class Test02 {

	public static void f1(Test01 t1, Test01 t2)
	{
		System.out.println(t1.getS011());
		System.out.println(t1.getS012());
		t1.setS011("s011");
		t1.setS012("s012");
		System.out.println(t1.getS011());
		System.out.println(t1.getS012());
		System.out.println("");
		
		System.out.println(t2.getS011());
		System.out.println(t2.getS012());
		t2 = t1;
		System.out.println(t2.getS011());
		System.out.println(t2.getS012());
		System.out.println("");
	}
}
