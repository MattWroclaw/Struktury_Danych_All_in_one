import java.util.Scanner;

class Referencje{

public static void main(String[] args) {
  String s1 = "ala", s2="ma kota";
  System.out.println("s1=" + s1 + "\ns2=" + s2); // wypisujemy zawartość s1 i s2
  String s3=new String(); // (*)
  Scanner skaner = new Scanner(System.in);
  System.out.print("Podaj ciąg znaków s3: ");
  try{ // odczytaj wiersz tekstowy
      s3 = skaner.next();
      System.out.printf("Podano napis s3: %s\n", s3);
   } catch (Exception  e) 
  		{  System.out.println(e.toString()); }
 for(int i=0; i<s3.length(); i++) // wypisz znak po znaku
      System.out.printf("Znak s3[%d]=%c: \n", i, s3.charAt(i));
 
 s3=s1+" "+s2; // nadpisujemy s3 (**)
 
 System.out.printf("Nowa zawartość s3=%s", s3);
 System.out.println();
 System.out.printf("s1=%s \t s2=%s \t s3=s1+s2=%s\n", s1, s2, s3);
 System.out.printf("Fragment napisu s3=(s1+s2): %s\n", s3.substring(1,6));
 }
}
