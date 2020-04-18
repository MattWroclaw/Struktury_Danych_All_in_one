class Simpson{
 final static int N=4; // liczba punktów= 2n+1

 static double simpson(double f[], double a, double b){
  // funkcja zwraca całkę funkcji f(x) w przedziale [a,b],  której wartości sa podane tabelarycznie w 2n+1 punktach
  double s=0,h=(b-a)/(2.0*N);
  for(int i=0; i<2*N; i+=2) // skok cp dwa punkty!
     s+=h*(f[i]+4*f[i+1]+f[i+2])/3.0;
  return s;
 }
 
 public static void main(String[] args) {
 double f[]={41, 29, 19, 11, 5, 1, -1, -1, 1};  // Tablica ma rozmiar 2*N+1
 System.out.println("Wartosc calki =" + simpson(f,-5,3) ); // 82.66666666666667
 }
}
