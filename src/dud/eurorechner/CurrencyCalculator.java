/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Dateien und Datenströme (DUD)
 */
package dud.eurorechner;

import java.io.*;
import java.util.Scanner;

/**
 * @author andreas
 *
 */
public class CurrencyCalculator {

	/**
	 * @param args
	 */
	private double currate; // define globally?

	public CurrencyCalculator(double currate) {
		this.currate = currate;
	}

	char defineCurrency() {
		
		char cur = 0;
		
		System.out.print("Eingabe der Ausgangswaehrung (E)uro oder (U)S Dollar ? : ");
		
		
		try {
			Reader reader = new BufferedReader (new InputStreamReader (System.in));
			int theCharNum = reader.read();
			while(theCharNum != -1) {
				cur = (char) theCharNum;
				theCharNum = reader.read();
			}
			reader.close();
		} catch(Exception e) {
				e.printStackTrace();
//			} finally {
//				if(theCharNum!=null)
//					reader.close();
			}
		
//		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
//		int c;
//		StringBuilder response= new StringBuilder();
//
//		while ((c = bufferedReader.read()) != -1) {
//		    // Since c is an integer, cast it to a char.
//		    // If c isn't -1, it will be in the correct range of char.
//		    response.append( (char)c ) ;  
//		}
//		String result = response.toString();

		return cur;
	}

	void calculateValue(char cur) {
		String currency = "";
		if (cur == 'e')
			currency = "Euro";
		else if (cur == 'u')
			currency = "Dollar";
		System.out.print(currency + "-Betrag eingeben: ");

//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		double d = Double.parseDouble (input.readLine()); 

		Scanner sis = new Scanner(System.in);
		while (sis.hasNext()) {
//            if (sis.hasNextInt())
//            {
//                final int next = sis.nextInt();
//                output("You entered an Integer = %d", next);
//            }
//            else if (sis.hasNextLong())
//            {
//                final long next = sis.nextLong();
//                output("You entered a Long = %d", next);
//            }
			if (sis.hasNextDouble()) {
				double next = sis.nextDouble();
				double result = next * currate;
				System.out.print("Ergebnis : " + result);
			}
		}
		sis.close();

	}

	boolean redoCalculation() {

		boolean repeat = false;
		System.out.print("Wollen Sie noch einmal j/n? : ");
		Scanner input = new Scanner(System.in);
		char antwort = Character.toLowerCase(input.nextLine().charAt(0));
		if (antwort == 'j')
			repeat = true;
		else
			;
		input.close();
		return repeat;
	}

	public static void main(String[] args) {

		CurrencyCalculator calc = new CurrencyCalculator(1.18);

		char cur = calc.defineCurrency();

		calc.calculateValue(cur);
	}

}
