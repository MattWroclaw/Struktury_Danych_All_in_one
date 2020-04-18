import java.util.Arrays; 

class BinarySearchJavaUtil {

 public static void main(String[] args) { // wywołujemy algorytm
   int tab[]={1, 2, 6, 18, 20, 23, 29, 32, 34, 39, 40, 41};
   Arrays.sort(tab); // Ta instrukcja posortuje tablicę tab, gdyby nie była wcześniej uporządkowana
   int x=23;
	int res = Arrays.binarySearch(tab, x); 
	if (res >= 0) 
	   System.out.println("Znaleziono " + x + " na pozycji " + res); 
	else
	   System.out.println("Nie znaleziono " + x); 
  } 
}




