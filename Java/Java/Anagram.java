import java.util.Arrays;
public class Anagram{ 

 static boolean anagramy(String zdanie1, String zdanie2) { 
  String s1 = zdanie1.replaceAll("\\s",""); // usuwamy spacje
  String s2 = zdanie2.replaceAll("\\s",""); // usuwamy spacje
 
  int n1 = s1.length(); 
  int n2 = s2.length(); 
     if (n1 != n2) 
        return false;
  char[] ch1 = s1.toCharArray(); // konwersja na tablice znaków
  char[] ch2 = s2.toCharArray(); // konwersja na tablice znaków
  Arrays.sort(ch1); // sortujemy znaki ch1
  Arrays.sort(ch2); // sortujemy znaki ch2

  for (int i = 0; i < n1; i++) // porównujemy znak po znaku 
     if (ch1[i] != ch2[i]) 
          return 
        		  false; 
  return true; 
 } 


 public static void main(String[] args) { 
  System.out.println( anagramy ("quid est veritas","vir est qui adest") ); // Pytanie Piłata "Co to jest prawda?" i odpowiedź Jezusa "Człowiek, który stoi przed tobą"		 
  System.out.println( anagramy ("baba","abba") );
  System.out.println( anagramy ("baba","abbe") );
 }
}