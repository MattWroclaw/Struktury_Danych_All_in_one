import java.util.Arrays;

public class ArraysMain{

public static void main(String [] args) {
 int[] t1 = {1, 2, 3};
 int[] t2 = {4, 5, 6, 7};

 int t12 [] = new int [t1.length+t2.length];     	// to będzie suma tablic t1 i t2
 System.arraycopy(t1, 0, t12, 0, t1.length);        // Kopiujemy t1 do t12
 System.arraycopy(t2, 0, t12, t1.length, t2.length);// "Doklejamy" t2 na koniec t12
 System.out.println(Arrays.toString(t12) );         // Wypisze: [1, 2, 3, 4, 5, 6, 7]
	
 int[] t3 = {5,-6, 3, 5, 12, 9};
 System.out.println(Arrays.toString(t3));      		// Wypisze: [5, -6, 3, 5, 12, 9]
 Arrays.sort(t3);									// Sortujemy ww.
 System.out.println(Arrays.toString(t3));			// Wypisze: [-6, 3, 5, 5, 9, 12]
 System.out.println(Arrays.binarySearch(t3, 5));  	// Szukamy liczny 5 (zwróci indeks=2)
 }
}

