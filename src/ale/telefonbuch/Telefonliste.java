/**
 * 
 */
package ale.telefonbuch;

import java.util.ArrayList;

/**
 * @author Andreas Rieger
 *
 */
public class Telefonliste {
	
	public TelefonEintrag[] eintrag;
	private int entries = 0;
	
	private ArrayList<TelefonEintrag> telefonliste;
//	private ArrayList<TelefonEintrag> telefonliste = new ArrayList<>();
	
	public Telefonliste() {
		telefonliste = new ArrayList<>();
	}

	public Telefonliste(ArrayList<TelefonEintrag> telefonliste) {
		
	}
	

	
	public void addEntry(String name, String number) {
		telefonliste.add(name);
//		eintrag[entries++] = name;
	}
	
	public boolean modifyEntry(String name, String number, String newname, String newnumber) {
		return false;
	}
	
	private void removeEntry(TelefonEintrag name, TelefonEintrag number) {
		
	}

	private void searchByName(TelefonEintrag name, TelefonEintrag number) {
		
	}

	private void searchNameByNumber(TelefonEintrag name, TelefonEintrag number) {
		
	}
	
	public int size() {
		return telefonliste.size();
	}
	
	public void clear() {
		telefonliste.clear();
	}
}
