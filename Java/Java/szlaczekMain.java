public class szlaczekMain {
	
// Metoda musi byc statyczna, patrz Rozdział 5 p. "Pola i metody statyczne klas"

public static void symetria1 (int x) {
  if (x==0) 
     System.out.print("-");
  else{                
	  System.out.print("<");          
	   symetria1(x-1);
	   System.out.print(">");
	} 
 }

 public static void symetria2 (int x) {
  for(int i=1; i<=x;i++) 
 	 System.out.print("<");          
     System.out.print("-");
  for(int i=1; i<=x;i++) 
     System.out.print(">");
  }


 public static void main(String[] args) {
	symetria1(6);
	System.out.println();
	symetria2(6);
 }
}