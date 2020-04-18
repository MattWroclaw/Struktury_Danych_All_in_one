class BM{ 
 static int MAX = 256; // liczba znaków alfabetu
 
 static int max (int a, int b) {return (a > b)? a: b;} 
 
 static void init_shifts(String w, int shift[]) { 
 // zapiszmy ostatnie wystąpienie każdego możliwego znaku wzorca w tablicy o rozmiarze równym rozmiarowi alfabetu
 // Przy braku znaku w tablicy umożliwi nam to przesunięcie o całą długość wzorca
 int i; 
  for (i = 0; i < MAX; i++) // inicjalizacja 
    shift[i] = -1; 
  for (i = 0; i < w.length(); i++) 
       shift[ (int) w.charAt(i) ] = i;
  } 
  
 static void bm(String t, String w) {
  int N = t.length();
  int M = w.length();
     
  int shift[] = new int[MAX];
  init_shifts(w, shift); // inicjalizacja tablicy przesunięć dla wzorca 'w'
        
  int przes = 0; // aktualne przesunięcie wzorca w względem tekstu
  while(przes <= (N -M)) { // sytuacja, gdy wzorzec będzie znajdował się na samym końcu
    int j = M-1;
    // przesuwanie indeksu 'j' (pozycja dopasowania), gdy porównywane znaki są równe:
    while(j >= 0 && w.charAt(j) == t.charAt(przes+j))
       j--;
    // przesuwanie wzorca tak, aby kolejny znak zrównał się z ostatnim swoim wystąpieniem we wzorcu:
    if (j < 0) {
      System.out.println("Znalazłem dopasowanie na pozycji: " + przes);
      przes += (przes+M < N)? M-shift[t.charAt(przes+M)] : 1;
    } else // przesuwanie do ostatniej niezgodności z uwzględnieniem możliwego końca tekstu
          przes += max(1, j - shift[t.charAt(przes+j)]);
  }
}

 public static void main(String []args) {
  String t = "Z pamietnika mlodej lekarki podajacej w tym momencie pacjentowi nowe lekarstwo";
  String w = "lek";
  System.out.println(t);
  System.out.println("0123456789012345678901234567890123456789012345678901234567890123456789012345678");
  bm(t, w); 
 } 
}
