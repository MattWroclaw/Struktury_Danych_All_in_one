import java.io.*;
import java.util.*;

public class Pliki {
 public static void main(String[] args) throws IOException {
  // Przykład 1: odczyt linia po linii
  String s;
  Scanner plik = new Scanner(new FileReader("input.txt"));
  
  /* Zawartość pliku input.txt:
  
  Linia 1: Java
  Linia 2: to
  Linia 3: jest
  Linia 4: to
 */
  
  PrintWriter out = new PrintWriter("output.txt");
  
  // Przykład 2: odczyt i zapis do innego pliku
  
  while(plik.hasNext()) {
	  s=plik.nextLine();
	  System.out.println("Czytam> " + s); // wypisujemy zawartość pliku   input.txt
	  out.println("Ocenzurowano!"+s);     // kopiujemy zawartosc do pliku output.txt
  }
  out.close();                            // zamykany plik wyjsciowy (operacja systemowa)
  
  /* Zawartość pliku output.txt:
   
    Ocenzurowano!Linia 1: Java
	Ocenzurowano!Linia 2: to
	Ocenzurowano!Linia 3: jest
	Ocenzurowano!Linia 4: to
   */
  
  
  // Przykład 3: odczyt binarny i interpretacja zawartości
  int znak;
  FileInputStream plikBIN = new FileInputStream("input1.txt"); // czytamy zawartość input1.txt
  System.out.println(" znak |   DEC|   HEX");
	 while( (znak=plikBIN.read()) != -1 ) {                    // czytamy, aż osiągniemy koniec pliku
		if ((znak==10) || (znak==13)) // Znaki końca linii Windows/UNIX
				System.out.printf("      |");
		else
  		 System.out.printf("%6c|", znak);
   	    System.out.printf("%6d|",  znak);
      	System.out.printf("%6s\n", Integer.toHexString(znak));}
 }
}
 