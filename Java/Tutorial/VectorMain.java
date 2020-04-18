import java.util.Vector;
import java.util.Enumeration;

public class VectorMain{

 public static void main(String [] args) {
	 Vector<Integer> v = new Vector<Integer>(5, 2); // liczby (rozmiar 5, inkrement: 4)
	  for (int i=1; i<=12; i++) {
	    Integer x = Integer.valueOf(i);
	    v.add(x);
	    System.out.println("Rozmiar wektora v: " + v.size() + ", pojemność: " + v.capacity() + ", zawartość:" + v.toString() );
	  }
	  Vector<String> s = new Vector<String>(2); // napisy (rozmiar 2, inkrement: domyślny)
	  System.out.println("Rozmiar wektora s: " + s.size() + ", pojemność: " + s.capacity() ); 
	// początkowo 0 i 2
	  s.add("Ala"); s.add("ma"); 
	  s.add("kota");             // dodajemy trzeci elementy, Java rozszerzy tablicę! (*)
	  System.out.println("Rozmiar wektora s: " + s.size() + ", pojemność: " + s.capacity() );	   
	  Enumeration en = s.elements();
	  System.out.print("Zawartość wektora s: ");
	  while(en.hasMoreElements())
	    System.out.print(en.nextElement() + " ");
	  System.out.println();
	  System.out.println("Piąty element wektora v: "+ v.elementAt(6) ); 
	  // indeksowanie od 0, zawartość [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
	  System.out.println("Drugi element wektora s: "+ s.elementAt(1) ); 
	  // indeksowanie od 0, zawartość [ala ma kota]

  s.setElementAt("Kasia", 0);
  System.out.println(s); // [Ala, ma, kota] ==> [Kasia, ma, kota]
  s.insertElementAt("psa", 2);
  System.out.println(s); // [Kasia, ma, kota] ==> [Kasia, ma, psa, kota]
  
  Vector <String> x = new Vector<String>(); // pusty wektor
  x.addAll(s); // cała zawartość s będzie skopiowana do x
  System.out.println(x);
  
  Vector klon = new Vector(); // pusty wektor
  klon=(Vector)x.clone();     // duplikuje zawartość wektora x
  System.out.println(klon);
  
  if (klon.contains("psa")) 
      System.out.println("Znalazłem słowo 'psa' w wektorze 'klon'");
  
  klon.remove("kota");       // Usuwam słowo 'kota' z wektora (*)
  System.out.println(klon); // Wypisze [Kasia, ma, psa]
  
  if (klon.equals(s)) 
      System.out.println("'klon' i 's' są identyczne"); // Nic nie wypisze, bo w tym momencie klon i s nie są już takie same - patrz (*) 
  
 }
}
 
