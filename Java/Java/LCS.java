// Najdłuższa wspólna podsekwencja
class LCS{ 

static int LCS_dlugosc (String X, String Y, int  [][]C) {
 int i, j;
 int M = X.length();
 int N = Y.length();
 for (i=0; i<M; i++)  C[i][0] = 0;
 for (i=0; i<N; i++)  C[0][i] = 0;
 
 for (i=1; i<M+1; i++)
  for (j=1; j<N+1; j++)
    if (X.charAt(i-1) == Y.charAt(j-1))
         C[i][j]=C[i-1][j-1] + 1;
    else
         C[i][j]=Math.max( C[i][j-1], C[i-1][j] );
 return C[M][N];
 }

static String LCS_wypisz (String X, String Y, int [][]C, int i, int j) { // W tej funkcji odtwarzamy ciąg LCS:
 if ( (i==0) || (j==0)) 
 	return "";
 if (X.charAt(i-1) == Y.charAt(j-1))
  	return (LCS_wypisz(X, Y, C, i-1, j-1) + X.charAt(i-1));
 else
 	if (C[i][j-1] > C[i-1][j])
   		return LCS_wypisz(X, Y, C, i, j-1);
 	else
   		return LCS_wypisz(X, Y, C, i-1, j);
}
		
 public static void main(String[] args) {
	 String X="PKOYTEK";  
	 String Y="MKJAIEOTI";
	 
	 int M     = X.length();
	 int N     = Y.length();
	 int [][] C= new int [M+1][N+1]; // tablica długości LCS
	 
	 System.out.println("Napis X=" + X + ", napis Y=" +  Y);
	 System.out.println("LCS długość: " + LCS_dlugosc(X, Y, C) );
	 System.out.println("Wypisz LCS: " + LCS_wypisz(X,Y, C, M, N) );
	 
 }
}



