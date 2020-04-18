import java.util.*;

public class JavaIteratorMain{

public static void main(String [] args) {
 LinkedList<String> nazwiska = new LinkedList<>();
 nazwiska.add("Janicki");  nazwiska.add("Kowalski"); nazwiska.add("Bęcki");
 
 Iterator<String> itr=nazwiska.iterator();
 // od lewej do prawej...
 while(itr.hasNext())  
  System.out.print(itr.next() + " ");  
 System.out.println();  
 // od prawej do lewej: 
 Iterator i=nazwiska.descendingIterator();  
 while(i.hasNext())  
  System.out.print(i.next() + " ");
 System.out.println();  
 
 nazwiska.add("Szumański");  nazwiska.add("Zandara");
  ListIterator<String> itr2= nazwiska.listIterator(2); // iterator ustawiony na pozycji 3. listy 'nazwiska': [Janicki Kowalski Bęcki Szumański Zandara]
  while(itr2.hasNext())  // Wypisze: Bęcki Szumański Zandara 
	  System.out.print(itr2.next() + " ");  
	 System.out.println();
	 
  itr2.remove(); // iterator wskazuje na ostatni element, usuńmy go!
  System.out.println(nazwiska); // [Janicki, Kowalski, Bęcki, Szumański]
 }
}
