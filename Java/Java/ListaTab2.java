class Fiszka{ 	  // Ta klasa realizuje element składowy listy danych
	   private String    nazwisko; 	// (rekord informacyjny)
	   private int       wiek;
	   
	   String zwrocNazwisko() {
	        return nazwisko;
	   }
	   int  zwrocWiek() {
	        return wiek;
	   }
	   public Fiszka(String nazwisko, int wiek){ // Konstruktor klasy
	       this.wiek=wiek;
	       this.nazwisko=nazwisko;
	   }
	 };
	 
	public class ListaTab2 {
	  
	 private final int MaxTab=200;  // Stała określajśca rozmiar tablicy
	 private int currentCount;      // Liczba rekordów w tablicy
	 
	 private Fiszka tab[]; 			// Tablica rekordów typu 'Fiszka'. Uwaga:
	 								// dwie pierwsze komórki są zarezerwowane (dane zaczynają się od indeksu 2.)!

	 public ListaTab() { 			// Konstruktor klasy
	    tab=new Fiszka[MaxTab];     // Tworzymy pustą tablicę	
	    currentCount=0;             // Liczba wpisów w tablicy
	 }	
	 
	 void WstawNaKoniec(String nazwisko, int wiek) {
		//wstawiamy na koniec listy
		  Fiszka nowy=new Fiszka(nazwisko, wiek);
		  if (currentCount<MaxTab-2){ // Dwie pierwsze komórki są zarezerwowane!
		    tab[currentCount]=nowy;   // Wstaw nowy obiekt do listy
		    currentCount++;           // Lista ma teraz jeden element wiecej
		  }
		  else
		    System.out.println("Tablica pełna!");
		}
		void WstawNaPozycje(String nazwisko, int wiek, int k) { // Wstawiamy na k-ta pozycje listy
		  Fiszka nowy=new Fiszka(nazwisko, wiek);
		  if( (k>=0) && (currentCount<MaxTab-2) ){
		  for(int i=currentCount; i>=k+2; i--)
		       tab[i+1]=tab[i];  // Robimy miejsce
		  tab[k+2]=nowy;           // Wstaw nowy obiekt do listy
		  currentCount++;        // Lista ma teraz jeden element wiecej
		 }
		}


	 int szukaj(String nazwisko) { // Odszukaj rekord na liście
		 for (int i=0; i < currentCount; i++)
			 if (tab[i+2].zwrocNazwisko()==nazwisko)
				 return i+2; // Indeks >=0 oznacza odnalezienie
		 return -1;        // Brak rekordu

	}
	 
	void usunOsobe(String nazwisko) {
	int k;

	k=szukaj(nazwisko);
	  if (k>=2){
	     for(int i=k; i < currentCount; i++)
	        tab[i]=tab[i+1];
	      currentCount--;
	     }
	}

	void UsunElement(int k) { //Usuwamy k-ty element listy
	if( (k>=2) && (k < currentCount) ){
	   for(int i=k; i<currentCount; i++)
	      tab[i]=tab[i+1];
	   currentCount--;
	 }
	}
	 
	void wypisz() {
	 for (int i=0; i < currentCount; i++)
		 System.out.printf("tab[%d]=(%s %d lat)\n", i, tab[i].zwrocNazwisko(),tab[i].zwrocWiek());
	 	 System.out.println();
	 }
	}
