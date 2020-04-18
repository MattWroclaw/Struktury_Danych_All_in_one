import java.util.Stack; 

public class StackMain { 
 public static void main(String[] args){ 
  Stack<String> s = new Stack<String>(); 
  s.push("A");s.push("B");s.push("C");s.push("D");s.push("E");
  System.out.println("Zawartość stosu: " + s); 
  System.out.println("Stos zawiera 'C' na pozycji: " + s.search("C")); // na 3 pozycji (licząc od 1)
  System.out.println("Stos zawiera 'X' na pozycji: " + s.search("X")); // -1, brak na stosie 
 
 /* Kod bezsensowny dla koncepcji stosu ale działający z powodu oparcia klasy Stack na klasie Vector 
 s.remove("C");
 System.out.println("Zawartość stosu: " + s);  // Zawartość stosu: [A, B, D, E]
 */
 
 } 
} 