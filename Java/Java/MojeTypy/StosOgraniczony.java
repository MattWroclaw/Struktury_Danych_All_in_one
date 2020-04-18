package MojeTypy; // Typy pomocnicze zgrupowalem w katalogu MojeTypy (=nazwa pakietu)
import java.util.Vector;
import java.util.Enumeration;;

public class StosOgraniczony<TypPodst>{
  private Vector<TypPodst> stos;
 
  public StosOgraniczony(int rozmiar) { // konstruktor
    stos= new Vector<TypPodst>(rozmiar);// Vector(int size) tworzy wektor o rozmiarze 'size'
    System.out.println("Tworzę stos o pojemności:"+ stos.capacity() + ", liczba elementów="+ stos.size() );
  }
  public void clear() { // Zerowanie stosu, metoda klasy Vector!
    stos.clear();
  } 
  public void wypisz() { // Uwaga, ta metoda zadziała poprawnie tylko dla typów prostych
  // System.out.println(stos); // Wypróbuj tę instrukcję zamiast poniższego kodu...
    Enumeration vEnum = stos.elements();
    System.out.print(" Zawartość stosu:[");
    while(vEnum.hasMoreElements())
    System.out.print(vEnum.nextElement() + " ");
    System.out.println("]");
  }
  public void push(TypPodst obj) {
	System.out.print("Odkładam: ");
	System.out.print(obj.toString());
    if ( stos.size() < stos.capacity() ) {
     stos.add(obj);
     System.out.println(", STOS ROZMIAR:" + stos.size() +  ", STOS POJEMNOŚĆ= " + stos.capacity());
    } else 
	System.out.println("* POJEMNOŚĆ PRZEKROCZONA *");
  }
	
  public TypPodst pop(){ 
    TypPodst tmp=null;
    if (stos.size()>0) {
      tmp=stos.lastElement();
      stos.remove(tmp);
      System.out.print("Zdejmuję: ");
      System.out.print(tmp.toString());
      System.out.println(", STOS ROZMIAR:"+stos.size() );
     }
     return tmp;  // Usuwamy ze stosu ale nie tracimy dostępu do elementu usuwanego
  }
   public int rozmiar(){	// Zwraca stan zajętości stosu
     return stos.size();
  }
  public int pojemnosc(){	// Zwraca pojemność stosu
	 return stos.capacity();
  }
}// Koniec definicji klasy generycznej StosOgraniczony
