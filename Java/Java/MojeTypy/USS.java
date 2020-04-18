// Typy pomocnicze zgrupowalem w katalogu MojeTypy (=nazwa pakietu)

package MojeTypy; // USS dodamy jako nowy typ do biblioteki

public 	class USS	{
  static final int ROZM=29;   // Zmienna klasowa, rozmiar alfabetu
	USS  t[];
	
  public USS () { // Konstruktor
			t=new USS[ROZM];
  }	

 private int do_indeksu(char c) { // znak ASCII -> indeks
 if ( (c<='Z') && (c>='A') || (c<='z') && (c>='a') )
		return Character.toUpperCase(c)-'A'; // zwraca 0... 25 dla liter a/A... z/Z
 else{
     if (c==' ')  return 26;
     if (c=='-')  return 27;
     };
 return 99; // umowny kod błędu (nierozpoznany indeks)
}

private char z_indeksu(int n) { // indeks -> znak ASCII
 if ( (n>=0)  &&  (n<= ('Z'-'A')) )
	return (char)(n + 'A');
 else {
      if (n==26) return ' ';
      if (n==27) return '-';
      }
 return '@'; // umowny kod błędu (nierozpoznany znak)
}

public void zapisz(String slowo){
 USS p, q; // zmienne pomocnicze pozwolą nam nawigować po drzewie wskazywanym przez obiekt this
 p=this;
 int pos;
 System.out.println ("Dodaję słowo:[" + slowo + "]. ");
 for (int i=1; i<=slowo.length(); i++) {
   pos=do_indeksu(slowo.charAt(i-1));
   if (p.t[pos] != null) p=p.t[pos];
	 else{
 	     q=new USS();
 	     p.t[pos]=q;
	     for (int k=0; k<ROZM; q.t[k++]=null);
	     p=q;
	     }
   }
  p.t[ROZM-1]=p; 	// pętla jako koniec słowa
 }
 
public void pisz_slownik(){
 for (int i=0; i<26; i++)
 	if (this.t[i] != null) {
	 if ( (this.t[i]).t[ROZM-1]==this.t[i])     	
		System.out.print(z_indeksu(i)+" \n"); // gdy koniec słowa to pisz znak końca linii
	else
	   System.out.print(z_indeksu(i));
	   System.out.print("---");	   // aby ładniej wyglądało na konsoli tekstowej
	   (this.t[i]).pisz_slownik(); // wypisz rekurencyjnie resztę
	}
}

public void szukaj(String slowo) { // wyszukuje słowo w drzewie (słowniku)
 int test=1, i=0;
 USS p=this; // zmienna pomocnicza pozwoli nawigować po drzewie wskazywanym przez obiekt this
 System.out.print ("Szukane słowo:[" + slowo + "]. ");
 while ((test==1) && (i<slowo.length() ) )
  if (p.t[ do_indeksu(slowo.charAt(i)) ]==null) 
       test=0; // brak odgałęzienia, słowa nie ma!
   else 
       p=p.t[do_indeksu(slowo.charAt(i++))]; // szukamy dalej
 if ( (i==slowo.length() ) && (p.t[ROZM-1]==p) && (test==1))
	System.out.println("Słowo znalezione!");
 else  
    System.out.println("Słowo nie zostało znalezione w słowniku");
 }

};