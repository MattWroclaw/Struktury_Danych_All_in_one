class WieloLista{
 int c;
 int j;
 WieloLista nastepny;
 
 WieloLista(int c0, int j0){ // konstruktor - tworzy nowy obiekt
  c=c0;
  j=j0;
  nastepny=null;
 }
 
 WieloLista wstaw(int c, int j){   // dodaje nowy węzeł (współczynnik) do wielomianu
 // użytkownik powinien wstępnie zadbać o "posortowanie" (dokładanie elementów wyrażenia)
 if(c!=0){	// interesują nas tylko elementy c*(x^j) dla c!=0 - nie ma sensu zapamiętywać pustych elementów
   WieloLista q=new WieloLista(c, j);
   q.nastepny=this;
   return q;
   } else
	  return this;// lista nie została zmieniona
 }
 
 
 void pisz(){
  WieloLista tmp=this;
  while(tmp!=null){
	  System.out.print("[" + tmp.c +  " * x^" + tmp.j + "]  ");
	    tmp=tmp.nastepny;
  }
     System.out.println();
 }
 
}

class WieloListaMain{
 public static void main(String[] args) {
  WieloLista p=new WieloLista(5, 1700);                  // Pierwszy składnik wielomianu  p(x) - np. zerowy (x0) 
  p=p.wstaw(6, 700); p=p.wstaw(10, 50); p=p.wstaw(6, 0); // kolejne składniki wielomianu  p(x) - np. x^1, x^2, ...
  p.pisz(); // [6 * x^0]  [10 * x^50]  [6 * x^700]  [5 * x^1700]
 }
}	
