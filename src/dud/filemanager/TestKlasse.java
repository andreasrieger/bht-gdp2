/**
 * 
 */
package dud.filemanager;

import java.io.*;

/**
 * @author Andreas Rieger
 *
 */
public class TestKlasse {

	public TestKlasse() {
		
	}
	
	/**
	 * Test-Mainfunktion, um die Klasse als Stand-Alone-Applikation zu testen
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) throws IOException {
		
		String dpath = "";
		
//		TestKlasse test = new TestKlasse();
		
		do {
			try {
				dpath = VerzErst.eingeben("Welchen Pfad soll das Verzeichnis haben? : ");
				VerzErst.erstellen(dpath);
				System.out.println("Das Verzeichnis " + dpath + " wurde erstellt.");
			} catch (IOException e) {
				e.getMessage();
			} finally {
				
			}
		} while (decideYesOrNo("Moechten Sie ein weiteres Verzeichnis anlegen? (j/n) : "));
		
		if (decideYesOrNo("Moechten Sie eine Datei kopieren? (j/n) : ")) {
			do {
				String fsource = getSource();
				String ftarget = getTarget();
				DatKop.kopieren(fsource, ftarget);
			} while (decideYesOrNo("Moechten Sie eine weitere Datei kopieren? (j/n) : "));
		} else ;
		
		System.out.print("Vielen Dank!");
		System.exit(0);
	}
	
	
	/**
	 * Methode zur Ermittlung des Pfades einer vorhandenen Datei 
	 * 
	 * @return
	 * @throws IOException
	 */
	
	public static String getSource() throws IOException {
		
		String path = "";
		File f = null;
		
		do {
			System.out.print("Bitte geben Sie den Pfad fuer die zu kopierende Datei an: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			path = br.readLine();
			f = new File(path);
			DatInfo.pfadAusgeben(f);
		} while (!DatInfo.existiert(f));
//		br.close(); // throwing exception when closing the reader before program has finished
		return path;
	}

	
	/**
	 * Methode zur Ermittlung des Ziel-Pfades einer zu kopierenden Datei 
	 * 
	 * @return
	 * @throws IOException
	 */
	
	public static String getTarget() throws IOException {
		
		String path = "";
		File f = null;
				
		do {
			System.out.print("Bitte geben Sie den Pfad an," +
					" wohin die Datei kopiert werden soll: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			path = br.readLine();
			f = new File(path);
		} while (DatInfo.existiert(f));
		
//		br.close(); // throwing exception when closing the reader before program has finished
		return path;
	}
	
	
	/**
	 * Method to ask the user for repeating the last action
	 * 
	 * @return true if the user wants to repeat, otherwise false
	 */
	
	public static boolean decideYesOrNo(String message) {
		
		boolean yes = false;
		boolean correct = true;
		
		System.out.print(message);
		
		do {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String s = br.readLine();
				if (!s.isEmpty()) {
					char c = s.toLowerCase().charAt(0);
					if ((c == 'j') || (c == 'n')) {
						if (c == 'j')
							yes = true;
					} else {
						correct = false;
						showMessage(1);
//						System.out.print("Fehlerhafte Eingabe - bitte noch einmal!");
					}
				} else {
					correct = false;
				}
			} catch (IOException e) {
				e.getMessage();
//				correct = false;
			}
		} while (!correct);
		return yes;
	}
	
	
	/**
	 * Method to show different text messages (e.g.: warnings, etc.)
	 * 
	 * @param num
	 * 		case number
	 */
	
	public static void showMessage(int num) {
		switch(num) {
			case 1:
				System.out.println("Fehlerhafte Eingabe - bitte noch einmal! ");
				break;
			case 2:
				System.out.println("Der Dateipfad ist fehlerhaft oder die Datei existiert nicht! ");
				break;
			default:
				System.out.println("Fehlerhafte Eingabe - bitte noch einmal!");
		}
		
	}

}
