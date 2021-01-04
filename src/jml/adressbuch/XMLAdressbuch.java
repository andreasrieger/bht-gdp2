/**
 * 
 */
package jml.adressbuch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

		List liste = getAlleNamen(doc.getDocumentElement(), "");
	}

	public static ArrayList<String> getAlleNamen(Element e, String ebene) {
//		    public void readNames(Element e, String ebene) {
		NodeList children = e.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node knoten = children.item(i);
			// Knoten ist ein ELEMENT_NODE
			if (knoten.getNodeType() == Node.ELEMENT_NODE)
				// Rekursiver Aufruf von traversieren fuer aktuelles Element
				getAlleNamen((Element) knoten, ebene + " ");
			// Knoten ist ein TEXT_NODE
			else if (knoten.getNodeType() == Node.TEXT_NODE) {
				String inhalt = knoten.getTextContent();
				if (inhalt.trim().length() > 0) // leerer Inhalt?
					System.out.println(ebene + " :" + inhalt);
			} else
				// kein ELEMENT_NODE, kein TEXT_NODE
				System.out.println(ebene + knoten);
		}
		return foo;
	}
}
