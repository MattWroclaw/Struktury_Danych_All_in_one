//----------------------------------------------------------------------------------------------
class Osoba {
	private   String nazwiskorodowe;
	protected String nazwisko;
	protected String adres;
	public int wiek;

	public Osoba (String s_nazw, int s_wiek, String s_adres, String s_rodowe){ // Konstruktor
	  nazwisko= s_nazw;
	  wiek=s_wiek;
	  adres=s_adres;
	  nazwiskorodowe=s_rodowe;
	}
	
	public void pisz() { // Wypisujemy obiekt klasy Osoba
		System.out.println("  [Klasa Osoba] -> metoda pisz()");
		System.out.println("\t Nazwisko: " + nazwisko + " nazwisko rodowe: "+ nazwiskorodowe + ", wiek: "+ wiek + ", miasto: "+ adres);
	}	
	public void ukryjNazwiskoRodowe() { // Wymazujemy nazwisko rodowe np. z powodu ustawy RODO
		System.out.println("  [Klasa Osoba] -> Wymazuję nazwisko rodowe");
		nazwiskorodowe="**********";
	}
	public String getNazwiskoRodowe() {   // Zwróć nazwisko rodowe 
		return nazwiskorodowe;
	}
}
// ----------------------------------------------------------------------------------------------

class Pracownik extends Osoba { // Klasa pracownik dziedziczy z klasy Osoba	
    private String wydzial;        // nowy atrybut
	private int placa;             // nowy atrybut
	
	
  public Pracownik (String p_nazw, int p_wiek, String p_adres, String p_rodowe, String p_wydzial, int p_placa){ // Konstruktor
      super(p_nazw, p_wiek, p_adres, p_rodowe); // wywołanie konstruktora klasy nadrzędnej musi być na samym początku! 
	  wydzial= p_wydzial;
  	  placa=p_placa;
  }
	
  public void pisz() {   // Zauważ, że podobna nazwa występowała w klasie Osoba!
	  System.out.println("[Klasa Pracownik] -> metoda pisz() - najpierw wywołamy pisz() klasy nadrzędnej:");
	  super.pisz(); // Wywołujemy metodę klasy nadrzędnej
	  System.out.println("\t Wydział: " +  wydzial + ", płaca: " + placa);
  }
}

// -- Program główny
class Dziedzic {
  public static void main(String[] args) {
	  Osoba os= new Osoba ("Doe", 60, "NowyYork", "-");
	  os.pisz();
	  Pracownik pr= new Pracownik ("Kowalska", 55, "Wrocław", "Konopnicka", "Dział kadr", 4500);
	  pr.pisz();
	  pr.ukryjNazwiskoRodowe(); // Wykasuje nazwisko rodowe (używana jest metoda klasy bazowej!)
	  pr.pisz();
  }
}