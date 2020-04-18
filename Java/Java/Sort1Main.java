import MojeTypy.TabInt;

class Sort1Main {

  public static void main(String[] args) { 
    TabInt t;
    int rozm=12;
    t = new TabInt(rozm);
    t.wstaw(40); t.wstaw(2);t.wstaw(1); t.wstaw(6);t.wstaw(18); t.wstaw(20);t.wstaw(29); t.wstaw(32);
    t.wstaw(23); t.wstaw(34);t.wstaw(39); t.wstaw(41);
    t.wstaw(100);
    t.wypisz();
  // Tutaj możesz sprawdzić kolejne algorytmy sortowania:
      System.out.println("Sortowanie przez wstawianie: ");  t.insertSort();
    //System.out.println("Sortowanie bąbelkowe        :");  t.bubble();
    //System.out.println("Sortowanie przez wytrząsanie :"); t.ShakerSort();
    //System.out.println("Sortowanie szybkie           :"); t.qsort(0, rozm-1);
    //System.out.println("Sortowanie przez kopcowanie  :"); t.heapsort();
  t.wypisz();
  }
}
