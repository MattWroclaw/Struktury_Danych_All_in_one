class Napisy {
	
 public static void main(String[] args) {
   String s1="";              // napis pusty
   String s2="Hello";         // napis o długości 5 znaków
   String s3="World\u0040";   // napis o długości 6 znaków (ostatni znak to @)
   
   // konwersja liczby 13 na napis
   System.out.println("Przykład konwersji liczby na napis: "+s1+13);
   System.out.println("s2="+s2);      
   System.out.println("s3="+s3);     // wypisze World@
   
   s3=s3.substring(0, 2);      // skopiuje do s3 ciąg zbudowany z pierwszych dwóch znaków napisu 3
   
   System.out.println("Skrócone s3="+s3);     // wypisze Wo
   System.out.println("Długość s3="+s3.length());
   String s4="Hello";
 
   if (s4+s4=="HelloHello")        // (*) pozornie to poprawna instrukcja,
       System.out.println("OK");   // ale nie tak się porównuje łańcuchy w Javie!
   else
       System.out.println("Nie-OK");
   
   if (s2.equals(s4))       // (**) poprawne porównywanie napisów w Javie
       System.out.println("s2=s4: " + s2 + "-" + s4);
   
   for(int i=0;i<s4.length();i++)
	   System.out.println("Znak na pozycji [" + i + "]=" + s4.charAt(i));
   
   System.out.println("s2 dużymi literami: "+s2.toUpperCase());
   System.out.println("Fragment [1-2] napisu s2: "+s2.substring(1,3)); 
   // substring (int pocz, int koniec) zwraca fragment od 'pocz' do 'koniec-1'
 }
}
