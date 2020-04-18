 public class Lista3Main {
	   public static void main(String[] args) {    
	Lista lista1=new Lista(), lista2=new Lista(), lista3=new Lista();
	int tab1[]={-4, 12, 6, 13, -5};
	int tab2[]={3,-5};

	for (int i=0; i<tab1.length; i++) 
		lista1.wstawSort(tab1[i]);
	for (int i=0; i<tab2.length; i++) 
		lista2.wstawSort(tab2[i]);
	
    System.out.println("\nSuma L1+L2 (procedura nieoptymalna)");
	lista1.wypisz("L1=");
	lista2.wypisz("L2=");
	lista3=lista1.sumuj(lista1, lista2);
	lista3.wypisz("L3=L1+L2=");	
	System.out.println("\nSuma L1+L2 (procedura optymalna)");
	lista1.wypisz("L1=");
	lista2.wypisz("L2=");
	lista1=lista1.fuzja(lista1, lista2);
	System.out.println("Sytuacja po wykonaniu fuzji L1=L1+L2");
	lista1.wypisz("L1=");
  }
 }
 
 /* Przykładowe wyniki:

Suma L1+L2 (procedura nieoptymalna)
Kolejne elementy: L1= -5 -4 6 12 13
Kolejne elementy: L2= -5 3
Kolejne elementy: L3=L1+L2=-5 -5 -4 3 6 12 13

Suma L1+L2 (procedura optymalna)
Kolejne elementy: L1=-5 -4 6 12 13
Kolejne elementy: L2=-5 3
Sytuacja po wykonaniu fuzji L1=L1+L2
Kolejne elementy: L1=-5 -5 -4 3 6 12 13

*/