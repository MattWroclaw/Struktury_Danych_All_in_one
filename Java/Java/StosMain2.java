import MojeTypy.Stos;

public class StosMain2 {
	
static void stanStosu(Stos stos) {
 // Metoda musi byc statyczna, patrz Rozdział 5 p. "Pola i metody statyczne klas"
 if (stos.rozmiar() == 0)
	 System.out.println("Stos jest pusty\n"); 
 else
	 if (stos.rozmiar() == stos.pojemnosc()) 
	 System.out.println("Stos jest pełny\n");  
	 else
  System.out.println("Miejsce jest!  \n");
 }

 public static void main(String[] args) {
	Stos<Integer> s1=new Stos<Integer> (); // Stos do odkładania liczb Integer (celowo nie typów prostych)
    Integer tmp;
 	s1.push(5); s1.push(2); s1.push(1); s1.push(3); 
 	s1.wypisz();
 	tmp=s1.pop(); System.out.print(" Zdjąłem ze stosu: " + tmp); s1.wypisz(); 	
 	tmp=s1.pop(); System.out.print(" Zdjąłem ze stosu: " + tmp); s1.wypisz();
 	tmp=s1.pop(); System.out.print(" Zdjąłem ze stosu: " + tmp); s1.wypisz();
 	tmp=s1.pop(); System.out.print(" Zdjąłem ze stosu: " + tmp); 
 	s1.wypisz();
 	tmp=s1.pop();

 	System.out.print(" Zdjąłem ze stosu: " + tmp); s1.wypisz();
 	
 	Stos<String> s2=new Stos<String> ();  // Stos do odkładania napisów 
 	String  s;
 	s2.push("Ala"); s2.push(" ma_kota"); s2.push(" Azora"); s2.push(" Kiciusia"); 
 	s2.wypisz();
 	s=s2.pop();  System.out.println(" Zdjąłem ze stosu: " + s); s2.wypisz(); 	
 	s=s2.pop();  System.out.println(" Zdjąłem ze stosu: " + s); s2.wypisz();
 	s=s2.pop();  System.out.println(" Zdjąłem ze stosu: " + s); s2.wypisz();
 }
}// Koniec definicji klasy StosMain (przykład użycia klasy generycznej Stos)