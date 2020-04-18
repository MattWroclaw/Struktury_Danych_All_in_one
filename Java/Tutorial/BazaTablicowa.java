class RekordDanych{ 	  // ta klasa realizuje element składowy listy danych (rekord informacyjny)
	   private String    nazwisko;
	   private int       wiek;
	   private int       Zarobki;
	   
	   String zwrocNazwisko() {
	        return nazwisko;
	   }
	   int  zwrocWiek() {
	        return wiek;
	   }
	   public RekordDanych(String nazwisko, int wiek, int zar){ // Konstruktor klasy
	       this.nazwisko=nazwisko;
	       this.wiek=wiek;
	       Zarobki=zar;
	   }
	 };
	 
public class BazaTablicowa { // ta klasa realizuje klase opakowujaca (dane + indeksy)
	  
	 private final int MaxElt=200;  // maksymalna liczba elementów listy danych w tablicy
	 private int currentCount;      // bieżąca liczba rekordów w tablicy
	 
	 private RekordDanych dane   []; 	// Tablica rekordów typu 'RecordDanych'. Uwaga:
	 								// dwie pierwsze komórki sa zarezerwowane (dane zaczynają się od indeksu 2.)!
	 private int index_Nazwiska  []; // lista indeksowa 1
	 private int index_Wiek      []; // lista indeksowa 2
	 private int index_Zarobki   []; // lista indeksowa 3
	 

	 public BazaTablicowa() { 			// konstruktor klasy
 	     dane			=	new RekordDanych[MaxElt+2];    // Tworzymy pusta tablice danych i indeksów
		 index_Nazwiska =	new int[MaxElt+2]; 
		 index_Wiek     =	new int[MaxElt+2]; 
		 index_Zarobki  =	new int[MaxElt+2];
	     currentCount	= 0; // liczba wpisów w tablicy
	 }	
	 
}
