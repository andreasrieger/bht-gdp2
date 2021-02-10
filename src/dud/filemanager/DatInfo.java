/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Dateien und Datenströme (DUD)
 */

package dud.filemanager;

import java.io.*;
import java.util.Date;


/**
 * @author Andreas Rieger
 *
 */
public class DatInfo {
	
	public DatInfo() {}
	
	/**
	 * Gibt die letzte Änderung der übergebenen Datei auf der Standardausgabe aus.
	 * 
	 * @param eingabe
	 */
	
	public static void aenderungAusgeben(File eingabe) {
		Date date = new Date(eingabe.lastModified());
		System.out.println("Die Datei wurde zuletzt geaendert am: " + date);
	}
	
	
	/**
	 * Gibt auf der Standardausgabe aus, ob das übergebene File 
	 * eine Datei oder ein Verzeichnis ist.
	 * 
	 * @param eingabe
	 */
	
	public static void dateiOderVerzeichnis(File eingabe) {
		if (eingabe.isFile())
			System.out.println(eingabe + " ist eine Datei.");
		else if (eingabe.isDirectory())
			System.out.println(eingabe + " ist ein Verzeichnis.");
		else ;
	}
	
	
	/**
	 * Prüft, ob die übergebene Datei existiert und gibt das 
	 * Ergebnis als Boolean zurück
	 * 
	 * @param eingabe
	 * @return
	 */
	
	public static boolean existiert(File eingabe) throws IOException {
		return eingabe.exists();
	}
	
	
	/**
	 * Gibt die Größe der übergebenen Datei auf der Standardausgabe aus.
	 * 
	 * @param eingabe
	 */
	
	public static void groesseAusgeben(File eingabe) {
		String s = humanReadableByteCount(eingabe.length(), false);
		System.out.println("Die Datei hat eine Groesse von " + s + ".");
//		System.out.println("Die Datei hat eine Groesse von " + eingabe.length() + " Bytes.");
	}
	
	
	/**
	 * Gibt die Zugriffsrechte der übergebenen Datei auf der Standardausgabe aus.
	 * 
	 * @param eingabe
	 */
	
	public static void lesenSchreiben(File eingabe) {
		if (eingabe.canWrite())
			System.out.println("Die Datei ist aenderbar.");
		else if (eingabe.canRead())
			System.out.println("Die Datei ist lesbar.");
		else ;
	}
	
		
	/**
	 * Gibt den Pfad der übergebenen Datei auf der Standardausgabe aus.
	 * 
	 * @param eingabe
	 */
	
	public static void pfadAusgeben(File eingabe) {
		System.out.println("Der relative Pfad zur Datei ist: " + eingabe.getPath());
		System.out.println("Der absolute Pfad zur Datei ist: " + eingabe.getAbsolutePath());
	}
	
	
	/**
	 * Hilfsmethode zur besseren Lesbarkeit der Dateigroesse
	 * 
	 * @param bytes
	 * @param si
	 * @return
	 */
	
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	
	
	/**
	 * Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		File f = new File(args[0]);
		
		System.out.println("\nInformationen:\n");
		try {
			if (DatInfo.existiert(f))
				System.out.println("Die Datei existiert.");
			else
				System.out.println("Die Datei existiert nicht.");
		} catch (IOException e) {
			e.getMessage();
		}

        DatInfo.dateiOderVerzeichnis(f);
        DatInfo.pfadAusgeben(f);
        DatInfo.lesenSchreiben(f);
        DatInfo.groesseAusgeben(f);
        DatInfo.aenderungAusgeben(f); //lesbar machen!
	}
	
}
