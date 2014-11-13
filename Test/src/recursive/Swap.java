package recursive;


public class Swap {

	public static void main(String[] args) throws Exception {
		int a = 10;
		int b = 20;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a is " + a + " b is" + b);
	}

}
