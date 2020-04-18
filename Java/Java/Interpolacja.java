class Interpolacja{
 final static double epsilon=0.0001;
 final static int N=3; // stopień wielomianu interpolującego
 
static double interpol(double z, double x[], double y[]) { // zwraca wartość funkcji w punkcie 'z'
  double wnz=0, om=1, w;
  for(int i=0; i<=N; i++) {
    om=om*(z-x[i]);
    w=1.0;
    for(int j=0; j<=N; j++)
 	if(i!=j) w=w*(x[i]-x[j]);
 		wnz=wnz+y[i]/(w*(z-x[i]));
   }
  return wnz=wnz*om;
 }
 
 public static void main(String[] args) {
  // Tabela wartości funkcji y[i] = f(x[i] (jest to w istocie funkcja y=sqrt(x):
  double x[]={3.0,    5.0,    6.0,    7.0}; 	// rozmiar: n+1
  double y[]={1.732,  2.236,  2.449,  2.646};
  double z=4.5;
  System.out.println("Wartość funkcji sqrt(x) w punkcie "+z+" wynosi "+interpol(z, x, y) );
 }
}
