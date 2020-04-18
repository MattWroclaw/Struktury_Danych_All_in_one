package MojeTypy; // Typy pomocnicze zgrupowałem w katalogu MojeTypy (jest to jednocześnie nazwa pakietu)

public class TabInt { // klasa zarządzająca tablicą liczb całkowitych używana w rozdziale "Algorytmy sortowania"
    
  private int[] t;
  
  private static int rozmiar; // rozmiar tablicy danych
  private int licznik;

  public TabInt(int max){  // konstruktor
    t = new int[max];
    licznik = 0;
    rozmiar = max; 
  }

  public void wstaw(int x){ // dodaj nowy element do tablicy
	if (licznik < rozmiar) {
      t[licznik] = x;
      licznik++;
     } else
          System.out.println("[BłąD] Brak miejsca w tablicy dla " + x);
  }

  public void wypisz(){        // wypisz zawartość tablicy
	System.out.print("[");
	for(int i=0; i<licznik; i++)
     System.out.print(t[i] + " ");
   System.out.print("]\n");
  }
  // -------------------------------------------------------------------------
  public void insertSort() { // algorytm sortowania przez wstawianie
	for(int i=1; i<rozmiar; i++){
	  int j=i;                // fragment [0..., i–1] jest już posortowany
	  int temp=t[j];
	  while ((j>0) && (t[j-1]>temp)){
	     t[j]=t[j-1];
	     j--;
	  }
	t[j]=temp; 
    }
  }
  // -------------------------------------------------------------------------
  public void bubble() { // algorytm sortowania bąbelkowego
    for (int i=1; i<rozmiar; i++)
	  for (int j=rozmiar-1; j>=i; j--)
	    if (t[j] < t[j-1]){ // zamiana
	      int tmp=t[j-1];
	      t[j-1]=t[j];
	      t[j]=tmp;
	    }
  } 
  // -------------------------------------------------------------------------
  public void ShakerSort(){ // algorytm sortowania przez wytrząsanie
    int left=1, right=rozmiar-1, k=rozmiar-1;
    int temp;
	  do{
	   for(int j=right; j>=left; j--)
	    if(t[j-1]>t[j]){
	      temp=t[j-1]; t[j-1]=t[j]; t[j]=temp; // zamiana t[j-1] i t[j] 
	      k=j;
	    }
	   left=k+1;
	   for(int j=left; j<=right; j++)
	    if(t[j-1]>t[j]){
	    temp=t[j-1]; t[j-1]=t[j]; t[j]=temp; // zamiana t[j-1] i t[j]
	      k=j;
	    }
	   right=k-1;
	  }
	  while (left<=right);
  }

 // -------------------------------------------------------------------------
  public void qsort(int left, int right){ // algorytm sortowania QuickSort
	int temp;
	if (left < right){
	int m=left;
	for (int i=left+1; i<=right; i++)
	  if (t[i]<t[left])
	      {++m; temp=t[m]; t[m]=t[i]; t[i]=temp;} // zamiana komórek tablicy t[++m] oraz t[i]
	  temp=t[left]; t[left]=t[m]; t[m]=temp;      // zamiana komórek tablicy t[left] oraz t[m]
	qsort(left, m-1);
	qsort(m+1, right);
	}
  }
  
  // -------------SEKCJA HEAP- SORT -------------------------
  void przywroc(int k, int n){ // przywracanie porządku w stercie określanej przez węzeł k i rozmiar n
	int i,j; 
	i = t[k-1];
	while (k <= n/2){
	 j=2*k;
	 if( (j<n) && ( t[j-1]<t[j] )  ) 
		 j++;
	 if (i >= t[j-1]) 
	break;
	 else{
	      t[k-1] = t[j-1];
	      k=j;
	      }
	 }
    t[k-1]=i;
  }

  public void heapsort(){ // własciwy algorytm sortowania heap-sort
    int k, temp, n=rozmiar;
    for(k=n/2; k>0; k--) 
   	   przywroc(k, n); 
    do{
      temp=t[0];   //  bieżący korzeń idzie na koniec
      t[0]=t[n-1];
      t[n-1]=temp;
      n--;
      przywroc(1, n); // przywracanie porządku na podstercie
    } while (n > 1);

  }
  // -------------------------------------------------------------------------
   
} // koniec klasy TabInt
