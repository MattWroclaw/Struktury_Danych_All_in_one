class BinSearch {

static int binary_search (int tab[], int x, int left, int right){
 if (left==right)
  if (tab[left]==x) 
     return left;
       else        // element znaleziony
     return -1;    // element nieodnaleziony
  else{
       int mid=(left+right)/2;
	   if (tab[mid]==x) 
	      return mid;      // element znaleziony!
	   else
	      if (x<tab[mid])
	        return binary_search(tab, x, left, mid);
	      else
	        return binary_search(tab, x, mid+1, right);
		   }
 }

 public static void main(String[] args) { // wywołujemy algorytm
  int tabl[]={1, 2, 6, 18, 20, 23, 29, 32,34, 39, 40, 41};
  for(int i=0; i<tabl.length; i++)
	System.out.print("t["+ i + "]=" + tabl[i] + "  "); System.out.println();
  System.out.println("Szukam 23, wynik: " + binary_search(tabl, 23, 0, tabl.length-1));
  System.out.println("Szukam 3, wynik:  " + binary_search(tabl,  3, 0, tabl.length-1));
 }
}






