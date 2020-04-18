class Tmp { // klasa pomocnicza do obsługi zmiennych "globalnych" a, bc i n oraz metod obliczeniowych
 int a=0, b=0, n=0;
 
void hanoi() {
  if (n!=1) {
	n--; b=3-a-b;
	hanoi();
	n++; b=3-a-b;
	System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
	n--; a=3-a-b;
	hanoi();
	n++; a=3-a-b;
   }else
	 System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
}
 
 void hanoiIter(){
  int M=1;
  do{
	 while (n!=1){ 
	  n--;
	  b=3-a-b; 
	  M*=2;
	 } 
	 System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
     while ((M!=1) && (M%2==1)) {
	    M=M/2; n=n+1; a=3-a-b;
	  }
     if(M==1) break;
	  M++;
	  n++; b=3-a-b;
	  System.out.println("Przesuń dysk nr " + n + " z " + a + " na " + b);
	  n--; a=3-a-b;
	 }while (M!=1);
	}
  
}
// --------------------------------------------------------------------------------
class HanoiIter { // tu przetestujemy algorytmy

public static void main(String[] args) {
 Tmp pom= new Tmp();
 
 System.out.println("Klasycznie");
 pom.n=4; pom.a=0; pom.b=1;
 pom.hanoi();
 System.out.println("Iteracyjnie");
 pom.n=4; pom.a=0; pom.b=1;
 pom.hanoiIter();
 }
}