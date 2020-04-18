import java.util.*;

public class SortowanieMain{

 public static void main(String [] args) {
  LinkedList<String> miasta = new LinkedList<>();
  miasta.add("Bełchatów");
  miasta.add("Katowice");
  miasta.add("Radom");
  miasta.add("Warszawa");
  miasta.add("Poznań");
  System.out.println("Lista początkowa  = " + miasta);
  miasta.sort(Comparator.naturalOrder());
  System.out.println("Lista po posortowaniu w kierunku naturalnym  = " + miasta);
  miasta.sort(Comparator.reverseOrder());
  System.out.println("Lista po posortowaniu w kolejności odwrotnej = " + miasta);
 }
}
