package test;

public class Angestellte extends Person {
	
	float gehalt;
	
	public Angestellte(String vorname, String nachname, float gehalt) {
		super(nachname, vorname);
		this.gehalt = gehalt;
	}

	public String getGehalt() {
		if (this.gehalt == 0)
			return "Kein Verdienst";
		else
			return String.valueOf(this.gehalt);
	}

	@Override
	public String toString() {
		return "Der Angestellte " + super.getVorname() + " " + 
				super.getNachname() + " verdient " + this.gehalt + " €.";
	}

	public static void main(String[] args) {
		
		Angestellte employee = new Angestellte("Max", "Mustermann", 5000.00f);
		System.out.println(employee);
	}
}