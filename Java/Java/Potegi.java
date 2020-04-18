public class Potegi{ 

static long pot1(int x, int n) {
 if (n==0) 
  return 1; 
 else 
 return (pot1(x,n-1)*x);
}

static long pot2(int x, int n, long temp) {
 if (n==0) 
	return temp; 
 else
    return (pot2(x,n-1,temp*x));
}

public static void main(String[] args) { 
 for (int i=1; i<20; i++)
  for (int j=0; j<15; j++)
	  System.out.println (i + " do " + j + " potęgi=" + pot1(i,j) + " metoda 2:" + pot2(i,j, 1) );
 }
}






