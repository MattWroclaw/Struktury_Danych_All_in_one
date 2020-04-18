class WartFun{
	
 final static double epsilon=0.00000001;

 static double wart(double x, double yn){
	 double yn1=2*yn-x*yn*yn;
	   if( Math.abs(yn-yn1)<epsilon)  
		 return yn1;
	   else
		return wart(x,yn1);
	}
 
 public static void main(String[] args) {
  System.out.println("Wartość funkcji y=1/x dla x=7 wynosi " +  wart(7,0.1) ); // wynik: 0.142857
 }
}