import java.util.*; // Z powodu klasy Scanner

class Inputs {
   public static void main(String[] args) {
   int x = Integer.parseInt("125");
   System.out.println(x+5);                // Wypisze 130
   int y=555;
   String s1 =  Integer.toString(y);       // Konwersja liczby 555 do napisu "555"
   System.out.println("Liczba y to " +s1); // Trochę sztuczny przykład, println potrafi robić takie konwersje samodzielnie! 
   
   double z=3.14;                          // Liczba pi
   String s2 =  Double.toString(z);        // Zamiana 3.14 na "3.14"
   s2= "Liczba pi=" + s2;
   System.out.println(s2);                 // Patrz uwaga wyzej dotyczaca funkcji println!
   
   double doubleGoldenRatio = 2*Double.parseDouble("1.618339887"); // Liczba fi (zloty podzial)
   System.out.println(doubleGoldenRatio);   

   System.out.println("Kot Ali ma " + 2 + " lata"); // Przykład konwersji automatycznej
   
   
   Scanner sc = new Scanner(System.in);  // Będziemy odczytywali dane ze strumienia wejściowego (np.  klawiatury)
   System.out.print("Podaj imie:");
   String imie=sc.nextLine(); 
   System.out.println("Masz na imię "+ imie);
   System.out.print("Podaj wiek:");
   int wiek= sc.nextInt();
   System.out.println("Masz " + wiek + " lat");
   
   
/*    Przyklad kontroli poprawnosci danych:
   System.out.print("Podaj wiek: ");
   while(!sc.hasNextInt()){
     System.out.print("To mi nie wyglada na liczbe, podaj poprawny wiek:");
     sc.next();
   }
   int wiek= sc.nextInt();
   System.out.println("Wprowadzono wiek:" + wiek);
*/
   
   }
}
