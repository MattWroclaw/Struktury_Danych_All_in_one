// Kompilacja i użycie:
// javac StertaMain.java
// java StertaMain

import MojeTypy.Sterta;

public class StertaMain {
  public static void main(String[] args) {    
   int i;
   int t1[]={12, 3, -12, 9, 34, 23, 1, 81, 45, 17, 9, 23, 11, 4};
  
   System.out.println("Tablica nieposortowana: 12 3 -12 9 34 23 1 81 45 17 9 23 11 4");
   
   Sterta s1 = new Sterta(14);
   
   for (i=0; i<14; i++) 
     s1.wstaw(t1[i]);
   
   for (i=14; i>0; i--)
	  t1[i-1]=s1.obsluz();
   System.out.print("Talica posortowana:   ");
   
   for (i=0;i<14;i++)
     System.out.print(" "+ t1[i]);
   System.out.println("\nPrzykład 2. Nowa tablica źródłowa: 37 41 26 14 19 99 23 17 12 20 25 42");
   
   int t2[]={37, 41, 26, 14, 19, 99, 23, 17, 12, 20, 25, 42};
   
   Sterta s2 = new Sterta(12);
   
   for(i=0; i<12; i++)
	   s2.wstaw(t2[i]);
	System.out.println("\nSterta utworzona z nowej tablicy: ");
	s2.pisz();
	s2.obsluz();s2.obsluz();
	System.out.println("Ta sama sterta po dwukrotnej obsłudze: ");
	s2.pisz();
  }
 }
