import java.util.*;

public class HashHashBaby {

 public static void main(String[] args) {
	 
  // zbiór danych wejściowych zawartych w napisie wejściowym rozbijemy na słowa oddzielone spacjami:
  String[] dane = new String("Ala ma kota, ale kot nie ma nikogo. Mama nie ma kota").split(" ");
  System.out.println("Rozmiar tablicy napisów: " + dane.length);
  System.out.println("Tablica napisów: ");
  
  for (int i=0; i<dane.length; i++)
      System.out.printf("[%2d] = %-10s \thash code= %d\n", i, dane[i], dane[i].hashCode());
  HashSet<String> zbior = new HashSet<String>();
      
  
  for (int i=0; i<dane.length; i++)
    zbior.add(dane[i]);

  System.out.println("\nRozmiar kolekcji HashSet: " + zbior.size() );
  System.out.println("HashSet: " + zbior);
  System.out.println("Kody w zbiorze HashSet");
  
  Iterator itr= zbior.iterator();
   while (itr.hasNext()) {
	   Object klucz=itr.next();
      System.out.print("[" + klucz + " " + klucz.hashCode() + "] ");
   }
  System.out.println();
  String s1="Mama";
  String s2="Filemon";
  System.out.println("Zbiór zawiera napis " +s1  + ": " + "kod " + s1.hashCode()+ " "+ zbior.contains(s1));
  System.out.println("Zbiór zawiera napis " +s2  + ": " + "kod " + s2.hashCode()+ " "+ zbior.contains(s2));
  
  
  
  
  }
}
