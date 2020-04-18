package MojeTypy; // Typy pomocnicze zgrupowałem w katalogu MojeTypy (=nazwa pakietu)
import java.util.Vector;
import java.util.Enumeration;;

public class Stos<TypPodst>{
  private Vector<TypPodst> stos;
  private int  licznik; // Umówmy się, że -1 oznacza stosu pusty
 
  public Stos() { // konstruktor
    stos= new Vector<TypPodst>(); // Vector(int size) tworzy wektor o rozmiarze 'size'
    this.licznik = -1;
  }
  public void clear() { // Zerowanie stosu, metoda klasy Vector!
    stos.clear();
  } 
  public void wypisz() { // Uwaga, ta metoda zadziała poprawnie tylko dla typów prostych
    Enumeration vEnum = stos.elements();
    System.out.print(" Zawartość stosu:[");
    while(vEnum.hasMoreElements())
    System.out.print(vEnum.nextElement() + " ");
    System.out.println("]");
  }
  public void push(TypPodst obj) {
     stos.add(obj);
     licznik++;
  }
  public TypPodst pop(){ 
	  TypPodst tmp=null;
    if (stos.size()>0) {
      tmp=stos.lastElement();
      stos.remove(tmp);
     }
     return tmp;  // Usuwamy ze stosu ale nie tracimy dostępu do elementu usuwanego
  }
   public int rozmiar(){	// Zwraca stan zajętości stosu
     return stos.size();
  }
  public int pojemnosc(){	// Zwraca pojemność stosu
	 return stos.capacity();
  }
  public boolean czyPusty(){	// czy stos jest pusty?
	 return licznik==-1;
  }
}// Koniec definicji klasy generycznej Stos  

