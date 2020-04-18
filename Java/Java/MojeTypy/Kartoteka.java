package MojeTypy; // typy pomocnicze zgrupowałem w katalogu MojeTypy (=nazwa pakietu)
 
class Kartoteka{ // ta klasa realizuje właściwą listę jednokierunkową
  OSOBA glowa; 	 // początek listy danych
  OSOBA ogon; 	 // koniec listy danych
  
  public OSOBA wstawNaKoniec(String nazwisko, int  zarobek){ // wstaw nową osobę na koniec listy
    OSOBA nowy = new OSOBA(nazwisko, zarobek);
    if (glowa==null){
         glowa=nowy;
         ogon =nowy;
     }
      else{   
           ogon.ustawNastepny(nowy);
           nowy.ustawNastepny(null);
           ogon=nowy;  
      }
    return nowy;
  }
  
  public void wypisz(String s) {  // Wypisz zawartość listy
    if (glowa!=null)
	  glowa.wypiszKolejne(s);
    else
    	System.out.printf("Kartoteka %s jest pusta\n", s);
   }
   	    
   public Kartoteka usunWybrany(String  nazwisko){     // odszukaj  i usuń element listy
	  OSOBA tmp = glowa, poprzedni=null;               // zmienne służące do przeszukiwania listy
	  boolean res=false;   		                       // początkowy stan 'znaleziono' = FALSE
	  while (tmp != null){ 
	   if (tmp.zwrocNazwisko() == nazwisko){
		 res=true;
		 break; // wychodzimy z pętli
		} 
		else{
		     poprzedni=tmp; 
		     tmp=tmp.pobierzNastepny(); // idź dalej
		     }
	     } // koniec pętli wyszukiwania 
		   
       if (res==false){    // jeśli nic nie znaleziono, to wychodzimy, lista bez zmian
    	   System.out.println("Nie znaleziono rekordu: " + nazwisko);
	   return this;
       }
	  // znaleziono, lista ma długość 1
		  if ( (poprzedni==null) && (tmp.pobierzNastepny()==null)){
		    glowa=null;
		    ogon=null;
		    return this;
		   }
		        
	   // znaleziono, lista ma długość > 1, usuwamy z przodu
		  if ( (poprzedni==null) && (tmp.pobierzNastepny() !=null)){
		      glowa=tmp.pobierzNastepny();
		     return this;
		  }     
	    // znaleziono, lista ma długość >1, usuwamy z końca
		  if ( (poprzedni!=null) && (tmp.pobierzNastepny()==null)) {
		     poprzedni.ustawNastepny(null);
		     ogon=poprzedni;
		     return this;
		   }
		  
	      // znaleziono, lista ma długość >1, usuwamy gdzieś ze środka
	  poprzedni.ustawNastepny(tmp.pobierzNastepny());     
	 return this; // zwraca zmodyfikowaną listę
	 }
 } // koniec definicji klasy Kartoteka
