class Newton{
 final static double epsilon=0.0001;

 static double f(double x){  // funkcja f(x) = 3x2 – 2
  return 3*x*x-2;
 }
 static double fp(double x){  // pochodna f'(x) = (3x2 – 2)' = 6x
   return 6*x;
 }

 static double zero(double x0){
	 if( Math.abs( f(x0) ) <epsilon) // abs - wartość absolutna (bez znaku)
	return x0;
  else 
	return zero( x0 - f(x0) / fp(x0) );
 }

 public static void main(String[] args) {
  System.out.println("Zero funkcji 3x*x-2 wynosi " +  zero(1) ); // wynik 0.8164965986394558
 }
}
	
	
	
	
