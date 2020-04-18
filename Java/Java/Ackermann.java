import java.util.*; // Z powodu klasy Scanner

class Ackermann {

static int A (int m, int n){
 int res=0;
 if (m==0)
    return n+1;
 if (m > 0 && n==0)
      return A(m-1, 1);
 if (m > 0 && n > 0)
     res=A(m-1, A(m, (n-1)));
 return res; 
}

 public static void main(String[] args) { // wywołujemy algorytm
  Scanner sc = new Scanner(System.in);  // Bedziemy odczytywali dane ze strumienia wejściowego (np.  klawiatury)
  System.out.print("Podaj m: ");
  int m= sc.nextInt();
  System.out.print("Podaj n: ");
  int n= sc.nextInt();
  System.out.println("A(m, n) = " + A(m, n) );
    
	/*    Przykład kontroli poprawności danych:
	   System.out.print("Podaj m: ");
	   while(!sc.hasNextInt()){
	     System.out.print("To mi nie wygląda na liczbę, popraw dane...");
	     sc.next();
	   }
	   int m= sc.nextInt();
	   System.out.println("Wprowadzono m:" + m);
	*/
 }
}






