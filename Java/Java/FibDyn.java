class FibDyn{ 

 static long fib(int x){
  if (x<2) 
	return x; 
  else
   return fib(x-1)+fib(x-2);
  }

 static void fib_dyn(int x, long f[]){
  f[0]=0;
  f[1]=1;
  for(int i=2; i<x; i++)
	 f[i]=f[i-1] + f[i-2];
  }

 public static void main(String[] args) {
 int N=50;
 long f[] = new long[N];
 fib_dyn(N,f); // oblicza N-1 kolejnych elementów ciągu Fibonacciego
 for(int i=0;i<N;i++)
 System.out.println("fib(" + i + ")=" + fib(i) + "\t fib_dyn(" + i + ")=" +  f[i]) ;
 }
}



