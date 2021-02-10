/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Dateien und Datenströme (DUD)
 */

package dud.eurorechner;

import java.io.*;
import java.util.Locale;
import java.text.NumberFormat;

/**
 * This class is generating a currency calculator to transform Euro value into
 * Dollar value and vice versa. The user can chose a currency to start with and 
 * then enter a value to be calculated.
 * 
 * @author Andreas Rieger, (s82456@beuth-hochschule.de)
 * @version 1.0, 10/2020
 */
public class Eurorechner {
	
	private double cr; // define globally?
	
	
	/**
	 * Constructor of class Eurorechner with parameter to initialize currency rate
	 * 
	 * @param cr
	 * 		currency rate
	 */
	
	public Eurorechner(double cr) {
		this.cr = cr;
	}

	
	/**
	 * This method lets the user chose the currency for the value
	 * 
	 * @return currency represented by 'e' for Euro or 'u' for US Dollar as single character
	 */
	
	public char defineCurrency() {
		
		char c = 0;
		boolean correct = false;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			do {
				System.out.print("Eingabe der Ausgangswaehrung (E)uro oder (U)S Dollar ? : ");
				String text = input.readLine();
				if (!text.isEmpty()) {
					c = text.toLowerCase().charAt(0);
					if ((c == 'e') || (c == 'u'))
						correct = true;
					else
						showMessage(1);
				} else
					showMessage(1);		
			} while (!correct);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			//input.close(); //???
		} 
		return c;
	}
	
	
	/**
	 * Method to calculate the targeted value based on chosen currency
	 * 
	 * @param c
	 * 		chosen currency to start with
	 * @return Calculated value of targeted currency
	 */
	
	public double calculateValue(char c) {
		
		double value = 0;
		double result = 0;
		boolean correct = false;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			try {
				System.out.print("Bitte geben Sie den " + currencyNameIn(c) + "-Betrag ein: ");
				value = Double.parseDouble(input.readLine().replaceAll("\\,","."));
//				value = dataInputStream.readDouble(); // Alternative, not tested
				correct = true;
			} catch (NumberFormatException e) {
				showMessage(1);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
//				input.close(); // throwing IOException
			}
		} while (!correct);
		if (c == 'e')
			result = value * cr;
		else
			result = value / cr;
		return result;
	}
	
	
	/**
	 * Method to ask the user for repeating the calculation
	 * 
	 * @return true if the user wants to repeat, otherwise false
	 */
	
	public boolean redoCalculation() {
		
		boolean repeat = true;
		boolean correct = false;
		
		System.out.print("Wollen Sie noch einmal j/n? : ");
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		do {

			try {				
				String text = input.readLine();
				if (!text.isEmpty()) {
					char c = text.toLowerCase().charAt(0);
					if ((c != 'j') && (c != 'n'))
						showMessage(1);
					if ((c == 'j') || (c == 'n')) {
						correct = true;
						if (c == 'n')
							repeat = false;
					}
				} else
					showMessage(1);
			} catch (IOException e) {
//				e.printStackTrace();
				showMessage(1);
			}
		} while (!correct);
		return repeat;
	}
	
	
	/**
	 * Static method to define currency name to be used in text
	 * 
	 * @param c
	 * 		chosen currency
	 * @return full name of the chosen currency
	 */
	
	public static String currencyNameIn(char c) {
		Character ci = c;
		String cn = ci.equals('e') ? "Euro" : "US Dollar";
		return cn;
	}
	
	
	/**
	 * Static method to define currency name to be used in text
	 * 
	 * @param c
	 * 		chosen currency
	 * @return full name of the target currency
	 */
	
	public static String currencyNameOut(char c) {
		Character co = c;
		String cn = co.equals('e') ? " US Dollar" : " Euro";
		return cn;
	}
	
	
	/**
	 * Method to nicely format the calculated result
	 * 
	 * @param d
	 * 		the value to be formatted
	 * @return the formatted value
	 */
	
	public String formatResult(double d) {
		NumberFormat locformat = NumberFormat.getInstance(Locale.getDefault());
		locformat.setMinimumFractionDigits(2);
		locformat.setMaximumFractionDigits(2);		
		String value = locformat.format(d);
		return value;
	}
	
	
	/**
	 * Method to show different text messages (e.g.: warnings, etc.)
	 * 
	 * @param num
	 * 		case number
	 */
	
	public void showMessage(int num) {
		switch(num) {
			case 1:
				System.out.println("Fehlerhafte Eingabe - bitte noch einmal! ");
				break;
			default:
				System.out.println("Fehlerhafte Eingabe - bitte noch einmal!");
		}
		
	}
	
	
	/**
	 * Main method to start with
	 * 
	 * @param args
	 * 		no arguments
	 */
	
	public static void main(String[] args) {
		
		/**
		 * Instantiate an object for Eurorechner
		 */
		Eurorechner calc = new Eurorechner(1.18);
		
		do {
			char c = calc.defineCurrency();
			String fr = calc.formatResult(calc.calculateValue(c));
			System.out.println("Ergebnis: " + fr + currencyNameOut(c));
		} while (calc.redoCalculation());
		
		System.out.println("Vielen Dank, dass Sie Eurorechner benutzt haben! :)");
	}

}
