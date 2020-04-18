class Nwd {

static int nwd1 (int a, int b){
  if (b>a) 
    return nwd1 (a, b-a);
  if (b<a) 
    return nwd1 (a-b, b);
  else
    return b;
}

static int nwd2 (int a, int b){ // Wersja 2
  if (b==0) 
	  return a;
  else
	  return nwd2(b, a % b); // modulo
}
// wywołujemy algorytm i prezentujemy kilka wyników w obu wersjach funkcji
public static void main(String[] args) {
  System.out.println("          Metoda 1 Metoda 2");
  System.out.printf ("nwd(12,3)  = %3d  %3d\n", nwd1(12,3),  nwd2(12, 3) );
  System.out.printf ("nwd(24,30) = %3d  %3d\n", nwd1(24,30), nwd2(24,30) );
  System.out.printf ("nwd(5,7)   = %3d  %3d\n", nwd1(5,7),   nwd2(5,7)   );
  System.out.printf ("nwd(54,69) = %3d  %3d\n", nwd1(54,69), nwd2(54,69) );
  }
}