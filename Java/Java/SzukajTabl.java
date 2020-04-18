class SzukajTabl {// implementacja algorytmu musi być zawarta w ciele pewnej klasy
	
static void szukaj(int tab[],int left,int right,int x){
 // left, right  = lewa i prawa granica obszaru poszukiwań
 // tabl         = tablica
 // x            = wartość do znalezienia
 if (left>right)
	System.out.println("Element " + x +" nie został znaleziony");
 else
	if (tab[left] == x)
	    System.out.println("Znalazłem szukany element " + x);
	else
	    szukaj(tab, left+1, right, x);
}

 public static void main(String[] args) {// wywołujemy algorytm

  int tabl[]={1, 2, 3, 2, -7, 44, 5, 1, 0, -3};
 
  for (int i=0; i<tabl.length; i++)
     System.out.print("t["+i+"] = "+tabl[i]+" ");
 
  System.out.println();
 
  szukaj(tabl, 0, tabl.length-1, 7);
  szukaj(tabl, 0, tabl.length-1, 5);
 }
}
