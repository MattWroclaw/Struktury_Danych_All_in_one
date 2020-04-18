import java.io.*;
import java.util.*;


class SystemSort {

 public static void main(String[] args) throws IOException {

 String s;
 Scanner   plik1 = new Scanner    (new FileReader ("input1.txt") );
 Scanner   plik2 = new Scanner    (new FileReader ("input2.txt") );
 PrintWriter out1 =                new PrintWriter("output.txt")  ;

 //Opcja 1: złączanie plików z użyciem metod bibliotecznych Javy:

 while(plik1.hasNext()) {
  s=plik1.nextLine();
  System.out.println("Czytam 1: " + s); // Kopiujemy zawartość pliku input1.txt do output.txt
  out1.println(s);  // nowa linia (zawartość 's') do do output.txt
 }

 while(plik2.hasNext()) {
  s=plik2.nextLine();
  System.out.println("Czytam 2: " + s);
  out1.println(s); // Kopiujemy zawartość pliku input2.txt do output.txt
 }
 out1.close();     // Zamykany plik wyjściowy output.txt (operacja systemowa)

 // Opcja 2: złączanie plików z użyciem polecenie systemowego 'copy'
 try{
   // przełącznik /C  w komendzie 'cmd / C s' wywołuje komendę 's' w nowej instancji interpretera cmd.exe i kończy proces
   Process p = Runtime.getRuntime().exec("cmd /C copy input1.txt+input2.txt output-systemowy.txt");
   BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
   String line = null;
   while ((line = in.readLine()) != null) {System.out.println(line); }
  } catch (IOException e) {e.printStackTrace();}
 
// sortujemy zawartość pliku output-systemowy.txt i zapisujemy go w output-systemowy-sorted.txt 
 try{
	 Process p = Runtime.getRuntime().exec("cmd /C sort output-systemowy.txt /O output-systemowy-sorted.txt");
	 BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	 String line = null;
	 while ((line = in.readLine()) != null) {System.out.println(line); }
  } catch (IOException e) {e.printStackTrace(); }
 }
}
