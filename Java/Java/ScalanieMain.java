class ScalanieMain {
 static void wypisz(int tab[]){
   for(int i=0; i < tab.length; i++)
	     System.out.print(tab[i] + " ");
   System.out.println();
 }

 static void scalaj(int T1[], int T2[], int T3[]){  // T1, T2 - tablice wejściowe, T3 - tablica wynikowa
    for (int i=0, j=0, k=0; k < T1.length+T2.length; k++){
      if (i==T1.length){ // osiągnięto koniec zbioru T1, kopiujemy resztę
		T3[k]=T2[j++]; continue;
	  }
      if (j==T2.length){ // osiągnięto koniec zbioru T2, kopiujemy resztę
 	    T3[k]=T1[i++]; continue;
      }
	  if (T1[i]<T2[j])
			T3[k]=T1[i++];
	  else
			T3[k]=T2[j++];
	 }
 }

 public static void main(String[] args){
   int T1[] = {-4, -2, 0, 4, 6, 8, 9, 11};
   int T2[] = {2, 3, 4, 5, 5, 6, 7, 12, 13, 14, 16, 19};
   int T3[] = new int[ T1.length + T2.length];
   System.out.println("Przed scaleniem:");
	wypisz(T1);
	wypisz(T2);
     System.out.println("Po scaleniu:");
    scalaj(T1, T2, T3);
	wypisz(T3); // wypisze: -4 -2 0 2 3 4 4 5 5 6 6 7 8 9 11 12 13 14 16 19
 }
}
