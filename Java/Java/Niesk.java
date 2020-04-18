class Niesk { 
  static int cpt=0;
  static int N(int n, int p) {
  cpt++;
  System.out.println("Wywołanie: " + cpt);
  if (n==0) 
    return 1;
  else
    return N(n-1, N(n-p,p) );
}
public static void main(String[] args) {
 try {
     N(1,0);
     } 
    catch (StackOverflowError e) {
     System.out.println(e.toString());
    }
 }
}




