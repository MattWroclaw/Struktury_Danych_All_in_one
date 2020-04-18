
class Zmienne {

  public static final int licznik=1;   // Stała klasowa

   public static void main(String[] args) {
    final double mojePI=3.14;  // Stała
    int a = 2;
    int b = 5;
    int n = a + b++;                // n = 7 (priorytet ma dodawanie)

    char c1='X';
    char c2='\n';                    // Znak specjalny (nowa linia)
    System.out.println("c1="+c1);    // Wypisuje ‘c1=X’
    System.out.println("c2="+c2);    // “Wypisuje” znak nowej linii
  
    System.out.print("c1+c2="+c1+c2); // Użyłem print a nie println!
    // (Wypisuje ‘c1+c2=X’ i znak nowej linii)
   
    System.out.println(n);        // Wypisuje 7
    System.out.println(b);        // Wypisuje 6
    System.out.println(a + ++b);  // Wypisuje 9 (priorytet ma inkrementacja)
    System.out.println(b/a);      // Wypisuje 3 (dzielenie całkowite 7/2)
    System.out.println(b%a);      // Wypisuje 1 (reszta z dzielenia  7/2)
    System.out.println(mojePI);

  }
}
