/*
 * Grundlagen der Programmierung II
 * Lerneinheit: Java und XML (JML)
 */
package jml.adressbuch;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Andreas Rieger (s82456@beuth-hochschule.de)
 *
 */
public class XMLAdressbuch {

	private static String XMLDateiName = "/Users/andreas/Git/vfh-gdp2/src/jml/adressbuch/adressen2.xml";

	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		// Uebergebene XML-Datei parsen
		Document doc = builder.parse(new File(XMLDateiName));

		ArrayList<String> liste = getAlleNamen(doc.getDocumentElement());
		System.out.println(liste);

		for (String listelement : liste) {
			String[] nameElements = listelement.split(", ");
			String forename = nameElements[0];
			String surname = nameElements[1];

			ArrayList<Kontakt> adressen = getAdressenDaten(doc.getDocumentElement(), forename, surname);
			for (Kontakt adresse : adressen) {
				System.out.println("-- ");
				System.out.println(adresse.getVorname() + " " + adresse.getNachname());
				System.out.println(adresse.getStrasse());
				System.out.println(adresse.getPlz() + " " + adresse.getOrt());
			}
		}

	}

	public static int getContactsCount(Element e) {
		NodeList contacts = e.getElementsByTagName("Kontakt");
		return contacts.getLength();
	}

	public static ArrayList<String> getAlleNamen(Element e) {

		ArrayList<String> contactnames = new ArrayList<>();

		NodeList names = e.getElementsByTagName("Name");
		for (int i = 0; i < names.getLength(); i++) {

			// Single Name element
			Node name = names.item(i);
			NodeList nameElements = name.getChildNodes();
			Node forename = nameElements.item(1);
			Node surname = nameElements.item(3);
			String fullname = forename.getTextContent() + ", " + surname.getTextContent();
			contactnames.add(fullname);
		}
		return contactnames;
	}

	public static ArrayList<Kontakt> getAdressenDaten(Element e, String vorname, String nachname) {

		ArrayList<Kontakt> contactDetails = new ArrayList<>();

		NodeList contacts = e.getElementsByTagName("Kontakt");

		for (int i = 0; i < contacts.getLength(); i++) {
			Node contact = contacts.item(i);
			NodeList contactElements = contact.getChildNodes();

			Node name = contactElements.item(1);
			NodeList nameElements = name.getChildNodes();

			Node forename = nameElements.item(1);
			Node surname = nameElements.item(3);
			String forenameStrg = forename.getTextContent();
			String surnameStrg = surname.getTextContent();
			if (forenameStrg.equals(vorname) && surnameStrg.equals(nachname)) {
				Node address = contactElements.item(3);
				NodeList addressElements = address.getChildNodes();
				Node street = addressElements.item(1);
				Node zipCode = addressElements.item(3);
				Node city = addressElements.item(5);
				Node country = addressElements.item(7);
				String streetStrg = street.getTextContent();
				String zipCodeStrg = zipCode.getTextContent();
				String cityStrg = city.getTextContent();
				String countryStrg = country.getTextContent();
				Kontakt newContact = new Kontakt(null, surnameStrg, forenameStrg, streetStrg, zipCodeStrg, cityStrg,
						countryStrg);
				contactDetails.add(newContact);
			}
		}

		return contactDetails;
	}
}
