package MojeTypy;

public class GrafTabl{ 
 
 int N;
 String nazwa;
 
 int [][] G; // Graf
 
 int [][] R; // Matryca kierowania ruchem
 
 int []   V; // ta tablica przechowuje na użytek algorytmu przeszukiwania DFS informację, czy dany wierzchołek był już badany (wartość: 1), czy nie (wartość: 0)
  
 
 
// ------------------------------------------------------------- 
 public GrafTabl (int n, String s){ // Konstruktor
  this.nazwa = s;
  N = n;
  G = new int [N][N];
  R = new int [N][N];
  V = new int [N];
  
 }
//-------------------------------------------------------------	
 public void zeruj(){
  for(int i=0;i<N;i++)
	   for(int j=0;j<N;j++)
		G[i][j]=0; // konwencja: 0=brak krawędzi
  }
//-------------------------------------------------------------
 public void add(int i, int j, int val) { // dopisz węzel
  if ( (i<N) && (j<N) )
	  G[i][j]=val;
 else 
	System.out.println("Indeks poza zakresem tablicy: " + i + "!");
}
//-------------------------------------------------------------
public int get(int i, int j) { // zwróć wartość węzła
 if ( (i<N) && (j<N) )
	  return G[i][j];
 else 
	return -1; // umowny błąd
 }
 
//-------------------------------------------------------------
 public void wypisz () { // Wypisz graf G
  System.out.println("Graf: " + nazwa);
  for(int i=0; i<N; i++){
	 for(int j=0; j<N; j++)
		 if (G[i][j] != 100000)
		     System.out.printf ("%3d", G[i][j]);
		 else
			 System.out.printf (" - ");
   	 System.out.println();
  }
 }
//-------------------------------------------------------------
 public void wypiszR () { // Wypisz macierz kierowania ruchem R
  System.out.println("Macierz kierowania ruchem grafu " + nazwa);
  for(int i=0; i<N; i++){
     for(int j=0; j<N; j++)
	   System.out.print (R[i][j] + "  ");
	   System.out.println();
  }
 }
//------------------------------------------------------------- 
 public void wypiszDroge (int x, int y) { // Wypisz drogę od wierzchołka x do y dzięki informacjom zawartym w macierzy kierowania ruchem R
   int k;
   if(R[x][y]==0) 
	 System.out.println("Droga nie istnieje");
   else {
	     k=R[x][y];
	     System.out.print(k + "  ");
	     while(k!=y){
		    k=R[k][y];
		    System.out.print(k + "  ");
	 }
	  System.out.println();
	}
 }

//-------------------------------------------------------------
public void initFloyd(){ // Inicjacja na użytek algorytmu Floyda "100000" oznacza brak krawedzi (nieskończony koszt przejścia) 
	  for(int i=0;i<N;i++)
		   for(int j=0;j<N;j++)
			G[i][j]=100000; 
	  }
 //-------------------------------------------------------------
 
 public void floyd () { // najprostsza forma algorytmu Floyda, która oblicza wartość optymalnej drogi, ale jej nie zapamiętuje 
  for(int k=0; k<N; k++)
	   for(int i=0; i<N; i++)
	      for(int j=0; j<N; j++)
		         G[i][j]=Math.min( G[i][j], G[i][k]+G[k][j]);
 }
 //-------------------------------------------------------------
 public void floydRoute () { // algorytm Floyda, który oblicza wartość optymalnej drogi i zapamiętuje ją w macierzy kierowania ruchem R
  for(int k=0;k<N; k++)
	for(int i=0;i<N; i++)
	   for(int j=0;j<N; j++) {
		   if( G[i][k]+G[k][j] < G[i][j]){
				 G[i][j]=G[i][k]+G[k][j];
				 R[i][j]=k; // zapamietaj droge

	   }
  }
 }    
//-------------------------------------------------------------
 public void drogaFloyd(int i, int j) { // procedura odtwarza drogę zapisaną w R (efekt zastosowania algorytmu Floyda — metoda floydRoute)
  int k = R[i][j]; 
  if (k != 0) {
	drogaFloyd(i,k);
	System.out.print (k + "  ");
	drogaFloyd(k,j);
  }
}

//-------------------------------------------------------------
 
 public void warshall(){ // wykonuje algorym Warshalla na grafie G
 /* Graf musi być zainicjowany:
	 G[x, y] = 0, jeśli nie istnieje krawędź (x, y).
	 G[x, y] = 1 w przeciwnym wypadku.
  */
  for(int x=0; x<N; x++)
   for(int y=0; y<N; y++)
     for(int z=0; z<N; z++)
	    if(G[y][z]==0) 
	    	G[y][z]=G[y][x]*G[x][z];
 }	
//-------------------------------------------------------------
 public void initR(){  // tworzy z grafu G macierz kierowania ruchem R
/* 
	 R[x, y] = 0, jeśli w G nie istnieje krawędź (x, y).
	 R[x, y] = y w przeciwnym wypadku.
*/ 
  for(int x=0; x<N; x++)
	for(int y=0; y<N; y++)
	   if(G[x][y]==0)
	     R[x][y]=0;
	   else
		 R[x][y]=y; 
 }
//-------------------------------------------------------------
 public void zerujR(){  // zwykłe zerowanie macierzy R
   for(int x=0; x<N; x++)
 	for(int y=0; y<N; y++)
 	     R[x][y]=0;          // Umowny brak drogi
  }
 //-------------------------------------------------------------
 public void budujSciezki(){ // zbuduj ściezki dojścia pomiędzy węzłami
 for(int x=0; x<N; x++)
   for(int y=0; y<N; y++)
	  if(R[y][x]!=0) // wiemy, jak dojść z 'y' do 'x'
	     for(int z=0; z<N; z++)
	     if( (R[y][z]==0) && (R[x][z]!=0) )
	        R[y][z]=R[y][x];
 }
//-------------------------------------------------------------
 
public void kompozycja(GrafTabl G1, GrafTabl G2){ // ten graf G stanie się kompozycją dwóch innych: G1 i G2
 this.zeruj();
 int z;
 for(int x=0; x<N; x++)
   for(int y=0; y<N; y++){
     z=0;
	 while(true){ // pętla nieskończona
	   if(z==N) 
	     break; // wyjście z pętli
	      if( (G1.G[x][z]==1) && (G2.G[z][y]==1) )
	             G[x][y]=1;
	      z++;
	  }
  }
 }
//-------------------------------------------------------------
//Strategia "w głąb" (ang. depth-first search)
//-------------------------------------------------------------

public void zwiedzajDFS (int i) {
 V[i]=1;  // zaznaczamy wierzchołek jako "zbadany"
 System.out.println("Badam wierzchołek: " + i);

 for(int k=0; k<N; k++)
	if(G[i][k]!=0)  // istnieje przejście
		if(V[k]==0) 
			zwiedzajDFS(k);
 } 

 public void szukajDFS() {
 int i;
 for(i=0; i<N; i++) 
	V[i]=0;  // oznaczmy wierzchołek jako "niezbadany"
 for(i=0; i<N; i++)
	if(V[i]==0) 
		zwiedzajDFS(i);
 }

}
