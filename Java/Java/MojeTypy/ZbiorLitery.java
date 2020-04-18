package MojeTypy; // Typy pomocnicze zgrupowalem w katalogu MojeTypy (=nazwa pakietu)

public class ZbiorLitery{
  private boolean [] zbior; // znaki A... Z

  public ZbiorLitery() {         // zerowanie zbioru w konstruktorze
	  zbior = new boolean[26];
     for(int i=0;i<26;i++)
         zbior[i]=false;
  }
  
  public ZbiorLitery (ZbiorLitery z1, ZbiorLitery z2)  { // tworzy nowy zbiór z dwóch innych zbiorów wejściowych
	 zbior = new boolean[26];
     if (z1!=null && z2!=null)
	     for(int i=0; i<25; i++)
	         zbior[i]=z1.zbior[i] || z2.zbior[i];
   }
   
  
  private int do_indeksu(char c) { // konwersja znaku na wartość 0... 25 dla liter z zakresu A... Z
	if ( (c>='A') && (c<='Z') || (c>='a') &&  (c<='z') )
	    return Character.toUpperCase(c)-'A'; // Zamiana na dużą literę realizowana przez Character.toUpperCase(char)
	else
		return -1; // błąd zakresu (znak spoza alfabetu)
  }
	  
  public void dodaj (char c)  { // dodaj znak 'c' do zbioru
	  int i = do_indeksu(c);
	  if ( i>=0 &&  i <26)
		  zbior[i]=true;
	  else
		  System.out.println ("[Błąd] Znak (" + c + ") spoza dozwolonego alfabetu");
  }
  
  public boolean nalezy(char c){   // czy 'c' należy do zbioru?
	  int i;
	  i= do_indeksu(c);
	  if ( i !=-1) 
		 return zbior[i];
	  else
		  return false;
  }
    
  public void odejmij (char c)  {	// usuń znak 'c' ze zbioru
	  int i;
	  i= do_indeksu(c);
	  if ( i != -1 )
		  if (zbior[i]==true)
		  	zbior[i]=false;
	  else
		  System.out.println ("\n[Błąd] Znak (" + c + ") nie należy do zbioru");
  }
  

 public void pisz(){			// wypisuje zawartość zbioru
  int i;
  System.out.print ("{ ");
  for(i=0; i<25; i++)
	  if(zbior[i]==true)  		// wypisz obecne element
          System.out.print ((char)(i + 'A') + " "); // konwersja indeksu 0... 25 na znaki A... Z
  if(i==0)
         System.out.println ("[Błąd] Zbiór pusty");
  System.out.print ("}\n");
 }

}; // koniec definicji klasy ZbiorLitery