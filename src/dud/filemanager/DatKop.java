/**
 * 
 */
package dud.filemanager;

import java.io.*;

/**
 * @author Andreas Rieger
 *
 */
public class DatKop {
	

	/**
	 * Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen
	 * 
	 * @param args[0]: Quelle; String args[1]: Ziel
	 */
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * Kopiert eine Datei von quelle nach ziel und gibt eine Statusmeldung 
	 * auf der Standardausgabe ueber den Erfolg aus.
	 * 
	 * @param quelle: Pfad zur Quelldatei;
	 * @param ziel: Pfad zur Zieldatei;
	 */
	
	public static void kopieren(String quelle, String ziel) {

		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(quelle);
			out = new FileOutputStream(ziel);
			long dateiLaenge = (new File(quelle)).length();
			byte[] b = new byte[(int) dateiLaenge];
			int len;
			while ((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
			System.out.println("Die Datei wurde erfolgreich kopiert.");
		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
			File f = null;
			try{
				f = new File(ziel);
				f.createNewFile();
			} catch (IOException e) {
				e.getMessage();
			}
		} catch (IOException e2) {
			e2.getMessage();
		} finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				e.getMessage();
			} catch (NullPointerException e2) {
				e2.getMessage();
			} 
		}
	}
	
}
