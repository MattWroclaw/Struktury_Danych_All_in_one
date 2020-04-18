class Tablice {
  public static void main(String[] args) {
  int t1[] = {7, 2, 7, 4, 9, 11}; // nowa tablica o rozmiarze 6 + inicjacja
  int t2[] = new int[5];          // tworzy pustą tablicę o rozmiarze 5
  int t3[];                       // ta tablica nie jest jeszcze utworzona w pamięci
 
  System.out.println("Wielkość tablicy t1: " + t1.length + 
                                          ", wielkość tablicy t2: "+t2.length);

  // System.out.println ("Wielkość tablicy t3: "+t3.length); // kompilator tego nie przyjmie!
  
  System.out.println("Wartość t2[2]: " + t2[2]); // wypisze zero
  
  System.out.println("t1[3]=" + t1[3]); // wypisze 4 (numeracja od zera)
  
  for (int x: t1)
     System.out.println("Kolejny element t1: " + x); // pętla rozszerzona for (tzw. foreach)
  
  int t4[]=t1; // uwaga: t4 i t1 odnoszą się do tej samej tablicy! (*)
  t4[0]=-1;
  
  System.out.println("Zmodyfikowana tablica t1 (podmiana wartości pierwszej komórki)");
  
  for (int x: t1)       
	   System.out.println("Kolejny element t1: " + x);
   }
}
