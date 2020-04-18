// Najdłuższy wspólny podnapis
class LCS2{ 

static int LCSn(String X, String Y, int  [][]C) {  
 int M = X.length();
 int N = Y.length();
 int res = 0;  // Wynik 
 
 for(int i=0; i<=M; i++){ 
     for(int j=0; j<=N; j++){ 
	   if (i == 0 || j == 0) 
	       C[i][j] = 0; 
	   else 
		   if (X.charAt(i-1) == Y.charAt(j-1)) { 
	         C[i][j] = C[i-1][j-1] + 1; 
	         res = Math.max(res, C[i][j]); 
	       } else 
	           C[i][j] = 0; 
	 } 
 } 
 return res; 
 } 


static void wypiszLCSn(String X, String Y, int  [][]C) { 
 int M = X.length();
 int N = Y.length();
 int d = 0; // długość najdłuższego wspólnego podnapisu
 String s = ""; 
 int wiersz = 0, kol = 0; 

 for (int i = 0; i <= M; i++) { 
   for (int j = 0; j <= N; j++) { 
     if (i == 0 || j == 0) 
      C[i][j] = 0; 
          else if (X.charAt(i - 1) == Y.charAt(j - 1)) { 
                C[i][j] = C[i - 1][j - 1] + 1; 
                if (d < C[i][j]) { 
                    d = C[i][j]; 
                    wiersz = i; 
                    kol = j; 
                } 
            } 
            else
                C[i][j] = 0; 
        } 
    } 
 if (d != 0) {
  while (C[wiersz][kol] != 0) { 
     s = X.charAt(wiersz-1) + s; 
     wiersz--;
     kol--;
     --d;
  } 
  System.out.println(s);
  } else 
	  System.out.println("Brak wspólnego podnapisu");  
 
}

		
 public static void main(String[] args) {
  String X="PIESKI JEST TEN ŚWIAT";
  String Y="KOT I PIESEK ŚPIĄ OBOK SIEBIE";
  System.out.println(X);
  System.out.println(Y);
  int M     = X.length();
  int N     = Y.length();
  int [][] C= new int [M+1][N+1]; // tablica dlugosci LCS
  System.out.println("LCSn: Długość najdłuższej wspólnej podsekwencji: " + LCSn(X, Y, C));
  System.out.print("wypiszLCSn: ");
  wypiszLCSn(X, Y, C);
 }
}
