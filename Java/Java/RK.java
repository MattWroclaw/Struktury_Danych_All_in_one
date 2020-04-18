class RK{ 
 static int MAX = 256;    // liczba znaków alfabetu
 static int p = 33554393; // duża liczba pierwsza

 static void rk(String w, String t) { 
  int M = w.length(); 
  int N = t.length(); 
  int i, j; 
  int Hw = 0;   // funkcja H dla wzorca
  int Ht = 0;   // funkcja H dla tekstu
  int bM_1 = 1; // wyliczymy wartość pow(MAX, M-1)%p
  for (i = 0; i < M-1; i++) 
	  bM_1 = (MAX*bM_1) % p; 

  for (i = 0; i < M; i++) { 
     Hw = (Hw*MAX + w.charAt(i) ) %p; // inicjacja funkcji H dla wzorca
     Ht = (Ht*MAX + t.charAt(i) ) %p; // inicjacja funkcji H dla tekstu
   } 

  for (i = 0; i <= N - M; i++)  {    // właściwa pętla przeszukiwania 
    if ( Hw == Ht ) {  // tutaj już musimy sprawdzić znak po znaku i potwierdzić, czy wyszukanie się powiodło 
      for (j = 0; j < M; j++) { // (*)
       if (t.charAt(i+j) != w.charAt(j)) 
        break; 
       } 
    if (j == M) 
       System.out.println("Znalazłem wzorzec na pozycji: " + i);
  } 
  if ( i < N-M ) { // Kontynuujemy pod warunkiem, że pozostały fragment tekstu jest dłuższy niż wzorzec
    Ht = (MAX*(Ht - t.charAt(i)*bM_1) + t.charAt(i+M) )%p; 
    if (Ht < 0)  // korekta znaku (**)
      Ht = (Ht + p); 
   } 
 } 
} 
      
  public static void main(String[] args) { 
    String t = "Z pamietnika mlodej lekarki podajacej w tym momencie pacjentowi nowe lekarstwo"; 
    String w = "lek"; 
    System.out.println(t); 
    System.out.println("Szukam: " + w);
    rk(w, t); 
 } 
}
