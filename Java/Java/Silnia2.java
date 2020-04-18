class Silnia2{
static long silnia(int x){ // silnia rekurencyjnie
if (x==0)
    return 1; 
else
    return x*silnia(x-1);
}
static  long silnia_it(int x) { // silnia iteracyjnie
 long wynik = 1;
 if(x == 0)
   return 1;
 else
   for(int i = 2; i <= x; i++)
        wynik = wynik *i;
 return wynik;
 }

public static void main(String[] args) { // wywołujemy algorytm
System.out.println("|-------------------------------|--------------------|");
System.out.println("|        i            silnia_rec            silnia_it|");
System.out.println("|-------------------------------|--------------------|");
 for (int i=0; i<20; i++)
  System.out.printf("Silnia( %2d)= %20d %20d\n", i, silnia(i), silnia_it(i));
 }
}


