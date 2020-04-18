class Konwersje {
	
public static void main(String[] args) {
 char c = 'a', d= 'c', e='Z';
 // alfabet a/A... z/Z = 0... 25
 
 System.out.println(Character.toUpperCase(c));      // a na A
 System.out.println(Character.toUpperCase(c)-'A');  // 0
 System.out.println(Character.toUpperCase(d)-'A');  // 2 itp.  druga litera alfabetu)
 System.out.println(Character.toUpperCase(e)-'A');  // 25 itp. ostatnia litera alfabetu 26 znakowego (od A do Z) 0
 System.out.println ((char)(0 + 'A') ); // Indeks na znak - tutaj 0 na A
 System.out.println ((char)(25 + 'A') ); //Indeks na znak - tutaj 25 na Z
 }
}
