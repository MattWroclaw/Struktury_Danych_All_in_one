import MojeTypy.FIFO;

public class KolejkaMain {
	
 public static void main(String[] args) {
   int i;
	FIFO<String> kolejka=new FIFO<String> (4); // Kolejka do obsługi napisów (np. nazwisk)
    
	kolejka.wstaw("Kowalska"); kolejka.wstaw("Fronczak"); kolejka.wstaw("Becki");  kolejka.wstaw("Pigwa");
	kolejka.wstaw("Pigwa1"); kolejka.wstaw("Pigwa2"); // Te operacje już się nie powiodą!
    kolejka.wypisz();
	String s;
	 
	s=kolejka.obsluz(); System.out.println("Obsłużony został klient: " + s); 
	kolejka.wypisz();
	 
	System.out.println("Przyszedł Pan Last Minute...");
	kolejka.wstaw("Mr Last Minute");
	kolejka.wypisz();
	 
	 
	while( !kolejka.pusta() ){  //  Ekspresowa obsługa całej kolejki przed zamknięciem sklepu!
	  s=kolejka.obsluz(); 
	  System.out.println("Obsłużony został klient: " + s);
	}
	
	if (!kolejka.pusta())
	 		s=kolejka.obsluz(); // Tu już kolejka będzie pusta
	 		else
	System.out.println("Kolejka pusta!");		
 
	 
 }
}// Koniec definicji klasy KolejkaMain (przykład uzycia klasy generycznej Kolejka)