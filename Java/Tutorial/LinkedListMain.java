import java.util.List;
import java.util.LinkedList;

public class LinkedListMain{

public static void main(String [] args) {
 LinkedList<String> nazwiska1 = new LinkedList<>();
 
 nazwiska1.add("Janicki");
 nazwiska1.add("Kowalski");
 nazwiska1.add("Bęcki");
 System.out.println("Lista1="+nazwiska1);
 
 List<String> nazwiska2 = new LinkedList<>();
 
 nazwiska2.addAll(nazwiska1); // dodajemy całą kolekcję 'nazwiska1' do 'nazwiska2'
 nazwiska2.add("Bond");   // Trochę nowych danych
 nazwiska2.add("Willis");
 System.out.println("Lista2="+nazwiska2);

 nazwiska2.remove("Willis");
 System.out.println("Lista2 bez Bruce'a Willisa="+nazwiska2);
 
 
 // dodajemy 'Antonow'  na początek listy nazwiska1 -> [Antonow, Janicki, Kowalski, Bęcki]
 nazwiska1.addFirst("Antonow"); 
 System.out.println("Lista1 + 'Antonow' na początek=" + nazwiska1);
 
 // dodajemy ‘Zębaty’ na koniec  listy nazwiska1 -> [Antonow, Janicki, Kowalski, Bęcki, Zębaty]
 nazwiska1.addLast ("Zębaty");
 System.out.println("Lista1 + ‘Zębaty’ na koniec=" + nazwiska1);
 
 // dodajemy na 2 pozycji listy nazwiska1 nazwisko ‘Drugi’ --> [Antonow, Janicki, Drugi, Kowalski, Bęcki, Zębaty]
 nazwiska1.add     (2, "Drugi");  
 System.out.println("Lista1 + 'Drugi' na  pozycji 2. (licząc od zera) =" + nazwiska1);
  
 System.out.println("Lista nazwiska2 zawiera 'Bond' " + nazwiska2.contains("Bond"));
 System.out.println("Pozycja 0 na liście nazwiska2 to:" + nazwiska2.get(0));
 System.out.println("Indeks, pod którym zapisany jest Bruce 'Willis': " + nazwiska2.indexOf("Willis"));
 System.out.println("Indeks, pod którym jest zapisany James 'Bond': "   + nazwiska2.indexOf("Bond")  );
 }
}
