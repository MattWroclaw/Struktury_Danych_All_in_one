package MojeTypy; // Zgrupowałem typy pomocnicze w katalogu MojeTypy (=nazwa pakietu)
import java.util.Vector;

public class FIFO<TypPodst>{
  private Vector<TypPodst> kolejka;
	int glowa, ogon, dlugosc; 
	final int MaxElt;
	
  public FIFO(int rozm) {
	kolejka= new Vector<TypPodst>(rozm); // Vector(int size) tworzy wektor o rozmiarze 'size'
	MaxElt=rozm;
	glowa = dlugosc = 0;
	ogon = -1;
	System.out.println("Tworzę kolejkę o pojemności"+ rozm);
  }
	
  public void wstaw(TypPodst obj) {
	  //System.out.print(" Wstawiam:" + obj);
	  if (dlugosc != MaxElt) {
		  if(ogon == (MaxElt-1) ) // Zawijamy!
				ogon = -1;
	  	  kolejka.insertElementAt(obj, ++ogon); //  Przesuń ogon i wstaw
	  	  dlugosc++;
		   }else
		  System.out.println("** Kolejka pełna **");
  }

  public TypPodst obsluz(){ // Brak kontroli poprawności operacji 
	  TypPodst temp = kolejka.elementAt(glowa++); // Pobierz wartość i przesuń głowę
	  if(glowa == MaxElt) 		// Zawijamy!
			glowa = 0;
  	  dlugosc--; 
	  return temp;   
  }
    
  public void wypisz(){ // Wypisz uwzględniając efekt zawijania tablicy
	System.out.println("Zawartość kolejki:");
	int k=glowa;
	for (int i = 0; i < dlugosc; i++) {	  
	  if (k== MaxElt)
	      k=0;
      System.out.print(" [" + i + "]=" + kolejka.elementAt(k++) + " ");
    }
	  System.out.println();
   }
  
  
  public boolean pusta(){  // Czy kolejka jest pusta
		return (dlugosc==0); 
  }
  
}// Koniec definicji klasy generycznej FIFO

