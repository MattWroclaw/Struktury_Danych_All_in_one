class Szukaj{
	
public static int szukaj(int tab[], int x) { // szukaj 'x' w tablicy liczb całkowitych
 int pos=0;
 while ((pos < tab.length) && (tab[pos]!=x)) 
     pos++;
 if (pos < tab.length) 
     return pos; // element znaleziony
 else
     return -1;  // porażka poszukiwań
}

 public static void main(String[] args) {
  int tab[]={1,2,3,2,-7,44,5,1,0,-3};
  System.out.println("Szukam 7, indeks: " + szukaj(tab, 7)); // wynik = -1
  System.out.println("Szukam 5, indeks: " + szukaj(tab, 5)); // wynik =  6
 }
}



