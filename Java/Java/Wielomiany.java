class Wielomiany{

 static int oblicz_wielomian(int a, int w[]) { // metoda klasyczna, w zawiera współczynniki wielomianu
  int res=0, pot=1;
  for(int j=w.length-1;j>=0;j--){
	 res+=pot*w[j];  		// sumy czastkowe
 	 pot*=a; 			  	// następna potega a
 }
 return res;
 }

 static int oblicz_wielomian_H(int a, int w[]) { // schemat Hornera
  int res=w[0];
  for(int j=1; j<w.length; res=res*a+w[j++]);
 return res;
 }
 
 static void dodaj_wiel(int x[], int y[], int z[]){ // zakładamy te same rozmiary
  for(int i=0; i<x.length; i++)
	  z[i]=x[i]+y[i];			// wielomian z=x+y
  }

 static void mnoz_wiel(int x[], int y[], int z[]){   //z= x * y
  int i,j;
  for(i=0; i<x.length+y.length-1; i++)
	z[i]=0;						// zerowanie rezultatu
		for(i=0; i<x.length; i++)
	for(j=0; j<y.length; j++)
	    z[i+j]=z[i+j] + x[i]*y[j];
 }
 
 static void pisz(String s, int w[]) { 
      System.out.print(s + " ");
	  for(int i=w.length-1; i>=0; i--){ 
	   if (w[i]>=0 )
		   System.out.print(" + " + w[i]);
	   else
		   System.out.print(w[i]);
	   
	    if (i != 0) // stopień zero = wartość liczbowa 
	    	System.out.print("x^" + i);
	        if (i!=w.length-1)
	        	System.out.print(" ");
	     } 
	  System.out.println();
 }
 

 public static void main(String[] args) {
  int w[]={1, 4, -2, 0, 7}; 	// wspólczynniki wielomianu 7x^4+0x^3 -2x^2 +4x^1 +1
  pisz("w = ", w);
  System.out.println ( "Klasycznie w(2) = " + oblicz_wielomian(2, w) );
  System.out.println ( "Horner w(2) = "     + oblicz_wielomian_H(2, w) );
  
  int a[]={3, 3, 0, 5}; 	
  pisz("a = ",a);
  int b[]={2, 3, 1};
  pisz("b = ", b);
  int c[] = new int [a.length+b.length-1];
  mnoz_wiel(a, b, c);
  pisz("a*b = ", c);
 }
}


