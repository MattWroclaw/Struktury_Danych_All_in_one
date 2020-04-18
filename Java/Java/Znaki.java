class Znaki {
   
 public static void main(String[] args) {
     
 char c1 = 'a';                             // kod 0x61=97 Unicode
 char c2 = (char) (c1 + 1);                 // kod 0x62=98 Unicode, litera 'b'
 System.out.println(c1 + c2);               // *
 System.out.println("c1+c2=" + c1 + c2);    // **
 int x = 67; 
 char c3 = (char) x;                        // jawna konwersja typu     
 System.out.println("c3=" + c3);            // *** 
 }
}// ten nawias zamyka definicję klasy

/*
Wynik:
195
c1+c2=ab
c3=A
*/
