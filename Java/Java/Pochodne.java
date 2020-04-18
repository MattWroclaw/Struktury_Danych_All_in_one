class Pochodne{

 static final int N=5; // rząd obliczanych różnic centralnych wynosi n-1	
	
 static double[] stirling(double t[][]){

  // funkcja zwraca wartości f'(z) i f''(z) gdzie z jest elementem centralnym (tutaj t[2][0])
  // tablica 't' musi byćć uprzednio centralnie zainicjowana, jej poprawność nie jest sprawdzana!
 
	 double [] res= new double [2];
  double h=(t[4][0]-t[0][0])/(double)(N-1);  // krok argumentu 'x'
  
  for(int j=2; j<=N; j++)
	   for(int i=0; i<=N-j; i++)
	      t[i][j]=t[i+1][j-1]-t[i][j-1];
  	      res[0]=((t[1][2]+t[2][2])/2.0-(t[0][4]+t[1][4])/12.0)/h; // f'
	      res[1]=(t[1][3]-t[0][5]/12.0)/(h*h); 		  // f''
  return res;
 }

public static void main(String[] args) {
 double [] f = new double [2];
 double t[][]={
		 {0.8, 4.80, 0, 0, 0, 0}, // pary (x[i], y[i]) dla y = 5x2+2x
		 {0.9, 5.85, 0, 0, 0, 0}, // (wpisane są w dwie pierwsze kolumny)
		 {1,   7.00, 0, 0, 0, 0},
		 {1.1, 8.25, 0, 0, 0, 0},
		 {1.2, 9.60, 0, 0, 0, 0}
		};
  f=stirling(t);
  System.out.println("y=5x*x+2*x  f'=" + f[0] + ", f''=" + f[1] );
 }
}
