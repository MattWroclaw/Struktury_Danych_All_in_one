class SzukajLiniowo {
	
public static int szukaj(int tab[], int x) { // szukaj 'x' w tablicy liczb całkowitych
 int i;
 for(i=0; (i< tab.length) && (tab[i]!=x) ;i++);
 return i; // jeśli 'i' osiągnie wartość 'tab.length' (wyjdzie poza zakres tablicy), to nie znaleziono elementu
}

public static int szukaj(char tab[], char s) { // szukaj 's' w tablicy znaków
	 int i;
	 for(i=0; (i< tab.length) && (tab[i]!=s) ;i++);
	 return i;// jeśli 'i' osiągnie wartość 'tab.length' (wyjdzie poza zakres tablicy), to nie znaleziono elementu
	}


 public static void main(String[] args) {
  int  tab1[]= {1, 2, 3, 2, -7, 44, 5, 1, 0, -3};
  char tab2[]= { 'A', 'L', 'A', 'M', 'A', 'K', 'O', 'T', 'A'};
 
  System.out.println("[1 2 3 2 -7 44 5 1 0 -3]. Wielkość tablicy: " + tab1.length);
  System.out.println("Szukam 3, indeks: " + szukaj(tab1, 3));
  System.out.println("Szukam 4, indeks: " + szukaj(tab1, 4));
  
  System.out.println("[A L A M A K O T A]. Wielkość tablicy: " + tab2.length);
  
  System.out.println("Szukam 'K', indeks: " + szukaj(tab2, 'K'));
  System.out.println("Szukam 'X', indeks: " + szukaj(tab2, 'X'));
  
 }
}



