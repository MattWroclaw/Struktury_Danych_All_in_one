class RekordDanych { // ta klasa realizuje rekord składowy listy:
   private char wartosc;       // - jakaś umowna wartość (u nas: znak)
   public RekordDanych nastepny;    // - referencja do następnego rekordu
   
   public RekordDanych(char  c)     // prosty konstruktor 
      { wartosc = c; }
   
   public char pobierzWartosc() // zwraca wartość rekordu
   { return wartosc; }
   
   public void wypisz()    // wypisz pojedynczy rekord
      { System.out.print(wartosc + " "); }
   }  // koniec definicji klasy RekordDanych (element składowy klasy 'Kolekcja')
// -------------------------------------------------------------
class Kolekcja { // właściwy obiekt - kolekcja (w naszym przykładzie lista jednokierunkowa) 
	
   private RekordDanych glowa; // wskazuje początkowy rekord listy (głowa)
      public Kolekcja() { glowa = null; }  // konstruktor
   
   public void ustawPrzod(RekordDanych elt)   // przy dokładaniu z przodu musimy przestawić wskazanie zapisane w 'glowa' 
   { glowa = elt; }

   public RekordDanych pobierzPierwszy()  // zwraca referencję do pierwszego rekordu listy (głowę)
      { return glowa; }
   
   public boolean czyPusta()       // lista pusta?
   { return glowa==null; }

   public void wypisz() {  // wypisz całą kolekcję
	  System.out.print("Lista: ");
      RekordDanych elt = glowa; 
      System.out.print("{");
      while(elt != null){
       elt.wypisz();
       elt = elt.nastepny;  // idziemy dalej
      }
      System.out.print("}\n");
      }
   }  // koniec definicji klasy Kolekcja (kolekcji obiektów 'RekordDanych')
//-------------------------------------------------------------
class ListaIterator {
   private RekordDanych kursor;     // "kursor" wskazujący na bieżący rekord na liście
   private RekordDanych poprzedni;  // kursor wskazujący na poprzedni rekord
   private Kolekcja dane;           // właściwa kolekcja danych

   public ListaIterator(Kolekcja dane) { // konstruktor, inicjalizacja kolekcji i skok na początek
      this.dane = dane;
      wrocNaPoczatek();
   }
  
   public void wrocNaPoczatek() { // przesuń kursor na początek kolekcji
      kursor = dane.pobierzPierwszy();
      poprzedni = null;
   }
//--------------------------------------------------------------
   public boolean czyOstatni() {  return (kursor.nastepny==null); } // czy to ostatni rekord?
//--------------------------------------------------------------
   public void wPrawo() { // idź do następnego elementu
	if(kursor.nastepny != null) { // nie jest to koniec listy
	 poprzedni = kursor;
     kursor = kursor.nastepny;
    } else
		wrocNaPoczatek(); // "zawijamy" na początek listy
   }
//--------------------------------------------------------------
   public RekordDanych pobierzBiezacy()       // zwróć bieżący kursor
    { return kursor; }
//--------------------------------------------------------------
   public void wstawPo(char  c){  // wstawia nowy rekord ZA kursorem
	 System.out.print("Dodajemy: [" + c + "] ");
     RekordDanych elt = new RekordDanych(c);
     if( dane.czyPusta() ){    //pusta?
      dane.ustawPrzod(elt);    // glowa = nowy rekord
      kursor = elt;
      poprzedni = null;
     } else {
             elt.nastepny = kursor.nastepny;
             kursor.nastepny = elt;
             wPrawo(); // przesuń kursor
         }
   }
//--------------------------------------------------------------
   public void wstawPrzed(char c) {   // wstawia nowy rekord PRZED kursorem
      RekordDanych elt = new RekordDanych(c);
      if(poprzedni == null){ // początek listy
          elt.nastepny = dane.pobierzPierwszy();
          dane.ustawPrzod(elt);
          wrocNaPoczatek();
      } else{
             elt.nastepny = poprzedni.nastepny;
             poprzedni.nastepny = elt;
             kursor = elt;
         }
      }

   public char usunBiezacy(){   // usuwa rekord wskazywany przez kursor
     char wartosc = kursor.pobierzWartosc();
      if(poprzedni == null){ // początek listy
        dane.ustawPrzod(kursor.nastepny);
        wrocNaPoczatek();
      }else {
             poprzedni.nastepny = kursor.nastepny;
             if(czyOstatni())
                  wrocNaPoczatek();
             else
                  kursor = kursor.nastepny;
         }
      return wartosc;
   }
  }  // koniec klasy ListaIterator
 //--------------------------------------------------------------
   
class ListaIteratorMain {
  public static void main(String[] args){
    Kolekcja lista = new Kolekcja();     // nowa kolekcja z danymi
    ListaIterator iter = new ListaIterator(lista);
    iter.wstawPo('a'); 
    System.out.println("wartość rekordu wskazywanego przez kursor: " + (iter.pobierzBiezacy()).pobierzWartosc());
    lista.wypisz();
    iter.wstawPo('b'); 
    System.out.println("wartość rekordu wskazywanego przez kursor: " + (iter.pobierzBiezacy()).pobierzWartosc());
    lista.wypisz();
    iter.wstawPrzed('c'); 
    System.out.println("wartość rekordu wskazywanego przez kursor: " + (iter.pobierzBiezacy()).pobierzWartosc());
    lista.wypisz();
    iter.wPrawo();
    System.out.println("Przesuń jedną pozycję w prawo, wartość rekordu wskazywanego przez kursor: " + (iter.pobierzBiezacy()).pobierzWartosc());
    iter.wPrawo();
    System.out.println("Przesuń jedną pozycję w prawo, wartość rekordu wskazywanego przez kursor: " + (iter.pobierzBiezacy()).pobierzWartosc());
    // zawijamy, kursor na a
    iter.wstawPrzed('d');
    lista.wypisz(); // dacb
    System.out.println("---");
    iter.wstawPrzed('B'); iter.wstawPo('C'); iter.wstawPo('D'); iter.wstawPo('E');
    // Powinna powstać sekwencja: B C D d E a c b (kursor wskazuje na E)
    lista.wypisz(); //
    System.out.println("Wartość rekordu wskazywanego przez kursor:"  + (iter.pobierzBiezacy()).pobierzWartosc());
    System.out.println("Usuwam : " + iter.usunBiezacy() );
    lista.wypisz();
 } 
}

