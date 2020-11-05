package ale.telefonbuch;




class TelefonlisteTest2 {

	static Telefonliste foo = new Telefonliste();
	
	public static void main(String[] args) {
		foo.addEntry("Frieda", "123456789");
		System.out.println(foo.size());
	}
}

