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
	
	
	private ArrayList<TelefonEintrag> telefonliste;
	
	public Telefonliste() {
		telefonliste = new ArrayList<>();
	}
	
	public Telefonliste(ArrayList<TelefonEintrag> telefonliste) {
		this.telefonliste = telefonliste;
	}

    public TelefonEintrag[] getEntries() {
        return telefonliste.toArray(new TelefonEintrag[0]);
    }
    
	public void addEntry(String name, String number) {
		telefonliste.add(new TelefonEintrag(name, number));
	}
	
	public boolean modifyEntry(String name, String number, String newname, String newnumber) {
		TelefonEintrag newentry = new TelefonEintrag(newname, newnumber);
		int index = telefonliste.indexOf(new TelefonEintrag(name, number));		
		telefonliste.set(index, newentry);
		return telefonliste.contains(newentry);
	}
	
	public boolean removeEntry(String name, String number) {
		return telefonliste.remove(new TelefonEintrag(name, number));
	}

	public TelefonEintrag searchByName(String name) {
		return telefonliste.get(telefonliste.indexOf(new TelefonEintrag(name, "")));
	}

	public TelefonEintrag searchNameByNumber(String number) {
		return telefonliste.get(telefonliste.indexOf(new TelefonEintrag("", number)));

	}
	
	public int size() {
		return telefonliste.size();
	}
	
	public void clear() {
		telefonliste.clear();
	}
}
