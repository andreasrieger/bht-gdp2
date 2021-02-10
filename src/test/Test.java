/**
 * 
 */
package test;

import java.io.File;

/**
 * @author andreas
 *
 */
public class Test {

//	private static String directory = "/MeinePr2Aufgaben/"; // PATH?
//	 private static String directory = "/Users/andreas/Git/vfh-gdp2/src/test/MeinePr2Aufgaben/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rek("abcdef");
//		reku("Berlin");
//		System.out.println(rekur("Berlin"));
//		System.out.println("Aufruf: " + rek05(134));
//		System.out.println("3 / 10? " + 3/10);
		
//		rek06(321);
//		System.out.println(rek07(123456));
//		System.out.println(fibonacciR(5));
//		System.out.println(spiegel1(134));
		
//		show2By2(123456);

//		File f = new File(directory);
//		lengthRecursivelyAllFiles(f, "");
//
//		int x = 10;
//		int result = ++x * x++;
//		System.out.println("Result: " + result);
//
//		char z = 'x';
//		String s3 = " " + z + z;
//		System.out.println("Char to String: " + s3);
//
//		System.out.println(replaceLetters("abc"));
//		
//		//Loops (b)
//		int[] reihe = { 1, 3, 5, 7, 3, 4, 2 };
//		replaceGerade(reihe,0);
//		
//		//convert binary to byte
//		byte b = 0b01000011;
//		System.out.println("Binary to byte: " + b);
//		
//		Test for rest w/ modulo
//		int zahl = 781;
//		int restVonZahl = zahl % 10;
//		System.out.println("Rest: " + restVonZahl);
		
//		String[] foo = {1, "Bar"};
		
	}

	public static String replaceLetters(String s) {
		StringBuilder st = new StringBuilder(s.length());
		for (int i = 0; i < s.length(); i++) {
			st.append((char) (s.charAt(i) + 1));
		}
		return st.toString();
	}

	/**
	 * ersetzt alle gerade Zahlen im Array reihe mit der Zahl n. 
	 * 
	 * @param reihe das gegebene Arra
	 * @param n die Ersatz-Zahl
	 */
	public static void replaceGerade(int[] reihe, int n) {
		

		for(int i = 0;i<reihe.length;i++)
		{
			if (reihe[i] % 2 == 0)
				reihe[i] = n;
			System.out.print(reihe[i] + " ");
		}
		System.out.println("\r");
	}

	public static void lengthRecursivelyAllFiles(File topFile, String someSpace) {
//		File[] files = topFile.listFiles();
//		for (File file : files) {
//			System.out.println(someSpace + file.getName() + "\t" + file.length());
//			if (file.isDirectory())
//				lengthRecursivelyAllFiles(file, " ");
//		}
		if (topFile.isFile())
			System.out.println(someSpace + topFile.getName() + "\t" + topFile.length());
		else {
			if (topFile.isDirectory()) {
				File[] files = topFile.listFiles();
				for (File file : files)
					lengthRecursivelyAllFiles(file, " ");
			}
		}
	}

	public static void rek(String s) {
//		System.out.println(s);
		if (s.length() > 1) {
			rek(s.substring(2));
		}
		System.out.println(s);
	}

	public static void reku(String s) {
//		System.out.println(s);
		if (s.length() > 1) {
			reku(s.substring(0, s.length()-1));
		}
		System.out.println(s);
	}
	
	public static int rekur(String s) {
		if (s.equals("")) {
			return 0;
		} else {
//			System.out.println(rekur(s.substring(1)) + 1);
			return rekur(s.substring(1)) + 1;
		}
	}
	
	public static int rek05(int n) {
		
		if (n<10) {
			System.out.println("Übergabe (n<10): " + n);
			return n;
		} else {
			System.out.println("Ergebnis (n%10): " + n%10);
			System.out.println("Ergebnis (rek05(n/10)): " + rek05(n/10));
			return (n%10) * rek05(n/10);
		}
	}

	public static void rek06(final int N) {
		if (N > 0) {
			int last = N % 10;
			System.out.println(last);
			rek06(N / 10);
		}
	}
	
	public static String rek07(int n) {
		if(n<100) {
			return ""+n;
		} else {
			return n%100 + rek07(n/100);
		}
	}
	
	public static void show2By2(final int N) {
		if (N > 0) {
			System.out.println(N%100);
			show2By2(N/100);
		}
		
	}
	
	static String spiegel(int n) {
		String s;
		if (n > 0) {
			s = spiegel(n/10);
			return s;
		}
		return Integer.toString(n);
	}
	
	static int spiegel1(int n) {
		int foo;
		if (n > 0) {
			foo = spiegel1(n/10);
		} else {
			return n;
		}
		return foo;
	}

	public static int fibonacciR(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacciR(n - 1) + fibonacciR(n - 2);
	}

}
