import MojeTypy.StosOgraniczony;

public class StosMain {
	
static void stanStosu(StosOgraniczony stos) {
 // metoda musi byc statyczna, patrz Rozdział 5. p. "Pola i metody statyczne klas"
 if (stos.rozmiar() == 0)
	 System.out.println("Stos jest pusty\n"); 
 else
	 if (stos.rozmiar() == stos.pojemnosc()) 
	 System.out.println("Stos jest pełny\n");  
	 else
  System.out.println("Miejsce jest!\n");
 }

 public static void main(String[] args) {
	 StosOgraniczony<Integer> s1=new StosOgraniczony<Integer>(6) ; // stos do odkładania liczb Integer
	   Integer tmp;                                                // (celowo nie typów prostych)

 	s1.push(5); s1.push(2); s1.push(1); s1.push(3); 
 	s1.wypisz();
 	tmp=s1.pop(); System.out.print("Zdjąłem ze stosu: " + tmp); s1.wypisz(); 	
 	tmp=s1.pop(); System.out.print("Zdjąłem ze stosu: " + tmp); s1.wypisz();
 	tmp=s1.pop(); System.out.print("Zdjąłem ze stosu: " + tmp); s1.wypisz();
 	tmp=s1.pop(); System.out.print("Zdjąłem ze stosu: " + tmp); 
 	s1.wypisz();
 	tmp=s1.pop();

 	System.out.print("Zdjąłem ze stosu: " + tmp); s1.wypisz();
 	
 	StosOgraniczony<String> s2=new StosOgraniczony<String> (2);  // Stos o rozmiarze 2 do odkładania napisów 
 	String  s;
 	s2.push("Ala"); s2.push(" ma_kota"); s2.push(" Azora"); s2.push(" Kiciusia"); 
 	s2.wypisz();
 	s=s2.pop();  System.out.println(" Zdjąłem ze stosu: " + s); s2.wypisz(); 	
 	s=s2.pop();  System.out.println(" Zdjąłem ze stosu: " + s); s2.wypisz();
 	s=s2.pop();  System.out.println(" Zdjąłem ze stosu: " + s); s2.wypisz();
    
 	stanStosu(s1);
}
}// Koniec definicji klasy StosMain (przykład użycia klasy generycznej StosOgraniczony)