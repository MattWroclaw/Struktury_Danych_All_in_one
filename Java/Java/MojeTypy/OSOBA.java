package MojeTypy; // Zgrupowałem typy pomocnicze w katalogu MojeTypy (=nazwa pakietu)

public class OSOBA{ 	    // Ta klasa realizuje element składowy listy danych (rekord informacyjny)
  private String    nazwisko; 
  private int       zarobek;
  private OSOBA     nastepny; // - referencja do następnego elementu listy

  public OSOBA(String nazwisko, int zarobek){ // Konstruktor - tworzy nowy obiekt
    this.nazwisko=nazwisko;
    this.zarobek=zarobek;
    nastepny=null;
  }
  
  public String zwrocNazwisko(){ // Metoda dostępowa jest wymagana, gdyż 'nazwisko' jest polem "prywatnym" 
    return nazwisko;	       
  }
  
  public int zwrocZarobek(){    // Metoda dostepowa jest wymagana, gdyż 'zarobek' jest polem "prywatnym" 
    return zarobek;	        
  }
  
  public OSOBA pobierzNastepny() {// Pobierz następny element listy
    return nastepny;
  }
  public void ustawNastepny(OSOBA kolejny){ // Ustaw następny element listy
   nastepny = kolejny;
  }
  
  public void wypiszKolejne(String s){ // Wypisuje listę od wskazanego elementu
   System.out.println(s);
   OSOBA tmp=this;
   while(tmp!=null){
	 System.out.printf(" %12s zarabia \t%4d\n", tmp.zwrocNazwisko(), tmp.zwrocZarobek());
    tmp=tmp.nastepny;
   }
   System.out.println();
  }
}// Koniec definicji klasy OSOBA