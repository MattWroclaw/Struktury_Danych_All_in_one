class BinarySearchIter {
static int szukaj(int tab[], int x){ // zwraca indeks poszukiwanej wartości 'x' lub -1
 int left=0, right=tab.length-1, mid=0;
 boolean znaleziono=false;

 while( (left<=right) && (!znaleziono) ){
 mid=(left+right)/2;
 if(tab[mid] == x)
	 znaleziono=true;
 else
	if(tab[mid] < x)
		left=mid+1;
	else
		right=mid-1; 
 }

 if(znaleziono==true)
	return mid;
 else
	return -1;
}

 public static void main(String[] args) { // wywołujemy algorytm
  int tabl[]={1, 2, 6, 18, 20, 23, 29, 32,34, 39, 40, 41};
  // t[0]=1  t[1]=2  t[2]=6  t[3]=18  t[4]=20  t[5]=23  t[6]=29  t[7]=32  t[8]=34  t[9]=39  t[10]=40  t[11]=41
  for(int i=0; i<tabl.length; i++)
	System.out.print("t["+ i +"]=" + tabl[i] + "  "); System.out.println();
  System.out.println("Szukam 23, wynik: " + szukaj(tabl, 23) ); // wypisze: 5
  System.out.println("Szukam 3, wynik: " + szukaj(tabl,  3) ); // wypisze: -1
 }
}






