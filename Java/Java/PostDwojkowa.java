class PostDwojkowa {
 static void konwersja(int n) {
   if(n!=0){
     konwersja(n/2);       // n modulo 2
   System.out.print(n%2);  // reszta z dzielenia przez 2
   }else
	   System.out.print(0);
 }

 static void konwersja2(int x, int res, int pos) { // pierwsze wywołanie z pos=0, res=0
  if(x>0)
	  konwersja2( x/2, res + ( (x%2) * (int) Math.pow(10.0, pos)),  pos+1); // Metoda Math.pow(a, n); podnosi liczbę a do potęgi n
  else 
      System.out.print(res);
 }

public static void main(String[] args) {
 // Metoda 1:
  for (int i=0; i<=10; i++){
       System.out.print("Postać dwójkowa liczby " + i + ": ");
       konwersja(i);
    System.out.println();
  }
// Metoda 2:
  for (int i=0; i<=10; i++){
     System.out.print("Postać dwójkowa liczby " + i + ": ");
       konwersja2(i, 0, 0);
     System.out.println();
  }
 }
}
