/**
 * 
 */
package rek;

/**
 * @author Andreas Rieger (s82456@beuth-hochschule.de)
 *
 */
public class LabyrinthTest {
	
	private static int n = 10;

	private static char[ ][ ] lab1 = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
            {'X','X',' ',' ',' ','X','X','X','X','X'},
            {'X','X',' ','X',' ','X','X','X','X','X'},
            {'X','X',' ','X',' ','X','X','X','X','X'},
            {'X','X',' ','X','X','X','X','X',' ',' '},
            {'X','X',' ','X','X','X','X','X',' ','X'},
            {'X','X',' ','X','X','X','X','X',' ','X'},
            {'X','X',' ',' ',' ',' ',' ',' ',' ','X'},
            {'X','X','X','X','X','X','X','X','X','X'},
	};
	
	private static char[ ][ ] lab2 = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{' ',' ',' ',' ',' ','X','X','X','X','X'},
			{'X','X','X','X',' ',' ',' ',' ',' ',' '},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
	};

	private static char[ ][ ] lab3 = {
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{' ',' ',' ',' ',' ','X','X','X','X','X'},
			{'X','X','X','X',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
			{'X','X','X','X','X','X','X','X','X','X'},
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean foundExit = false;
		
		Labyrinth labyrinth = new Labyrinth(lab1);
		foundExit = labyrinth.existWeg(4, 4, n);
		
		Labyrinth labyrinth2 = new Labyrinth(lab2);
		foundExit = labyrinth2.existWeg(4, 4, n);

		Labyrinth labyrinth3 = new Labyrinth(lab3);
		foundExit = labyrinth3.existWeg(4, 4, n);
		
		if (!foundExit)
			System.out.println("No exit found!");
	}

}
