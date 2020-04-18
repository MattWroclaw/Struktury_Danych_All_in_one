 public class Lista2Main {
	 
  public static void main(String[] args) {
	Lista lista1=new Lista(), lista2=new Lista();
    int tab[]={6, -4, 41, -5, 42, 18, 21, -9, 66, 12, 42, -14};
    
    for (int i=0; i<tab.length; i++){
    	lista1.wstawSort(tab[i]);	
    	lista2.wstawSort(tab[i]);	
 	}
    System.out.println("\nSzukam elementów na liście");
    lista1.wypisz("L1");	
    
    System.out.printf("\nSzukam 6: %b",  lista1.szukaj(6));
    System.out.printf("\nSzukam 7: %b",  lista1.szukaj(7));
    System.out.println("\nUsuwam wybrane elementy -4 i 21 z L1");
    
    lista1=lista1.usunWybrany(-4); 
    lista1=lista1.usunWybrany(21);
    lista1.wypisz("L1");
    
    System.out.println("\nUsuwam pierwsze elementy z L1");

    while(!lista1.czyPusta()) {
    lista1.wypisz("L1");	
    lista1=lista1.UsunPierwszy();
    }
    lista1.wypisz("L1");	

    System.out.println("\nUsuwam ostatnie elementy z L2");
    do {
    	lista2.wypisz("L2");	
        lista2=lista2.UsunOstatni(); 
    } while (!lista2.czyPusta());
    lista2.wypisz("L2");
    
    
  }
 }// koniec definicji klasy Lista2 (użycie struktury danych Lista, cd.)
 
 
 /* Przykładowe wyniki:
Szukam elementów na liście
Kolejne elementy: L1= -14 -9 -5 -4 6 12 18 21 41 42 42 66

Szukam 6: true
Szukam 7: false
Usuwam wybrane elementy -4 i 21 z L1
Kolejne elementy: L1= -14 -9 -5 6 12 18 41 42 42 66

Usuwam pierwsze elementy z L1
Kolejne elementy: L1= -14 -9 -5 6 12 18 41 42 42 66
Kolejne elementy: L1= -9 -5 6 12 18 41 42 42 66
Kolejne elementy: L1= -5 6 12 18 41 42 42 66
Kolejne elementy: L1= 6 12 18 41 42 42 66
Kolejne elementy: L1= 12 18 41 42 42 66
Kolejne elementy: L1= 18 41 42 42 66
Kolejne elementy: L1= 41 42 42 66
Kolejne elementy: L1= 42 42 66
Kolejne elementy: L1= 42 66
Kolejne elementy: L1= 66
Lista L1 jest pusta

Usuwam ostatnie elementy z L2
Kolejne elementy: L2= -14 -9 -5 -4 6 12 18 21 41 42 42 66
Kolejne elementy: L2= -14 -9 -5 -4 6 12 18 21 41 42 42
Kolejne elementy: L2= -14 -9 -5 -4 6 12 18 21 41 42
Kolejne elementy: L2= -14 -9 -5 -4 6 12 18 21 41
Kolejne elementy: L2= -14 -9 -5 -4 6 12 18 21
Kolejne elementy: L2= -14 -9 -5 -4 6 12 18
Kolejne elementy: L2= -14 -9 -5 -4 6 12
Kolejne elementy: L2= -14 -9 -5 -4 6
Kolejne elementy: L2= -14 -9 -5 -4
Kolejne elementy: L2= -14 -9 -5
Kolejne elementy: L2= -14 -9
Kolejne elementy: L2= -14
Lista L2 jest pusta
  */