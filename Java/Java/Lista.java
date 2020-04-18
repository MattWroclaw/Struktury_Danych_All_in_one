class Lista{ 			               // ta klasa realizuje listę jednokierunkową
		  private ELEMENT glowa;       // pola 'glowa' i 'ogon' 
		  private ELEMENT ogon;        // realizują strukturę informacyjną z rysunków w książce 

 public boolean czyPusta(){ // Metoda sprawdza, czy lista jest pusta
      return (glowa == null);
 }
  public ELEMENT pobierzGlowa(){
	  return glowa;
  }
  public ELEMENT pobierzOgon(){
	  return ogon;
  }
 
  public enum Status{ 	     // wyliczeniowy typ pomocniczy pozwala przechowywać dwa stany
	   SZUKAJ, ZAKONCZ}      // sterujace procesem wyszukiwania miejsca na wstawienie 


  public ELEMENT wstawNaKoniec(int  x){    // wstaw 'x' na koniec listy
	  ELEMENT nowy = new ELEMENT(x);
    if (this.czyPusta()){
         glowa=nowy;
         ogon =nowy;
     }
      else{   
             ogon.ustawNastepny(nowy);
             nowy.ustawNastepny(null);
             ogon=nowy;  
      }
    return nowy; // zwraca referencję do utworzonego elementu
  }
  
public ELEMENT wstawSort(int x){     // wstaw nowy element zachowując porządek 
	 			                     // niemalejący elementów listy 
  ELEMENT nowy=new ELEMENT(x);       // tworzymy nowy element listy
	// poszukiwanie właściwej pozycji na wstawienie elementu
	if (glowa==null){ // Lista pusta
  	   glowa=nowy;
	   ogon=nowy;
	   nowy.ustawNastepny(null);
	   return nowy;     // pozwala na szybkie opuszczenie metody
	 }			        // zwracając przy okazji referencję do elementu 'x'
	
	// poszukiwanie miejsca na wstawienie:
	ELEMENT przed=null,po=this.glowa;  // te zmienne zapamiętają miejsce wstawiania
	
	Status stan=Status.SZUKAJ; 		   // szukamy...
	
	while ( (stan==Status.SZUKAJ) && (po!=null) )
	  if (po. zwrocWartosc()>=x)
		 stan=Status.ZAKONCZ; 	// znaleźliśmy właściwe miejsce!
	  else{  			        // szukamy dalej
		   przed=po;
		   po=po.pobierzNastepny();	
	       }
	
	// wstawiamy we właściwe miejsce:
	if (przed==null){	// na poczatek listy
		 glowa=nowy;
		 nowy.ustawNastepny(po); 
	  } else
		  if (po==null){ 	// na koniec listy
			ogon.ustawNastepny(nowy);
			nowy.ustawNastepny (null);
			ogon=nowy;
			} 
		  	else{    		// gdzieś w środku
				 przed.ustawNastepny (nowy);
				 nowy.ustawNastepny (po);
		    }
	return nowy;
  } 
   
 
Lista sumuj(Lista x, Lista y) {
  Lista suma=new Lista();
  ELEMENT q1=x.glowa, q2=y.glowa;
  while (q1 != null){   // przekopiowanie listy x do temp
	  suma.wstawSort(q1.zwrocWartosc());
 	q1=q1.pobierzNastepny();
  }
  while (q2 != null){  // przekopiowanie listy y do temp
	  suma.wstawSort(q2.zwrocWartosc());
 	q2=q2.pobierzNastepny();
  }
 return suma;
 }


public Lista fuzja(Lista x, Lista y) { // x i y muszą byc posortowane
// zabezpieczenie przed java.lang.NullPointerException
if (x.glowa==null) 
	return y;
if (y.glowa==null) 
	return x;
// w tym miejcu wiemy, ze 'x' i 'y' nie są puste
ELEMENT xogon=x.ogon; // Zapamiętujemy "ogony" obu list
ELEMENT yogon=y.ogon; 

glowa=x.glowa.sortuj(x.glowa,y. glowa); // zmieniamy referencję 'glowa' nowej listy na listę posortowaną

// teraz musimy ustawic odpowiednio pole ogon nowej listy, co już wymaga analizy kilku przypadków elementarnych

if (xogon==null) {
	ogon=yogon;
	return this;
}

if (yogon==null) 
	return this;

if ( xogon.zwrocWartosc() <= yogon.zwrocWartosc())
	ogon=yogon;
else
	ogon=xogon;
return this;
}

public boolean szukaj(int  x){ // szukaj  'x' na liście
    ELEMENT tmp = glowa; // zmienna służąca do przeszukiwania listy
	boolean res=false;   // znaleziono = FALSE
    while (tmp != null){ 
	  if (tmp.zwrocWartosc() == x){
		 res=true;
		 break; // wychodzimy z pętli
	  } 
	  else tmp=tmp.pobierzNastepny(); // idź dalej
     }
	 return res; // zwróć wynik poszukiwań
  }
	    
  public void wypisz(String s) {  // wypisz zawartość listy
    if (glowa!=null)
	  glowa.wypiszKolejne(s);
    else
    	System.out.printf("Lista %s jest pusta\n", s);
   }
  
  public Lista UsunPierwszy() { // usuń pierwszy element z listy
	  if (!this.czyPusta())
	    glowa=glowa.pobierzNastepny();       
	    return this; // zwraca zmodyfikowaną (lub nie) listę
	 }
	   
	 public Lista UsunOstatni()  { // usuń ostatni element z listy
	  if (glowa==ogon)             // jeden element (lub lista pusta)
	  {
	    glowa=null;
	    ogon=null;
	  } else{
	       ELEMENT temp=glowa;
		while ((temp.pobierzNastepny()) != ogon) // szukamy przedostatniego elementu
			temp= temp.pobierzNastepny();      	 // idź dalej
		// nowy koniec listy:
		this.ogon=temp;          
		temp.ustawNastepny(null);// nowy koniec listy
		}
	  return this;  // zwracamy zmodyfikowany obiekt
	 }
		   
	 
	 public Lista usunWybrany(int  x){ 		// odszukaj  'x' na liście
	  ELEMENT tmp = glowa, poprzedni=null;; // zmienne służące przeszukiwania listy
	  boolean res=false;   				 	// znaleziono = FALSE
	  while (tmp != null){ 
	   if (tmp.zwrocWartosc() == x){
		 res=true;
		 break; // wychodzimy z pętli
		} 
		else{
		     poprzedni=tmp;  // zapamiętaj pozycję na liście
		     tmp=tmp.pobierzNastepny(); // idź dalej
		     }
	     } // koniec pętli wyszukiwania 
		
	  if (res==false)     // jeśli nic nie znaleziono, to wychodzimy, lista bez zmian
	   return this;
          // w tym miejscu w kodzie można założyć, że znaleziono ‘x’. Analiza przypadków:
          // przypadek 1: lista ma długość 1
		  if ( (poprzedni==null) && (tmp.pobierzNastepny()==null)){
		    glowa=null;
		    ogon=null;
		    return this;
		   }
		        
		// // przypadek 2: lista ma długość >1, usuwamy z przodu
		  if ( (poprzedni==null) && (tmp.pobierzNastepny()!=null)){
		      glowa=tmp.pobierzNastepny();
		     return this;
		  }     
	  // przypadek 3: lista ma długość >1, usuwamy z końca
		  if ( (poprzedni!=null) && (tmp.pobierzNastepny()==null)) {
		     poprzedni.ustawNastepny(null);
		     ogon=poprzedni;
		     return this;
		   }
		  
		// przypadek 4: lista ma długość >1, usuwamy gdzieś ze środka
	  poprzedni.ustawNastepny(tmp.pobierzNastepny());     
			 return this; // zwróc wynik poszukiwań 
	 }
   
 } // koniec definicji klasy Lista (klasa zarządzająca obiektami typu ELEMENT)

