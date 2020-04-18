package MojeTypy; // Typy pomocnicze zgrupowałem w katalogu MojeTypy (=nazwa pakietu)

public class Wezel { // Przykładowy węze… danych używany w klasie BST
	
 public int klucz;   // wartość klucza (inne dane węzła pomijamy w naszym przykładzie)
  Wezel lewy;  // lewy potomek
  Wezel prawy; // prawy potomek

  public Wezel (int k) {klucz = k;} // konstruktor
	 
  public void pisz() {
   System.out.print("[" + klucz + "] ");
 }
}