public class Reszta{ 

static void reszta(int r) {  // r-kwota
 int x, i;
 int N[]={100, 50, 20, 10, 5, 2, 1}; // N-tablica nominałów
	 System.out.println("Kwota: " + r);
	 i=0;
	 while (r>0){    	 // wydawaj aż do konca
	   if (r >= N[i]) {  // czy nominał pasuje?
	    x=r / N[i];      // oblicz krotność
	    r=r-x*N[i]; 	 // reszta do wydania...
	    System.out.println("Wydano " + x  + " razy " + N[i]);
	   }
	   i++;            	 // kolejny nominał
	 }
	}

 public static void main(String[] args) {
  reszta(91);
 }
}