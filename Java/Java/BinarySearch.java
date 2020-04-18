class BinarySearch {

static int szukaj(int tab[], int x, int left, int right) {
 if(left>right) 
     return -1; // element nieznaleziony
 else {
  int mid=(left+right)/2;
  if(tab[mid]==x) 
      return mid; // zwracamy pozycję pod jaką element został znaleziony
  else
    if(x<tab[mid])
      return szukaj(tab, x, left, mid-1); 
    else
      return szukaj(tab, x, mid+1, right);
 }
}

 public static void main(String[] args) { // wywołujemy algorytm
  int tabl[]={1, 2, 6, 18, 20, 23, 29, 32,34, 39, 40, 41};
  for(int i=0; i<tabl.length; i++)
	System.out.print("t["+ i + "]=" + tabl[i] + "  "); System.out.println();
  System.out.println("Szukam 23, wynik: " + szukaj(tabl, 23, 0, tabl.length-1));
  System.out.println("Szukam 3, wynik: " + szukaj(tabl,  3, 0, tabl.length-1));
 }
}






