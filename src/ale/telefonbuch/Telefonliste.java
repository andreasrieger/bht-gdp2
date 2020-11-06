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
		
		boolean found = false;
		
//		if (telefonliste.contains(new TelefonEintrag(name, number))) {
//		
//			TelefonEintrag entry = telefonliste.get(telefonliste.indexOf(new TelefonEintrag(name, number)));	
//			entry.setName(newname);
//			entry.setNumber(newnumber);
//			found = true;
//		} else ;
		
		TelefonEintrag[] all = getEntries();
		for (int i = 0; i < telefonliste.size(); i++) {
			if (all[i].equals(new TelefonEintrag(newname, newnumber))) {
				all[i].setName(newname);
				all[i].setNumber(newnumber);
				found = true;
			} else ;
		}
		return found;
		
	}
	
	public boolean removeEntry(String name, String number) {
		return telefonliste.remove(new TelefonEintrag(name, number));
	}

	public String searchByName(String name) {
//		return telefonliste.get(telefonliste.indexOf(new TelefonEintrag(name, "")));
		TelefonEintrag[] all = getEntries();
		String treffer = "";
		for (int i = 0; i < telefonliste.size(); i++) {
			if (all[i].getName() == name){
				treffer = all[i].toString();
				System.out.println(all[i]);
			}
			
		}
		return treffer;
	}

	public String searchNameByNumber(String number) {
//		return telefonliste.get(telefonliste.indexOf(new TelefonEintrag("", number)));
		TelefonEintrag[] all = getEntries();
		String treffer = "";
		for (int i = 0; i < telefonliste.size(); i++) {
			if (all[i].getName() == number){
				treffer = all[i].toString();
				System.out.println(all[i]);
			}
			
		}
		return treffer;
	}
	
	public int size() {
		return telefonliste.size();
	}
	
	public void clear() {
		telefonliste.clear();
	}
	
	public void showAll() {
		for (TelefonEintrag alle:telefonliste)
			System.out.println("Entries: " + alle);
	}
}
