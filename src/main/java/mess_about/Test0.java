package mess_about;

public class Test0
{
	String s1;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Test01 t01 = new Test01();
		Test01 t02;
		Test01 t03 = new Test01();
		
		t01.setS011("s011");
		t01.setS012("s012");
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		
		t02 = t01;
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println("");
		
		t01.setS011("s013");
		t01.setS012("s014");
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println("");
		
		t01.s011 = "s015";
		t01.s012 = "s016";
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println("");
		
		t03 = t02;
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println(t03.getS011());
		System.out.println(t03.getS012());	
		System.out.println("");
		
		t03.s011 = "s017";
		t03.s012 = "s018";
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println(t03.getS011());
		System.out.println(t03.getS012());	
		System.out.println("");
		
		t03 = new Test01();
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println(t03.getS011());
		System.out.println(t03.getS012());	
		System.out.println("");
		
		f1(t01, t03);
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println(t03.getS011());
		System.out.println(t03.getS012());	
		System.out.println("");
		
		t03 = t01;
		System.out.println(t01.getS011());
		System.out.println(t01.getS012());
		System.out.println(t02.getS011());
		System.out.println(t02.getS012());
		System.out.println(t03.getS011());
		System.out.println(t03.getS012());	
		System.out.println("");
	}
	
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
		System.out.println(t1.getS011());
		System.out.println(t1.getS012());
		System.out.println("");
	}
}