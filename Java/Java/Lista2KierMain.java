// kompilacja i użycie:
// javac Lista2KierMain.java
// java Lista2KierMain

import MojeTypy.Lista2Kier; // tam znajdziesz definicję klasy Lista2Kier 

public class Lista2KierMain {
  public static void main(String[] args) {
    Lista2Kier lista = new Lista2Kier();
    lista.wstawSort("Bęcwalski", 12); 
    lista.wstawSort("Antonow", 34); 
    lista.wstawSort("Arcyważny", 34);
    lista.wstawSort("Sowińska", 55);  
    lista.wstawSort("Zulugulski", 67); 
    System.out.printf("Rozmiar=%d\n", lista.rozmiar());
    System.out.println("Lista od początku: ");
    lista.wypiszP();
    System.out.println("Usuwam rekord: Arcyważny");
    lista.usun("Arcyważny");
    System.out.println("Usuwam rekord: Arcyważniak");
    lista.usun("Arcyważniak");
    System.out.printf("Rozmiar=%d\n", lista.rozmiar());
    System.out.println("Lista od konca: ");
    lista.wypiszK();
  }
 }