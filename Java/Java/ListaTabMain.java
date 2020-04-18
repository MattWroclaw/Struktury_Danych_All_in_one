// kompilacja i użycie:
// javac ListaTabMain.java
// java ListaTabMain

public class ListaTabMain {
   public static void main(String[] args) {    
   ListaTab bazad=new ListaTab(); 
   
   bazad.WstawNaKoniec("Kowalski", 34); // wstaw na koniec
   bazad.WstawNaKoniec("Pankracy", 45);
   bazad.WstawNaKoniec("Maksymalski", 64);
   bazad.wypisz();
   bazad.usunOsobe("Maksymalski1");      // to się nie uda! 
   bazad.usunOsobe("Maksymalski");       // ten rekord zniknie z listy
   bazad.WstawNaPozycje("Drugi", 15, 1); // wstaw na drugą pozycję
   bazad.WstawNaKoniec("Zenbalski", 30); // wstaw na koniec
   System.out.printf("Szukam: Pankracy1: ");
   System.out.println(bazad.szukaj("Pankracy1")); // to się nie uda,  wynik: -1
   System.out.printf("Szukam: Pankracy: ");
   System.out.println(bazad.szukaj("Pankracy"));  // to się uda,       wynik:  2
   bazad.wypisz();
  }
 }
/*
wyniki:

tab[0]=(Kowalski 34 lat)
tab[1]=(Pankracy 45 lat)
tab[2]=(Maksymalski 64 lat)

Szukam: Pankracy1: -1
Szukam: Pankracy: 2
tab[0]=(Kowalski 34 lat)
tab[1]=(Drugi 15 lat)
tab[2]=(Pankracy 45 lat)
tab[3]=(Zenbalski 30 lat)


 
 */

