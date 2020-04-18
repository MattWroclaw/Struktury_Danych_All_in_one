// kompilacja: javac Pierwsza.java
// uruchomienie: java Pierwsza

class Pierwsza { // czy liczba jest pierwsza?

static boolean czyPierwsza (int a) {
 if (a<=2) 
	 return false;
 for( int i=2; i<= Math.sqrt(a); i++) // funkcja sqrt zwraca pierwiastek kwadratowy 
	 if ( a % i == 0)                 // operator % realizuje funkcję modulo (reszta z dzielenia liczb całkowitych)
		  return false;
 return true; 
}

public static void main(String[] args) { // wypisuje liczby pierwsze od 2 do 100
  for(int i=2; i<100; i++)
	if (czyPierwsza(i) )
	   System.out.println("Liczba " + i + " jest pierwsza");
  }
}
