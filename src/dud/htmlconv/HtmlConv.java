/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Dateien und Datenströme (DUD)
 */
package dud.htmlconv;

import java.io.*;

/**
 * Klasse zum Einlesen und Konvertieren von Sonderzeichen in einer Datei.
 * Die Ausgabe des konvertierten Dateiinhalts erfolgt in einer separaten Datei. 
 * 
 * @author Andreas Rieger, s82456@beuth-hochschule.de
 * @version 1.0, 2020-10-19
 */
public class HtmlConv {

	
	/**
	 * Main-Methode zur Durchfuehrung der Zeichenkonvertierung
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		String s = "";
//		String sfn = "/Users/andreas/Code/Data/datei1702_vor.html";
		String sfn = "data/datei1702_vor.html"; // relativer Pfad
//		String tfn = "/Users/andreas/Code/Data/datei1702_nach.html";
		String tfn = "data/datei1702_nach.html"; // relativer Pfad
		File f = createFile(tfn);

		FileInputStream fi = new FileInputStream(sfn);
		InputStreamReader is = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(is);
		
		while(br.ready()) {
			s = br.readLine();
			writeStringToFile(f, replaceSpecialChars(s));
		}		
		fi.close();
	}
	
	
	/**
	 * Methode ersetzt bzw. konvertiert die Sonderzeichen
	 * @param s
	 * @return
	 */

	public static String replaceSpecialChars(String s) {
		
		String[] u = {"ä","ö","ü","Ä","Ö","Ü","ß"};
		String[] uc = {"&auml;","&ouml;","&uuml;","&Auml;","&Ouml;","&Uuml;","&szlig;"};
		
		for (int j = 0; j < u.length; j++) {
			s = s.replaceAll(u[j], uc[j]);
		}
		return s;
	}
	
	/**
	 * Methode zum Anlegen einer Datei
	 * 
	 * @param fn
	 * @return
	 * @throws IOException
	 */
	
	private static File createFile(String fn) throws IOException {
		  
		File f = new File(fn);
        f.createNewFile();
        return f;
    }
	
	
	/**
	 * Methode zum Schreiben des konvertierten Inhalts in eine neue Datei 
	 * 
	 * @param f
	 * @param s
	 * @throws IOException
	 */
	
	public static void writeStringToFile(File f, String s) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(f, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
//      BufferedWriter bw = new BufferedWriter(new FileWriter(f, true)); // Alternative
        
        bw.write(s);
        bw.newLine();
        bw.close();
	}
}
