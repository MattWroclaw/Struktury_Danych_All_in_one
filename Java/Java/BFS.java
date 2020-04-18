import MojeTypy.GrafTabl;
import MojeTypy.FIFO;

class BFS{
	
static void szukaj(GrafTabl G, int i, int N){// rozpoczynamy od wierzchołka 'i'
 FIFO<Integer> kolejka=new FIFO<Integer> (N);
 Integer V[] = new Integer[N];
 for(int z=0; z<N; z++)
	V[z]=0;  // wierzcholek nie był jeszcze badany
	
 kolejka.wstaw(i);
 Integer s;
 while(!kolejka.pusta()) {
  s=kolejka.obsluz();	// bierzemy z kolejki pewien wierzchołek 's'
  System.out.println("Obsługujemy: " + s);
  V[s]=1;             // zaznaczamy wierzchołek 's' jako "badany"
  for(int k=0; k<N; k++)
	 if(G.get(s, k) !=0)  	 // istnieje przejście
	    if(V[k]==0){ // 'k' nie był jeszcze badany
		    V[k]=1;		// zaznaczamy wierzchołek 'k' jako "badany"
		    kolejka.wstaw(k);
		 }
  }
}

 public static void main(String[] args) {
  int N=7;
  GrafTabl G =  new GrafTabl (N, "G");
  G.zeruj();
  G.add(0, 3, 1); G.add(3, 0, 1); G.add(0, 4, 1); G.add(4, 0, 1); G.add(0, 1, 1); G.add(1, 0, 1);
  G.add(1, 4, 1); G.add(4, 1, 1); G.add(1, 2, 1); G.add(2, 1, 1); 
  G.add(3, 6, 1); G.add(6, 3, 1); G.add(3, 4, 1); G.add(4, 3, 1);
  G.add(4, 5, 1); G.add(5, 4, 1); G.add(2, 6, 1); G.add(6, 2, 1);
  G.wypisz();
  szukaj(G, 0, N);
  }
}
