import java.util.Calendar;

/**
 * Klasse zum Erzeugen von Auto Objekten.
 * 
 * @author Andreas Rieger
 * @version 1.0, 11/2019
 */

public class EinfachesAuto {

    // Instanzvariablen
    private String besitzer;
    private String autotyp;
    private String farbe;
    private int erstzulassung;
    private int leistung;
    private int kmStand;

    /**
     * Konstruktor fuer die Klasse EinfachesAuto
     * 
     * @param besitzer
     *            Name des Autobesitzers
     * @param autotyp
     *            Typ des Autos
     * @param farbe
     *            Farbe des Autos
     * @param erstzulassung
     *            Jahreszahl der Autozulassung
     * @param leistung
     *            PS-Zahl des Autos
     * @param kmStand
     *            Kilometerstand des Autos
     */

    public EinfachesAuto(String besitzer, String autotyp, String farbe,
            int erstzulassung, int leistung, int kmStand) {
        this.besitzer = besitzer;
        this.autotyp = autotyp;
        this.farbe = farbe;
        this.erstzulassung = erstzulassung;
        this.leistung = leistung;
        this.kmStand = kmStand;
    }

    /**
     * Die Methode getAlter() dient zur Errechnung des Autoalters ueber die
     * Erstzulassung.
     * 
     * @return int: Alter des Autos
     */
    public int getAlter() {
        // Ermittlung des aktuellen Jahres
        Calendar aktuellerKalender = Calendar.getInstance();
        int aktuellesJahr = aktuellerKalender.get(Calendar.YEAR);
        return aktuellesJahr - this.erstzulassung;
    }

    /**
     * Die Methode meldung() gibt die Attribute "farbe" und "besitzer" auf der
     * Standardausgabe aus.
     */
    public void meldung() {
        System.out.print("Hier gruesst das " + this.farbe + "e ");
        System.out.print("Auto von " + this.besitzer);
    }
    
    /**
     * Die Methode twoEmptyLines() gibt zwei Leerzeilen bzw. einen Zeilenumbruch 
     * und eine Leerzeile aus.
     */
    public void twoEmptyLines() {
	    System.out.println();
	    System.out.println();
    }

}