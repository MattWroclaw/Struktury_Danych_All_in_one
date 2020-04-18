import MojeTypy.*; // Zgrupowałem typy pomocnicze w katalogu MojeTypy (=nazwa pakietu)

public class BazaDanychMain {
   public static void main(String[] args) {    
   
   BazaDanych bazad=new BazaDanych(); 

   bazad.wstawSort("Kowalski", 1850);
   bazad.wstawSort("Zarębski", 1100);
   bazad.wstawSort("Fuks", 3000);
   
   bazad.wstawSort("Zubera", 2000);
   bazad.wstawSort("Bond", 2400);
   bazad.wstawSort("Putra", 2200);
     
   
   bazad.wypisz("Lista danych - nieposortowana");
   bazad.wypiszSortZarobk("Wypisz wg zarobkow");
   bazad.wypiszSortNazw("Wypisz alfabetycznie");
   System.out.println("Usuwam rekord: Zubera");
   bazad.usunWybrany("Zubera");
   System.out.println("Usuwam rekord: Figuś");
   bazad.usunWybrany("Figuś");
   bazad.wypisz("Lista danych - nieposortowana");
  }
 }
