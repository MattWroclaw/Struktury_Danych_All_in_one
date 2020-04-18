class Hanoi {
	
 public static void hanoi(int n, int a, int b) {
  if (n==1) 
	   System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
	else{
		hanoi(n-1,a,3-a-b);
		System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
		hanoi(n-1,3-a-b,b);
	 }
 }

 public static void hanoi2(int n, int a, int b){
	 while (n!=1){
		hanoi2(n-1, a, 3-a-b);
		System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
		n=n-1;
		a=3-a-b;
	 }
	 System.out.println("Przesuń dysk nr 1" + " z " + a + " na " + b);
}
 
 public static void main(String[] args) {
	 System.out.println("WERSJA 1:");
     hanoi(4, 0, 1);
     System.out.println("WERSJA 2:");
	 hanoi2(4, 0, 1);
  }
}
