// kompilacja: javac Eukl.java
// Uruchomienie: java Eukl

class Eukl {

static int nwd (int a, int b) { // Największy wspólny dzielnik
 if (b==0) 
   return a;
 else
   return nwd (b, a % b); // operator % realizuje funkcję modulo (reszta z dzielenia liczb całkowitych)
}

public static void main(String[] args) {
	System.out.println( nwd(12,3) );
  }
}
