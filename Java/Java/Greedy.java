class Greedy{ 

static final int n=3;

static void greedy(double M, double W[], double C[], double X[]) {
 int i;
 double Z=M; // pozostaje do wypełnienia
 for(i=0; i<n; i++){
   if(W[i]>Z)
     break;
   X[i]=1;
   Z=Z-W[i];
  }
  if(i<n)
	 X[i]=Z/W[i];
 }

 public static void main(String[] args) {
  double W[]={10, 12, 16};
  double C[]={60, 70, 80};
  double X[]={0,   0,  0};
  greedy(20,W,C,X);
  double p=0;
  for(int i=0; i<n; p=p+X[i]*C[i], i++)
      System.out.println(i + "\t" + W[i] + "\t" + C[i] + "\t" + X[i]);
 System.out.println("Razem: " + p);
 }
}