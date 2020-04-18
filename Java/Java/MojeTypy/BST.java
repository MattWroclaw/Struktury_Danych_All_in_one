package MojeTypy; // Typy pomocnicze zgrupowałem w katalogu MojeTypy (=nazwa pakietu)

public class BST { // Binarne drzewo poszukiwań
 public Wezel korzen; // korzeń główny drzewa BST

 public BST() { korzen = null; } // konstruktor
   
 public void wstaw(int k) {
  Wezel w = new Wezel(k); // tworzymy nowy węzeł i szukamy miejsca ma wstawienie 
  if(korzen == null)      // na razie pusto tutaj...
      korzen = w;
  else{                   // coś tam jest, zatem szukamy aż do końca świata i jeden dzień dłużej!
	   Wezel tmp = korzen;
	   Wezel rodzic;
	   while(true) { // z pętli wyjdziemy po wstawieniu elementu (*)
          rodzic = tmp;
          if(k < tmp.klucz) { // na lewo
        	tmp = tmp.lewy;
            if(tmp == null){ // jeśli koniec ścieżki, to wstaw na lewo
              rodzic.lewy = w;
              break;
            }
          } else // kierujemy się na prawo
                {
        	     tmp = tmp.prawy;
	             if(tmp == null) {  // jeśli koniec ścieżki, to wstaw na prawo
	               rodzic.prawy = w;
	               break;
	             }
	            }
	   } // koniec pętli (*)
	  }
 }

 public Wezel szukaj(int x) { // szukamy węzła wg wartości klucza
  if (korzen == null) 
	  return null;	 
  Wezel tmp = korzen;
  while(tmp.klucz != x){
    if(x < tmp.klucz) // kieruj się na lewo
    	tmp = tmp.lewy;
    else                  // kieruj się na prawo
    	tmp = tmp.prawy;
      if(tmp == null) // brak potomka
            return null;
      }
      return tmp;     // znaleziono
 }

 
 public void Min() { // odszukaj i wypisz węzeł o najmniejszej wartości klucza
  Wezel tmp  = korzen;
  while (tmp.lewy != null) // idź w lewo, aż do końca
	    tmp = tmp.lewy;
	tmp.pisz(); // wypisz znaleziony element
	System.out.println();
 }
 
 
 public void Max() { // odszukaj i wypisz węzeł o największej wartości klucza
   Wezel tmp  = korzen;
   while (tmp.prawy != null) // idź w prawo, aż do końca
	        tmp = tmp.prawy;
   tmp.pisz();// wypisz znaleziony element
   System.out.println();
 }
 
 private Wezel nastepnik(Wezel x) { // zwraca węzeł następujący po węźle do wykasowania
   Wezel ojciec = x, nastepnik = x; // start
   Wezel tmp = x.prawy;   // idziemy w kierunku na prawo
   while(tmp != null) {   // aż do końca (brak potomków)
	ojciec = nastepnik;
    nastepnik = tmp;
    tmp = tmp.lewy;       // lewy potomek
   }
   if(nastepnik != x.prawy) { // brak prawego potomka
    ojciec.lewy = nastepnik.prawy;
    nastepnik.prawy = x.prawy;
   }
   return nastepnik;
 }
 
 public boolean usun(int x){
  if (korzen == null) 
    return false;	 
  Wezel tmp = korzen;
  Wezel rodzic = korzen;
  boolean czyLewy = true;
  while(tmp.klucz != x){ // pętla wyszukiwania - poza odszukaniem elementu musimy jeszcze 
    rodzic = tmp;        //  ustalić czy odnaleziony węzeł był lewy, czy prawy (nie można użyć metody szukaj)
    if(x < tmp.klucz) {  // idziemy na lewo
       czyLewy = true;
       tmp = tmp.lewy;
    }else               // idziemy na prawo
        {
        czyLewy = false;
        tmp = tmp.prawy;
        }
     if(tmp == null)
            return false; // porażka poszukiwań
     }
  
  if(tmp.lewy==null && tmp.prawy==null) { // sytuacja, gdy mamy do czynienia z liściem
     if(tmp == korzen)                    // lub korzeniem
        korzen = null;  // puste drzewo
     else 
       if(czyLewy)
         rodzic.lewy = null; // odpinamy
       else                     
         rodzic.prawy = null;
         }
      else if(tmp.lewy==null) // brak lewego pod-drzewa
        if(tmp == korzen)
          korzen = tmp.prawy;
        else if(czyLewy)
          rodzic.lewy = tmp.prawy;
        else
          rodzic.prawy = tmp.prawy;
      else if(tmp.prawy==null) //brak prawego pod-drzewa
    	if(tmp == korzen)
          korzen = tmp.lewy;
        else if(czyLewy)
         rodzic.lewy = tmp.lewy;
        else
         rodzic.prawy = tmp.lewy;
      else{ // węzeł ma 2 potomków, musimy odszukać następnik węzła do skasowania
         Wezel nastepnik = nastepnik(tmp);
         if(tmp == korzen)
            korzen = nastepnik;
         else if(czyLewy)
            rodzic.lewy = nastepnik;
         else
            rodzic.prawy = nastepnik;
         nastepnik.lewy = tmp.lewy;
         }
      return true;// udało się usunąć 
      }
   
   
  public void preOrder(Wezel w){ // przejście "wzdłużne"
    if(w != null){
      w.pisz();
      preOrder(w.lewy);
      preOrder(w.prawy);
    }
  }

  public void inOrder(Wezel w){ // przejście "poprzeczne"
    if(w != null){
      inOrder(w.lewy);
      w.pisz();
      inOrder(w.prawy);
    }
  }

  public void postOrder(Wezel w){ //przejście "wsteczne"
    if(w != null) {
      postOrder(w.lewy);
      postOrder(w.prawy);
      w.pisz();
      }
  }
}// Koniec klasy BST

