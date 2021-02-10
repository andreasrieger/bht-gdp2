/*
 * Grundlagen der Programmierung II
 * Lerneinheit: ArrayList<E> (ALE)
 */
package ale.telefonbuch;

import java.util.ArrayList;

/**
 * This class is managing entries of type TelefonEintrag in an ArrayList
 * 
 * @author Andreas Rieger (s82456@beuth-hochschule.de)
 * @version 1.0, 11/2020
 */
public class Telefonliste {

	private ArrayList<TelefonEintrag> telefonliste;

	/**
	 * Constructor to generate an empty ArrayList<>
	 */
	public Telefonliste() {
		telefonliste = new ArrayList<>();
	}

	/**
	 * Constructor to generate an ArrayList<> w/ entries of type TelefonEintrag
	 * 
	 * @param telefonliste
	 */
	public Telefonliste(ArrayList<TelefonEintrag> telefonliste) {
		this.telefonliste = telefonliste;
	}

	/**
	 * Method to create an array of all entries
	 * 
	 * @return TelefonEintrag[]
	 */
	public TelefonEintrag[] getEntries() {
		return telefonliste.toArray(new TelefonEintrag[0]);
	}

	/**
	 * Method to add an entry of type TelefonEintrag to ArrayList
	 * 
	 * @param name
	 * @param number
	 */
	public void addEntry(String name, String number) {
		telefonliste.add(new TelefonEintrag(name, number));
	}

	/**
	 * Method to modify an existing entry
	 * 
	 * @param name
	 * @param number
	 * @param newname
	 * @param newnumber
	 * @return true if entry was found, otherwise false
	 */
	public boolean modifyEntry(String name, String number, String newname, String newnumber) {

//		boolean found = telefonliste.contains(new TelefonEintrag(name, number));
		int index = telefonliste.indexOf(new TelefonEintrag(name, number));

//		if (found)
		if (index >= 0)
		{
			TelefonEintrag entry = telefonliste.get(index);
			entry.setName(newname);
			entry.setNumber(newnumber);
			return true;
		} else
			return false;

//		return found;

	}

	/**
	 * Method to remove an existing entry
	 * 
	 * @param name
	 * @param number
	 */
	public void removeEntry(String name, String number) {
		telefonliste.remove(new TelefonEintrag(name, number));
	}

	/**
	 * Method to search an entry by a given name
	 * 
	 * @param name
	 * @return String of the found entry
	 */
	public String searchByName(String name) {
		
//		TelefonEintrag[] allentries = getEntries();
		String found = "";
		
//		for (TelefonEintrag entry : allentries)
		for (TelefonEintrag entry : telefonliste) {
//			if (entry.getName() == name) 
			if (entry.getName().equals(name)) 
			{
				found = entry.toString();
				return found;
			}
		}
		return found;
	}

	/**
	 * Method to search an entry by a given number
	 * 
	 * @param number
	 * @return String of the found entry
	 */
	public String searchNameByNumber(String number) {
		
//		TelefonEintrag[] allentries = getEntries();
		String found = "";
		
//		for (TelefonEintrag entry : allentries) 
		for (TelefonEintrag entry : telefonliste)			
		{
//			if (entry.getNumber() == number) {
			if (entry.getNumber().equals(number)) 
			{
				found = entry.toString();
				return found;
			}
		}
		return found;
	}

	/**
	 * Method to evaluate the ArrayList size
	 * 
	 * @return Size of ArrayList
	 */
	public int size() {
		return telefonliste.size();
	}

	/**
	 * Method to remove all entries from ArrayList
	 */
	public void clear() {
		telefonliste.clear();
	}

	/**
	 * Method to print all entries of ArrayList
	 */
	public void showAll() {
		for (TelefonEintrag alle : telefonliste)
			System.out.println("Entries: " + alle);
	}
}
