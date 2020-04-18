public class Eratostenes{ 

static boolean pierwsza(int n){      // czy n to liczba pierwsza?
  long i, limes=Math.round( Math.sqrt(n) );
  for(i=2; n!=(n/i)*i && i<=limes;i++);
   if (i>limes) 
      return true;  // tak, to liczba pierwsza
   else 
      return false; // nie, to „zwyczajna” liczba
  }
 
static void sito(int n){    
 int cpt = 1;
 int i, tp[]=new int[n+1];
 for(i=1; i<=n; i++)
   tp[i]=i;                 // zaznaczenie wszystkich liczb naturalnych od 1 do n
  while(cpt<n){ // szukamy pierwszego niezerowego elementu tablicy tp:
    for(cpt++; (tp[cpt]==0) && (cpt!=100); cpt++);
	   int k=2;  
    while(cpt*k<=n){ // zerujemy wielokrotności tego elementu (cpt) w tp
    tp[cpt*k]=0;
    k++;
    }
  }
 for(i=1;i<=n;i++) // wypisuje wszystkie liczby pierwsze < n
   if (tp[i]!=0) 
	 System.out.print(tp[i] + "  ");
 }

public static void main(String[] args) { 
 System.out.println("Metoda klasyczna");
  for(int i=1; i<100; i++)
	 if (pierwsza(i)==true)
		 System.out.print(i + "  ");
  System.out.println("\nMetoda SITA Eratostenesa");
  sito(100);
  System.out.println();
 }
}

