import MojeTypy.GrafTabl;
	 
 class Sciezki{
	
  public static void main(String[] args) {
    GrafTabl G =  new GrafTabl (6, "G");
	
    G.add(0, 3, 1); G.add(0, 5, 1); G.add(1, 2, 1); G.add(2, 4, 1); 
	G.add(3, 1, 1); G.add(3, 4, 1); G.add(5, 4, 1); G.add(4, 5, 1); G.add(5, 2, 1);
	G.wypisz();
	G.initR();
	
	
	System.out.println("WARSHALL");
	G.warshall();
	G.wypisz();
	
	
	System.out.println("Wstępna inicjacja macierzy R na podstawie G");
	G.wypiszR();
	G.budujSciezki();
	G.wypiszR();
	for(int i=0; i<6; i++)
	   for(int j=0; j<6; j++){
		 System.out.print("Droga od wierzchołka " + i + " do " + j + ": ");
	     G.wypiszDroge(i,j);
	}
 }
}
	
	
	
	
