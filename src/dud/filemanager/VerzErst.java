/**
 * 
 */
package dud.filemanager;

import java.io.*;

/**
 * @author Andreas Rieger
 *
 */
public class VerzErst {

	
	/**
	 * Fordert zur Eingabe eines Strings (hier: Pfad) auf und liefert diesen zurueck
	 * 
	 * @param text: - Enthaelt die Eingabeaufforderung fuer den Benutzer
	 * @return String: eingelesener String
	 * @throws IOException
	 */
	
	public static String eingeben(String text) throws IOException {
		
		System.out.print(text);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		if (s.charAt(s.length() - 1) != File.separatorChar)
			s = s + File.separatorChar;
//		br.close(); // throwing exception when closing the reader before program has finished
		return s;
	}
	
	
	/**
	 * Erstellt ein Verzeichnis: Pfad+Verzeichnis entsprechen dem übergebenen String
	 * 
	 * @param verz: Verzeichnisname + Pfad des zu erstellenden Verzeichnisses
	 */
	
	public static void erstellen(String verz) {
		File f = new File(verz);
		try {
			f.mkdirs();	
		} catch (SecurityException e) {
			e.getMessage();
		}
	}

	
	public static void main(String[] args) throws IOException {
		
	}

}
