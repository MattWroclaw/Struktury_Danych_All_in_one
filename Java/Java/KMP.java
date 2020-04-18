class KMP{
	
public static void init_shifts(String w, int shift[]) {
  int i,j;
  int M = shift.length;
  shift[0]=-1;
  for(i=0,j=-1; i < M-1;  i++, j++, shift[i]=j )
	while((j>=0)&&(w.charAt(i)!=w.charAt(j))) 
	   j=shift[j];
  }

public static int kmp(String w, String t, int shift[]) {
 int i,j;
 int N = t.length();
 int M = shift.length;
 for(i=0,j=0; (i<N) && (j<M); i++,j++)
	while( (j>=0) && (t.charAt(i)!=w.charAt(j)) ) 
		j=shift[j];
	 if (j==M) 
		return i-M; 
	 else 
		 return -1;
 }
		
// ---------------------------------------------

 public static void main(String[] args) {
  String t =  new String("abcd1010efg");
  String w1 = new String("1010");
  String w2 = new String("1011");
  int shift1[]= new int[ w1.length() ];
  init_shifts(w1, shift1);
  System.out.printf("Szukam [%s] w [%s], wynik (pozycja): %d\n", w1, t, kmp (w1, t, shift1) );
  int shift2[]= new int[ w2.length() ];
  init_shifts(w2, shift2);
  System.out.printf("Szukam [%s] w [%s], wynik (pozycja): %d\n", w2, t, kmp (w2, t, shift2) );
 }
}



