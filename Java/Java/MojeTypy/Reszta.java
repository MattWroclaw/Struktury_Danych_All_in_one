package MojeTypy; // Typy pomocnicze zgrupowałem w katalogu MojeTypy (=nazwa pakietu)

public class Sterta{
  private int t[];
  private int L; // liczba elementów
		  
  public Sterta (int nMax) { // Konstruktor
	t=new int[nMax+1];
	L=0;
  }

  public void wstaw(int x){
    t[++L]=x;
	DoGory();
  }

  public int obsluz(){
   int x=t[1];
   t[1]=t[L--];   // brak kontroli błędów!!!
   NaDol();
   return x;
  }
 
 public void DoGory(){
  int temp=t[L], n=L;
  while((n!=1)&&(t[n/2]<=temp)) {
    t[n]=t[n/2];
	n=n/2;
  }
  t[n]=temp;
  }

 public void NaDol(){
  int i=1;
  while(true){
    int p=2*i;    	 // lewy potomek węzła 'i' to (p), prawy to (p+1)
	if(p>L) break;
	if(p+1<=L)             // prawy potomek niekoniecznie musi istnieć!
	  if(t[p]<t[p+1]) p++; //przesuwamy się do następnego
	  if(t[i]>=t[p]) break;
	  int temp=t[p];       // zamiana
	  t[p]=t[i];
	  t[i]=temp;
	  i=p;
    }
 }
  public void pisz(){
    int i=1;
    while(i<=L){
    for(int j=i; (j<=L) && (j<2*i); j++)
      System.out.print(t[j] + " "); 
      i*=2;
      System.out.println();
	 }
  }
}; // koniec definicji klasy Sterta

