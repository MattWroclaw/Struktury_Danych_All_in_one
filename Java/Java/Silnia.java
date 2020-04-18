class Silnia{

static long silnia(int x){
if (x==0)
    return 1; 
else
    return x*silnia(x-1);
}

static long silnia2( int x, long tmp){
if (x==0)  
    return tmp; 
else
    return silnia2(x-1, x*tmp);
}


public static void main(String[] args) { // wywołujemy algorytm
 
 System.out.println("|-------------------------|-----------|");
 System.out.println("|        i     silnia1      silnia2   |");
 System.out.println("|-------------------------|-----------|");
 for (int i=0; i<15; i++)
  System.out.printf(" Silnia(%2d)= %12d %12d\n", i, silnia(i), silnia2(i,1));
 }
}


