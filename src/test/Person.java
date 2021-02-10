package test;

public class Person {
	private String nachname, vorname;

	public Person(String nachname, String vorname) {
		this.nachname = nachname;
		this.vorname = vorname;
	}
	
	protected String getVorname() {
		return this.vorname;
	}

	protected String getNachname() {
		return this.nachname;
	}

	@Override
	public String toString() {
		return "Name: " + vorname + " " + nachname;
	}

}