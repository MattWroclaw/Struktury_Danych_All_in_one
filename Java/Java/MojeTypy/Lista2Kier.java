package MojeTypy; // // Typy pomocnicze zgrupowałem w katalogu MojeTypy (=nazwa pakietu)

class RekordDanych { // Klasa realizuje obiekt danych na liście
   private String nazwisko;
   private int wiek;
   private RekordDanych nastepny;
   private RekordDanych poprzedni;
 
 public RekordDanych() { // Taki troche absurdalny konstruktor domyślny
   nazwisko="Doe"; wiek=0; 
   nastepny = poprzedni = null;
 }
 	
 public RekordDanych(String nazwisko, int wiek, RekordDanych nastepny, RekordDanych poprzedni) {
   this.nazwisko = nazwisko;
   this.wiek = wiek;
   this.nastepny = nastepny;
   this.poprzedni = poprzedni;
 }
 	
String pobierzNazwisko() {
 return nazwisko;
}
 
 int pobierzWiek() {
 return wiek;
 }
 	
 RekordDanych pobierzNastepny() {
 return nastepny;
 }
 	
 void ustawNastepny(RekordDanych nastepny) {
 this.nastepny = nastepny;
 }
 	
 RekordDanych pobierzPoprzedni() {
 return poprzedni;
 }
 	
 void ustawPoprzedni(RekordDanych poprzedni) {
 this.poprzedni = poprzedni;
 }
}
// koniec definicji klasy RekordDanych (przykładowy rekord danych na liście) 

// -------------------------------------------------------------------

public class Lista2Kier {  // Właściwa realizacja listy
  private RekordDanych glowa;
  private RekordDanych ogon;
 	
public void wstawSort(String nazwisko, int wiek) {
   RekordDanych nowy = new RekordDanych(nazwisko, wiek, null, null); // Tworzymy nowy obiekt
   
   if (glowa == null) {// Lista pusta
       glowa = nowy;    // Najprostszy przypadek!
       ogon = nowy;
    }else{ // Szukamy miejsca wstawienia
         RekordDanych tmp = glowa;
         while (tmp != null) {
 	       if ( (tmp.pobierzNazwisko()).compareTo(nazwisko) < 0) 
 	         tmp = tmp.pobierzNastepny();
 	       else{
 	         if (tmp == glowa){
               tmp.ustawPoprzedni(nowy);
 	           nowy.ustawNastepny(tmp);
 		       glowa = nowy;
 		       break;
 		     }
 	         else{
 		          nowy.ustawPoprzedni(tmp.pobierzPoprzedni());
                  nowy.ustawNastepny(tmp);
 		          (tmp.pobierzPoprzedni()).ustawNastepny(nowy);
 		          tmp.ustawPoprzedni(nowy);
 		          break;
 		          }
 	       }
 	    }
        if (tmp == null) {
 	        ogon.ustawNastepny(nowy);
 	        nowy.ustawPoprzedni(ogon);
 	        ogon = nowy;
           }	
         }
 }

public RekordDanych szukaj(String  nazw){ // Odszukaj  rekord na liście
    RekordDanych tmp = glowa;             // Zmienna służąca do przeszukiwania listy
    boolean res=false;                    // znaleziono = FALSE

    while (tmp != null){ 
	  if (tmp.pobierzNazwisko().compareTo(nazw)==0){
		  /*
		   compareTo zwraca:
			 0, gdy argumenty sa równe leksykograficznie
			 <0, gdy argument jest większy leksykograficznie od danego napisu
			 >0, gdy argument jest leksykograficznie mniejszy od danego napisu
		   */
              res=true;
              break; // Wychodzimy z pętli
           } else 
              tmp=tmp.pobierzNastepny(); // Idź dalej
     }
    if (res)
        return tmp; // Zwróc wynik poszukiwan 
    else
        return null;
}

public void usun(String nazw) { // Odszukaj  i usuń rekord pasujacy do kryterium wyszukiwania 
   RekordDanych tmp = glowa;
   while (tmp != null) {
   if (tmp.pobierzNazwisko().compareTo(nazw)==0) {
	   /*
	    compareTo zwraca:
			 0, gdy argumenty sa równe leksykograficznie
			 <0, gdy argument jest większy leksykograficznie od danego napisu
			 >0, gdy argument jest leksykograficznie mniejszy od danego napisu
	    */
    if (tmp == glowa) {
      glowa = (tmp.pobierzNastepny());
      break;
    }
    else if (tmp == ogon) {
       ogon = (tmp.pobierzPoprzedni());
       break;
    }
     else{
 	   (tmp.pobierzPoprzedni()).ustawNastepny(tmp.pobierzNastepny());
 	   (tmp.pobierzNastepny()).ustawPoprzedni(tmp.pobierzPoprzedni());
 	 break;
 	}
   }
   tmp = tmp.pobierzNastepny();
   }
   if (tmp == null)
      System.out.printf("Brak [%s] na liście\n", nazw);
}


 public void wypiszK() { // Wypisz listę od konca
   RekordDanych tmp = ogon;
   while (tmp != null) {
      System.out.print(" ["+tmp.pobierzNazwisko()+" " + tmp.pobierzWiek()+ "] <- ");
      tmp = tmp.pobierzPoprzedni();
   }
   System.out.println();
 }
 
 public void wypiszP() { // Wypisz listę od poczatku
   RekordDanych tmp = glowa;
   while (tmp != null) {
	 System.out.print(" ->["+tmp.pobierzNazwisko()+" " + tmp.pobierzWiek()+ "]");
	 tmp = tmp.pobierzNastepny();
   }
   System.out.println();
 }
 		
 public int rozmiar() {
  RekordDanych tmp = glowa;
  int rozm = 0;
  while (tmp != null) {
    rozm++;
   tmp = tmp.pobierzNastepny();
   }
  return rozm;
 }
 
}// koniec definicji klasy Lista2Kier