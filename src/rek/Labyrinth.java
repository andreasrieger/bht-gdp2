/**
 * 
 */
package rek;

import java.util.Arrays;

/**
 * @author Andreas Rieger (s82456@beuth-hochschule.de)
 *
 */
public class Labyrinth {

	private char[ ][ ] lab;
	
	public Labyrinth (char [][] labInput) {
		this.lab = labInput;
	}
	
	public boolean existWeg(int i, int j, int n) {
		
		if (i < 0 || j < 0 || i == n || j == n) {
//			System.out.println("\nAusgang gefunden!");
//			System.out.println(Arrays.deepToString(lab).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
//			System.out.print("Vom Ausgang zum Startpunkt: ");
			return false; // Im Beispiel aus dem Buch steht hier "false"!
		}
		if (lab[i][j] != ' '){
//			System.out.println("Wand!");
			return false;
		}
		
		lab[i][j] = '*';
//		System.out.println("Hier geht's lang!");
		
		if (i == n-1 || j == n-1
				|| existWeg (i+1, j, n)
				|| existWeg (i, j+1, n)
				|| existWeg (i-1, j, n)
				|| existWeg (i, j-1, n)) {
			System.out.println("\nAusgang gefunden!");
//			System.out.println(Arrays.deepToString(lab).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
			System.out.print("Vom Ausgang zum Startpunkt: ");
			System.out.print("(" + i + "," + j + ")");
			return true;
		}
		return false;
	}
}
