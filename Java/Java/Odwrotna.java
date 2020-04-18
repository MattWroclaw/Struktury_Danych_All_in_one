class Tmp { // klasa pomocnicza do obsługi zmiennych "globalnych" a i b oraz metod obliczeniowych
 int a=0, b=0;
 
 int P1(int a) {
  int b;
  if(a==0)
	  b=1; 
  else{
	   b=P1(a-1);
	   b=b+a;
  }
 return b;
}


 void P2() {
  if(a==0) 
   b=1; 
  else{
	   a=a-1;
	   P2();
	   a=a+1;
	   b=b+a;
       }
 }
 
 void P2bis(){
  if(a!=0){
	 a--; 
	 P2();
	 b=b+(++a);
   }
   else 
	b=1;
  }
 
 
 void P2_ITERAT(){
  int k=0;
  while (a!=0){
	 a--;
	 k++;
  }
  b=1;
  while (k--!=0) 
     b=b+(++a);
 }
 
}
// --------------------------------------------------------------------------------
class Odwrotna { // tu przetestujemy algorytmy

public static void main(String[] args) {
 Tmp pom= new Tmp();
  for (int i=0; i<17; i++)  { // Wypiszemy ciąg dla wariantu P1
	  pom.b=pom.P1(i);
	  System.out.print(pom.b + " ");
   }
  System.out.println();

  for (int i=0; i<17; i++) { // Wypiszemy ciąg dla wariantu P2
	  pom.a=i;
	  //pom.P2();
	  pom.P2_ITERAT();
	  System.out.print(pom.b + " ");
   }
   System.out.println();
 }
}




