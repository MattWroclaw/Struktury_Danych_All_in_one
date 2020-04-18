import MojeTypy.BST;

class BSTMain {
  public static void main(String[] args){
  BST drzewo = new BST();
  drzewo.wstaw(19); drzewo.wstaw(4); drzewo.wstaw(25); drzewo.wstaw(3);  drzewo.wstaw(12); 
  drzewo.wstaw(14); drzewo.wstaw(8); drzewo.wstaw(27); drzewo.wstaw(26); drzewo.wstaw(31);
  System.out.print("Wartość minimalna:");
  drzewo.Min();
  
  System.out.println("\nPre-order");
  	
  drzewo.preOrder(drzewo.korzen);
  System.out.println("\nIn-order");
  drzewo.inOrder(drzewo.korzen);
  System.out.println("\nPost-order"); 
  drzewo.postOrder(drzewo.korzen);
    
  if (drzewo.szukaj(43) != null)
	   System.out.println("Znalazłem 43");
  if (drzewo.szukaj(4) == null)
	   System.out.println("Nie znalazłem");
 
  if (drzewo.usun(3) == true) 
	  System.out.println("\nWykasowałem 3"); // 3 na pewno znajduje się na drzewie
  System.out.print("Wartość minimalna:");
  drzewo.Min();
  System.out.print("Wartość maksymalna:");
  drzewo.Max();
  
  
  if (drzewo.usun(99)== false)
	  System.out.println("Nie mog∑ wykasować 99, brak węzła");
 
  System.out.println("In-order");
  drzewo.inOrder(drzewo.korzen); // wypiszmy drzewo w celu sprawdzenia, czy 3. został skasowany 
 }
}