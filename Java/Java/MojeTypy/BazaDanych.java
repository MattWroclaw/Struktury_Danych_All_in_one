package MojeTypy; // zgrupowałem typy pomocnicze w katalogu MojeTypy (=nazwa pakietu)

class IndeksNazwisk{ 	    // ta klasa POMOCNICZA realizuje sortowanie wg nazwisk (prywatna dla BazaDanych zdefiniowanej poniżej, ten sam plik)	
    OSOBA ref;              // - referencja do elementu danych
    IndeksNazwisk nastepny; // - referencja do następnego elementu listy indeksowej
    
    public void wypiszKolejne(String s){ // wypisuje listę od wskazanego elementu
      IndeksNazwisk tmp=this;
      while(tmp!=null){
	    System.out.printf(" %12s zarabia \t%4d\n", tmp.ref.zwrocNazwisko(), tmp.ref.zwrocZarobek());
	    tmp=tmp.nastepny;
       }
      System.out.println();
    }  
 } // koniec definicji klasy IndeksNazwisk

//-----------------------------------------------------------------------------  
 class IndeksZarobkow{ 	     // ta klasa POMOCNICZA realizuje sortowanie wg zarobków (prywatna dla BazaDanych zdefiniowanej poniżej , ten sam plik)
    OSOBA ref;               // - referencja do elementu danych
    IndeksZarobkow nastepny; // - referencja do następnego elementu listy indeksowej  
    
  public void wypiszKolejne(String s){// wypisuje listę od wskazanego elementu
   IndeksZarobkow tmp=this;
   while(tmp!=null){
      System.out.printf(" %12s zarabia \t%4d\n", tmp.ref.zwrocNazwisko(), tmp.ref.zwrocZarobek());
      tmp=tmp.nastepny;
   }
   System.out.println();
  }
 } // koniec definicji klasy IndeksZarobkow
 //-----------------------------------------------------------------------------  

 
// *****************************************************************************
// Poczatek definicji klasy BazaDanych
 
 
 enum Status{                   // wyliczeniowy typ pomocniczy 
	   SZUKAJ, ZAKONCZ        	// pozwala przechowywać dwa stany
 }   
 
 public class BazaDanych {
	  Kartoteka dane=new Kartoteka();// własciwa lista danych (nieposortowana)
	  IndeksNazwisk  glowaN, ogonN;   // Lista indeksująca nazwiska
	  IndeksZarobkow glowaZ, ogonZ;   // Lista indeksująca zarobki

  
  public BazaDanych(){ // Konstruktor, zerujemy listy indeksujace
   glowaN=ogonN=null;
   glowaZ=ogonZ=null;
  }
     
   public void wstawSort(String nazw, int zar){    // Wstawia nowy element do listy danych oraz buduje indeksy
     OSOBA nowaref=dane.wstawNaKoniec(nazw, zar);    // Tworzymy nowy rekord danych
     wstawSortZarobk(nowaref);                       // Przebudowa indeksu 1 (zarobki)
     wstawSortNazw(nowaref);                         // Przebudowa indeksu 2 (nazwiska)
   }
  
 public IndeksZarobkow wstawSortZarobk(OSOBA nowaref){ // Wstaw nowy element do listy indeksowej
                                                       // i posortuj ją wg zarobków
  String nazw=nowaref.zwrocNazwisko();
  int zar=nowaref.zwrocZarobek();

  IndeksZarobkow nowy=new IndeksZarobkow ();          // Tworzymy nowy element na liscie indeksu
  nowy.ref=nowaref;
  
  // poszukiwanie właściwej pozycji na wstawienie elementu
  if (glowaZ==null){ // lista pusta
  glowaZ=nowy;
  ogonZ=nowy;
  nowy.nastepny=null;
  return nowy; // pozwala na szybkie opuszczenie metody
  }
  
// szukamy miejsca na wstawienie:
  IndeksZarobkow przed=null,po=glowaZ;// te zmienne zapamiętają miejsce wstawiania 
  Status stan=Status.SZUKAJ; 		  // zmienna wyliczeniowa
	
	while ( (stan==Status.SZUKAJ) && (po!=null) )
	  if (po.ref.zwrocZarobek() >= zar)
		 stan=Status.ZAKONCZ; 	// znaleźlismy właściwe miejsce!
	  else{  			        // szukamy dalej
	        przed=po;
	        po=po.nastepny;	
	       }
	// wstawiamy we właściwe miejsce:
	if (przed==null){	// wstawiamy na początek listy
		 glowaZ=nowy;
		 nowy.nastepny=po; 
	  } else
		  if (po==null){ 	// wstawiamy na koniec listy
			ogonZ.nastepny=nowy;
			nowy.nastepny=null;
			ogonZ=nowy;
			} 
		  	else{          // wstawiamy gdzieś w środku
			     przed.nastepny=nowy;
		    	 nowy.nastepny=po;
		        }
        return nowy;
 }

  public IndeksNazwisk wstawSortNazw(OSOBA nowaref){     // wstaw nowy element do listy indeksowej i posortuj ją wg nazwisk
	 					                                 
  String nazw=nowaref.zwrocNazwisko();
  int zar=nowaref.zwrocZarobek();

  IndeksNazwisk nowy=new IndeksNazwisk ();          // tworzymy nowy element na liście indeksu
  nowy.ref=nowaref;
  
  // poszukiwanie właściwej pozycji na na wstawienie elementu
  if (glowaN==null){ // lista pusta
    glowaN=nowy;
    ogonN=nowy;
    nowy.nastepny=null;
    return nowy; // pozwala na szybkie opuszczenie metody
  }
  
// szukamy miejsca na wstawienie:
  IndeksNazwisk przed=null, po=glowaN;// te zmienne zapamietają miejsce wstawiania
  Status stan=Status.SZUKAJ; 		  // zmienna wyliczeniowa
	
	while ( (stan==Status.SZUKAJ) && (po!=null) )       

		if ((po.ref.zwrocNazwisko().compareTo(nazw) >= 0))
	    	
			/* 
			 compareTo zwraca:
			 0, gdy argumenty sa równe leksykograficznie
			 <0, gdy argument jest wiekszy leksykograficznie od danego napisu
			 >0, gdy argument jest leksykograficznie mniejszy od danego napisu
			  
			 */
	    	
		 stan=Status.ZAKONCZ; 	// znaleźliśmy właściwe miejsce!
	  else{  		  	        // szukamy dalej
	        przed=po;
	        po=po.nastepny;	
	       }
	// wstawiamy we właściwe miejsce:
	if (przed==null){	// wstawiamy na początek listy
		 glowaN=nowy;
		 nowy.nastepny=po; 
	  } else
		  if (po==null){ 	// wstawiamy na koniec listy
			ogonN.nastepny=nowy;
			nowy.nastepny=null;
			ogonN=nowy;
			} 
		  	else{          // wstawiamy gdzieś w srodku
			     przed.nastepny=nowy;
		    	 nowy.nastepny=po;
		         }
    return nowy;
  }
  
  
  public void wypiszSortNazw(String s){       // wypisz listę wg indeksu nazwisk
     System.out.println(s);
     if (glowaN!=null) 
         this.glowaN.wypiszKolejne(s);
     else
         System.out.println("Indeks pusty");
  }
  
  public void wypiszSortZarobk(String s){       // wypisz listę wg indeksu zarobkow
     System.out.println(s);
     if (glowaZ!=null) 
         this.glowaZ.wypiszKolejne(s);
     else
         System.out.println("Indeks pusty");
  }
  
   public void wypisz(String s) {  // wypisz zawartość listy
   dane.wypisz(s);
   }
   
   public void usunWybrany(String  nazwisko){     // odszukaj i usuń element listy
	   dane.usunWybrany (nazwisko);
   }

 } // koniec klasy BazaDanych