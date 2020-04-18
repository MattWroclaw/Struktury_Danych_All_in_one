class Dyn2D{ 
 
 static void dynam(double P[][]){
  int i,j, n=P.length;
	for(i=1; i < n; i++){
	   P[i][0]=0;
	   P[0][i]=1;
	 }
	for(j=1; j<n; j++)
	   for(i=1; i<n; i++)
	      P[i][j]=(P[i-1][j] + P[i][j-1]) / 2.0;
 }


 public static void main(String[] args) {
 int N=5;
 double P[][] = new double[N][N];
 dynam(P);
 for(int i=0; i<N; i++) // sprawdźmy wyniki wypisując zawartość tablicy P
	 for(int j=0; j<N; j++)
       System.out.println("P[" + i + "][" + j + "]=" + P[i][j]);
 }
}



