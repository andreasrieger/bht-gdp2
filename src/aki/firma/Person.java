package aki.firma;

/**
 * Abstrakte Person Klasse. Diese Klasse ist abstrakt, weil eine Person ansich
 * fuer eine Firma nicht existiert, sondern eine Person immer entweder ein
 * Angestellter oder ein Kunde ist. Dies wird wiedergespiegelt mit dem Konzept
 * der abstrakten Klasse. Der gemeinsame Teil fuer Angestellter und Kunde ist in
 * der Klasse Person beinhaltet.
 * 
 * @author S. Kaltofen, Andreas Rieger
 * @version 2.5
 */

public abstract class Person implements Comparable<Person> {

	// Instanzvariablen
	protected String nachname;
	protected String vorname;
	protected String strasse;
	protected String hausnummer;
	protected String ort;
	protected String plz;
	protected boolean weiblich; // Ist Person maennlich=> weiblich=false,
								// ist sie weiblich: weiblich=true

	/**
	 * Parameterloser Konstruktor mit Initialisierung der Attribute mit
	 * Muster-Werten.
	 */
	public Person() {
		this.nachname = "Muster";
		this.vorname = "MusterVorname";
		this.strasse = "MusterStrasse";
		this.hausnummer = "xx";
		this.ort = "MusterOrt";
		this.plz = "plzpl";
		this.weiblich = true;
	}

	/**
	 * Mit diesem Konstruktor erfolgt die Initialisierung der Attribute durch die
	 * uebergebenen Parameter.
	 * 
	 * @param nachname   Nachname der Person
	 * @param vorname    Vorname der Person
	 * @param strasse    Strasse zur Adresse der Person
	 * @param hausnummer Hausnummer zur Adresse der Person
	 * @param ort        Ort zur Adresse der Person
	 * @param plz        PLZ zur Adresse der Person
	 * @param weiblich   Flag ob Person weiblich ist
	 */
	public Person(String nachname, String vorname, String strasse, String hausnummer, String ort, String plz,
			boolean weiblich) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.ort = ort;
		this.plz = plz;
		this.weiblich = weiblich;

	}

	/**
	 * Getter des Attributes weiblich.
	 * 
	 * @return ob die Person weiblich ist
	 */
	public boolean isWeiblich() {
		return weiblich;
	}

	/**
	 * gibt die Anrede zurueck. Diese Methode ist abstrakt und wird erst bei der
	 * Weitervererbung (an Kunde und Angestellter) weiter definiert.
	 * 
	 * @return die Anrede
	 */

	protected abstract String getAnrede();

	/**
	 * Die Methode gibt die Adresse einer Person-Objekt zurück.
	 * 
	 * @return die Adresse als ein Array von String-Objekte
	 */

	public String[] getAdresse() {
		String[] adresse = new String[4];
		adresse[0] = getAnrede();
		adresse[0] = " " + vorname + " " + nachname;
		adresse[1] = " " + strasse + " " + hausnummer;
		adresse[2] = " " + plz + " " + ort;
		return adresse;
	}

	/**
	 * Die Methode getName() gibt Vornamen und Nachnamen zurueck.
	 * 
	 * @return Vorname gefolgt von " - " gefolgt vom Nachname
	 */
	public String getName() {
		return vorname + " - " + nachname;
	}

	/**
	 * This method returns a string with a persons contact details
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "[Nachname=" + this.nachname + ", Vorname=" + this.vorname + ", Strasse=" + this.strasse
				+ ", Hausnummer=" + this.hausnummer + ", Ort=" + this.ort + ", Plz=" + this.plz + ", weiblich="
				+ this.weiblich + "]";
	}

	/**
	 * Programming the obligatory compareTo method from Comparable interface
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */

	@Override
	public int compareTo(Person o) {
		return this.getName().compareTo(o.getName());
	}

}
