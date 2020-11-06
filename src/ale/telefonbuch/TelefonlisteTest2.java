package ale.telefonbuch;


class TelefonlisteTest2 {

	static Telefonliste foo = new Telefonliste();
	
	public static void main(String[] args) {
		foo.addEntry("Frieda", "123456789");
		System.out.println(foo.size());
		foo.showAll();
		
		String test = "Name: Frieda Nummer: 123456789";
		String search = foo.searchByName("Frieda");
		if (test.equals(search))
			System.out.println("Found: " + search + " equals " + test);
	}
}

