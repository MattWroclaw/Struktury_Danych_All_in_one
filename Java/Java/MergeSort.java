class MergeSort {

static void wypisz(int tab[]){
   for(int i=0; i < tab.length; i++)
	     System.out.print(tab[i] + " ");
   System.out.println();
 }
// --------------------------------------------------------------------------------
 static void scalaj(int T1[], int left, int mid, int right) { // left - poczatek, right - koniec, mid - środek
  // procedura łączy 2 posortowane tablice T1[left...mid] i T1[mid+1...right]
  int left1 =  left,     right1  =  mid; // podtablica 1
  int left2 =  mid+1, right2  =  right;  // podtablica 2
  int T2[] = new int[ T1.length]; // T2 - tablica pomocnicza
 int i = left1;   
//aż do wyczerpania obu podtablic dokonaj scalenia przy pomocy tablicy pomocniczej:
 while((left1 <= right1) && (left2 <= right2)) {
  if(T1[left1] < T1[left2]) {
    T2[i] = T1[left1];
    left1++;
	}
	else{
		T2[i] = T1[left2];
		left2++;
		}
	i++;
  }
 while(left1 <= right1){
  T2[i] = T1[left1];
  left1++;
  i++;
 } 
 while(left2 <= right2) {
  T2[i] = T1[left2];
  left2++;
  i++;
 }
 for(i = left; i <= right; i++) // skopiuj z tablicy tymczasowej do oryginalnej
    T1[i] = T2[i];
 }
//-------------------------------------------------------------------------------- 
static void MergeSort(int T[], int left, int right) {
  if(left < right) {
	 int mid = (left + right) / 2;  // środek
	 MergeSort(T, left, mid);   		// sortowanie podtablic lewej i prawej
	 MergeSort(T, mid+1, right); 		// sortuj prawą połowę
	 scalaj(T, left, mid, right);   	// scalaj
  }
}
//--------------------------------------------------------------------------------
 public static void main(String[] args){
   int T[] = {4, -6, 6, 4, 12, -3, 72, 6, -6, 1, 5, 8, 2, -7};
   System.out.println("Przed sortowanie:");
	wypisz(T);
	System.out.println("Po sortowaniu");
    MergeSort(T, 0, T.length-1);
	wypisz(T); // wypisze: -7 -6 -6 -3 1 2 4 4 5 6 6 8 12 72
 }
}
