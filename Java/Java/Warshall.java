import MojeTypy.GrafTabl;
	 
	class Warshall{
			
	 public static void main(String[] args) {
	  GrafTabl G =  new GrafTabl (5, "G");
	  
	  G.add(0, 1, 1); G.add(0, 3, 1); G.add(1, 3, 1); G.add(2, 1, 1); G.add(3, 2, 1); G.add(4, 1, 1);  
	  G.wypisz();
	  G.warshall();
	  System.out.println("Po wykonaniu algorytmu Warshalla:");
	  G.wypisz();
	 }
	}
	
	
	
	
