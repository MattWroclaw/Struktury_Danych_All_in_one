  class ELEMENT{ 			// Ta klasa realizuje element skladowy listy:
  private int wartosc;      // jakaś wartość
  private ELEMENT nastepny; // referencja do następnego elementu listy

  public ELEMENT(int x){ // konstruktor - tworzy nowy obiekt
    wartosc=x;
    nastepny=null;
  }
  public int zwrocWartosc(){  // metoda dostępowa jest wymagana, gdyż 
    return wartosc;			  // 'wartosc' jest polem "prywatnym"
  }
  public ELEMENT pobierzNastepny() { // pobierz następny element listy
    return nastepny;
  }
  public void ustawNastepny(ELEMENT kolejny){ // ustaw następny element listy
   nastepny = kolejny;
  }
  
  public void wypiszKolejne(String s){ // wypisuje listę od wskazanego elementu
	  ELEMENT tmp=this;
	  System.out.printf("Kolejne elementy: %s",s);
	    while(tmp!=null){
		    System.out.printf("%d",tmp.wartosc);
	    tmp=tmp.nastepny;
	   }
      System.out.println();
  }
  
   
  public ELEMENT sortuj(ELEMENT a, ELEMENT b){
  if (a==null) 
	  return b;
  if (b==null) 
   return a;
  
  if (a.wartosc <= b.wartosc){ // dostęp bezpośredni, w notacji "z kropką"
    						   // jest możliwy, gdyż znajdujemy się wewnątrz klasy
      a.nastepny=sortuj(a.nastepny,b);
      return a;
   }else {
   	 	  b.nastepny=sortuj(b.nastepny,a);
   	 	  return b;
   	}
  }
}// koniec definicji klasy ELEMENT
