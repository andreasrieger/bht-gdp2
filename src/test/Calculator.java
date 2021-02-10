package test;

//import test.IntegerMath;

public class Calculator {
	
	public static void main(String[] args) {

		IntegerMath c = (a,b) -> a + b;
		
		System.out.print(c.rechnen(3,5));
	}

}
