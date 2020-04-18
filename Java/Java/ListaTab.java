// realizacja listy w postaci tablicy

 class Fiszka{ 	  // ta klasa realizuje element składowy listy danych
   private String    nazwisko; 	// (rekord informacyjny)
   private int       wiek;
   
   String zwrocNazwisko() {
        return nazwisko;
   }
   int  zwrocWiek() {
        return wiek;
   }
   public Fiszka(String nazwisko, int wiek){ // konstruktor klasy
       this.wiek=wiek;
       this.nazwisko=nazwisko;
   }
 };
 
public class ListaTab {
  
 private final int MaxTab=200;  // stała określająca rozmiar tablicy
 private int currentCount;      // liczba rekordów w tablicy
 
 private Fiszka tab[]; 			// tablica rekordów typu 'Fiszka'

 public ListaTab() { 			// konstruktor klasy
    tab=new Fiszka[MaxTab];     // tworzymy pustą tablicę	
    currentCount=0;             // liczba wpisów w tablicy
 }	
 
 void WstawNaKoniec(String nazwisko, int wiek) { // wstawiamy na koniec listy
	  Fiszka nowy=new Fiszka(nazwisko, wiek);
	  if (currentCount<MaxTab){
	    tab[currentCount]=nowy; // wstaw nowy obiekt do listy
	    currentCount++;         // lista ma teraz jeden element więcej
	  }
	  else
	    System.out.println("Tablica pełna!");
	}
	void WstawNaPozycje(String nazwisko, int wiek, int k) { // wstawiamy na k-ta pozycje listy
	  Fiszka nowy=new Fiszka(nazwisko, wiek);
	  if( (k>=0) && (currentCount<MaxTab) ){
	  for(int i=currentCount; i>=k; i--)
	       tab[i+1]=tab[i];  // robimy miejsce
	  tab[k]=nowy;           // wstaw nowy obiekt do listy
	  currentCount++;        // lista ma teraz jeden element więcej
	 }
	}


 int szukaj(String nazwisko) { // odszukaj rekord na liście
	 for (int i=0; i < currentCount; i++)
		 if (tab[i].zwrocNazwisko()==nazwisko)
			 return i; // Indeks >=0 oznacza odnalezienie
	 return -1;        // brak rekordu

}
 
void usunOsobe(String nazwisko) {
int k;

k=szukaj(nazwisko);
  if (k>0){
     for(int i=k; i < currentCount; i++)
        tab[i]=tab[i+1];
      currentCount--;
     }
}

void UsunElement(int k) { // usuwamy k-ty element listy
if( (k>=0) && (k < currentCount) ){
   for(int i=k; i<currentCount; i++)
      tab[i]=tab[i+1];
   currentCount--;
 }
}
 
void wypisz() {
 for (int i=0; i < currentCount; i++)
	 System.out.printf("tab[%d]=(%s %d lat(a))\n", i, tab[i].zwrocNazwisko(),tab[i].zwrocWiek());
 	 System.out.println();
 }
}
