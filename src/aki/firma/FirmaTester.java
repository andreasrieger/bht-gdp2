/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Abstrakte Klassen und Interfaces (AKI)
 */
package aki.firma;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Klasse zum Testen des einfachen Firmen- Verwaltungsprogramms.
 * 
 * @author Agathe Merceron, Andreas Rieger
 * @version 1.1
 */

public class FirmaTester {

	/**
	 * Main-Methode.
	 * 
	 * @param args Uebergabeparameter
	 */
	public static void main(String[] args) {
		Firma kmu = new Firma(4, "Java4You");
		Angestellte ang1 = new Angestellte("Taylor", "Elisabeth", "Amrummer Strasse", "10", "Hamburg", "13353", true,
				410000f);
		kmu.addAngestellte(ang1);
		// result should be 410000
		System.out.println(kmu.alleGehaelter());
		Angestellte ang2 = new Angestellte("Mueller", "Mark", "Amrummer Strasse", "11", "Berlin", "13353", false,
				10000f);
		kmu.addAngestellte(ang2);
		// result should be 420000
		System.out.println(kmu.alleGehaelter());
		Kunde k1 = new Kunde("Cruise", "Tom", "Amrummer Strasse", "12", "Frankfurt", "13353", false);
		kmu.addKunde(k1);
		// result should be 0
		System.out.println(k1.getKundenNr());
		Kunde k2 = new Kunde("Jolie", "Angelina", "Amrummer Strasse", "13", "Nizza", "13354", true);
		kmu.addKunde(k2);
		// result should be 1
		System.out.println(k2.getKundenNr());
		// check we have the right people
		kmu.alleAdressenAusgeben();
		Kunde k3 = new Kunde("Deneuve", "Catherine", "Amrummer Strasse", "14", "Paris", "13353", true);
		// should not be possible
		kmu.addKunde(k3);
		// should be true
		System.out.println(kmu.istVoll());

		// Instantiating an array Person w/ data from Firma class
		Person[] alle = kmu.getAllePersonen();

		// Array unsorted
		System.out.println("\nUnsorted: ");
		System.out.println(Arrays.deepToString(alle));
//        System.out.println(Arrays.toString(alle)); // no difference to deepToString method

		// Array sorted by first name
		Arrays.sort(alle, (p1, p2) -> p1.vorname.compareTo(p2.vorname));
		System.out.println("\nFirst name sorted: ");
		System.out.println(Arrays.deepToString(alle));

		Arrays.sort(alle);
		System.out.println("\nFirst name sorted (w/ compareTo method from Person class): ");
		System.out.println(Arrays.deepToString(alle));

		/**
		 * Declaring a subclass to implement the Comparator<T> interface
		 * 
		 * @author Andreas Rieger
		 *
		 */

		class PlzComparator implements Comparator<Person> {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.plz.compareTo(o2.plz);
			}

		}

		// Array sorted by PLZ
		Arrays.sort(alle, new PlzComparator());
		System.out.println("\nPLZ sorted: ");
		System.out.println(Arrays.deepToString(alle));

		// Array sorted by PLZ w/ Lambda expression
		Arrays.sort(alle, (o1, o2) -> o1.plz.compareTo(o2.plz));
		System.out.println("\nPLZ sorted w/ Lambda expression: ");
		System.out.println(Arrays.deepToString(alle));

		// Array sorted by Ort w/ Lambda expression
		Arrays.sort(alle, (p1, p2) -> p1.ort.compareTo(p2.ort));
		System.out.println("\nCity sorted w/ Lambda expression: ");
		System.out.println(Arrays.deepToString(alle));

	}

}
