import MojeTypy.GrafTabl;
	 
 class Floyd{
	
 public static void main(String[] args) {
  int N=7;
  GrafTabl G =  new GrafTabl (N, "G");
    
  G.initFloyd(); // Inicjacja na użytek algorytmu Floyda - 100000 nie oznacza brak krawędzi (nieskończony koszt przejścia)
  G.zerujR();    // Zwykłe zerowanie macierzy R
  // Tutaj wpiszmy definicje węzłów i koszty przejścia między nimi
  G.add(0, 3, 30); G.add(0, 1, 10); G.add(1, 2, 15); G.add(1, 4, 40); G.add(2, 3, 5); 
  G.add(2, 4, 20); G.add(4, 5, 20); G.add(4, 6, 10); G.add(5, 6, 5); G.add(6, 3, 25);
  G.wypisz();
  G.floydRoute(); // Wywołuje algorytm Floyda w wersji 2
  for(int i=0; i<N; i++)
	for(int j=0; j<N; j++){
	  if(G.get(i, j) == 100000) 
		  System.out.println(i + "  -->  " + j + "   [drogi nie ma]");
	  else
		if(i!=j){
		  System.out.print(i + "  -->  " + j + ", Koszt= " + G.get(i, j) + ". Droga przez: ");
		  G.drogaFloyd(i,j);
		  System.out.println();
		}
	  }
 }
}
	
	
	
	
