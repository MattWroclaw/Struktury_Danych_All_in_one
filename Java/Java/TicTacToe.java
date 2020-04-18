import java.util.Scanner;

class POLE{ // pomocnicza struktura służąca do zwracania przez metodę MiniMax wartości złożonej (dwie wartości)
	  int val; 
	  int gracz;
	}

class KANDYDACI{ // pomocnicza struktura zapamiętująca możliwe kandydatury na następny ruch
	  int   cpt;
	  int   tbl[] = new int[9];
	};

class TicTacToe {

 enum KTO{nic, komputer, czlowiek}; // Plansza gry składa się z pól przyjmujących trzy wartości

 static final int plus_niesk  =  1000;
 static final int minus_niesk = -1000;
 
 static final int GLEBOKOSC_OK=2;
//-------------------------------------------------------------------------------------
static void wcisnijENTER(){
  Scanner keyIn = new Scanner(System.in);
  System.out.print("Naciśnij ENTER");
  keyIn.nextLine();
}
//-------------------------------------------------------------------------------------
static KTO Nastepny_Gracz(KTO gracz) {
if (gracz==KTO.komputer)
	return KTO.czlowiek;
else
	return KTO.komputer;
}
//-------------------------------------------------------------------------------------
static boolean WystarczajaGleboko(int p) { // Czy głębokość MiniMax jest OK
if (p==GLEBOKOSC_OK)
	return true;
else
	return false;
}

//-------------------------------------------------------------------------------------
 static void WyswietlPlansze(KTO plansza[]) {
	 for(int i=0;i<9;i++){
	  if ((i==3) || (i==6) || (i==9)) 
		  System.out.println();
	  switch(plansza[i]) {
		case nic     : System.out.print(" *  "); break;
		case komputer: System.out.print(" X  "); break;
		case czlowiek: System.out.print(" O  "); break;
	  }
	 }
}
//____________________________________________________________________
 static  void Zeruj(KTO plansza[]){ // zeruje teren gry
    for (int i=0;i<9;i++) 
    	plansza[i]=KTO.nic;
 }
 // ____________________________________________________________________
 static KANDYDACI Generuj(KTO plansza[]){ // generuje możliwe kandydatury następnego ruchu
  KANDYDACI t = new KANDYDACI();
  t.cpt=-1;
  for(int i=0;i<9;i++)
  if (plansza[i]==KTO.nic)
 	  t.tbl[++t.cpt]=i; // zapamiętanie wolnej pozycji
 return t;
 }
//-------------------------------------------------------------------------------------
 static int KoniecGry(KTO plansza[]) {
 boolean a,b,c,d,e,f,g,h;
  // sukces w linii?
  a=((plansza[0]==plansza[1])&&(plansza[1]==plansza[2]) && (plansza[0]!=KTO.nic));
  b=((plansza[3]==plansza[4])&&(plansza[4]==plansza[5]) && (plansza[3]!=KTO.nic));
  c=((plansza[6]==plansza[7])&&(plansza[7]==plansza[8]) && (plansza[6]!=KTO.nic));
  // sukces w kolumnie?
  d=((plansza[0]==plansza[3])&&(plansza[3]==plansza[6]) && (plansza[0]!=KTO.nic));
  e=((plansza[1]==plansza[4])&&(plansza[4]==plansza[7]) && (plansza[1]!=KTO.nic));
  f=((plansza[2]==plansza[5])&&(plansza[5]==plansza[8]) && (plansza[2]!=KTO.nic));
  // sukces na przekątnej
  g=((plansza[0]==plansza[4])&&(plansza[4]==plansza[8]) && (plansza[0]!=KTO.nic));
  h=((plansza[2]==plansza[4])&&(plansza[4]==plansza[6]) && (plansza[2]!=KTO.nic));
  // robimy to aby wiedzieć kto wygral:
  if (a) return 1;    
  if (b) return 3;
  if (c) return 6;
  if (d) return 3;
  if (e) return 4;
  if (f) return 5;
  if (g) return 4;
  if (h) return 4;
  //if (!(a||b||c||d||e||f||g||h)) 
  return 0;
 }
// -------------------------------------------------------------------------------------
 static boolean SprawdzCzyKoniecGry(KTO plansza[], KTO gracz) {
  if (KoniecGry(plansza)!=0) {
	WyswietlPlansze(plansza);
	System.out.println("\n  ** KONIEC GRY ** ");
	 if (gracz==KTO.czlowiek)
	     System.out.println(":) WYGRAŁEŚ, GRATULACJE!");
	 else
	   System.out.println(":-( WYGRAŁ KOMPUTER...");
	   wcisnijENTER();
	  return true;
  }
 KANDYDACI nastepni=Generuj(plansza);
    if (nastepni.cpt==-1) {
	 WyswietlPlansze(plansza);
	 System.out.println("\n  ** KONIEC GRY ** ");
	 System.out.println("Remis!");
	 wcisnijENTER();
	 return true; 
	}
 return false;
 }
// -------------------------------------------------------------------------------------
 static boolean LiniaPusta(int Line, KTO plansza[]) {
  return ((plansza[(Line-1)*3]==KTO.nic) && (plansza[(Line-1)*3+1]==KTO.nic) && (plansza[(Line-1)*3+2]==KTO.nic));
}
	// ____________________________________________________________________
 static boolean KolumnaPusta(int Col, KTO plansza[]){
  return ((plansza[Col-1]==KTO.nic) && (plansza[(Col-1)+3]==KTO.nic) && (plansza[(Col-1)+6]==KTO.nic));
}
// ____________________________________________________________________
 static boolean LiniaPelna(int Line, KTO plansza[]) {
  return !((plansza[(Line-1)*3]==KTO.nic) || (plansza[(Line-1)*3+1]==KTO.nic) || (plansza[(Line-1)*3+2]==KTO.nic));
}
// ____________________________________________________________________
 static boolean KolumnaPelna(int Col, KTO plansza[]) {
  return !((plansza[Col-1]==KTO.nic) || (plansza[(Col-1)+3]==KTO.nic) || (plansza[(Col-1)+6]==KTO.nic));
}
// ____________________________________________________________________
 static boolean Przekatna1_Pusta(KTO plansza[]) {
  return ((plansza[0]==KTO.nic) && (plansza[4]==KTO.nic) && (plansza[8]==KTO.nic));
}
// ____________________________________________________________________
 static boolean Przekatna1_Pelna (KTO plansza[]) {
  return !((plansza[0]==KTO.nic) || (plansza[4]==KTO.nic) || (plansza[8]==KTO.nic));
}
// ____________________________________________________________________
 static boolean Przekatna2_Pusta(KTO plansza[]) {
  return ((plansza[2]==KTO.nic) && (plansza[4]==KTO.nic) && (plansza[6]==KTO.nic));
}
// ____________________________________________________________________
 static boolean Przekatna2_Pelna (KTO plansza[]) {
  return !((plansza[2]==KTO.nic) || (plansza[4]==KTO.nic) || (plansza[6]==KTO.nic));
}
// -------------------------------------------------------------------------------------
 static int Ewaluacja(KTO plansza[], KTO gracz) {
	 int val=0;
	 int result=KoniecGry(plansza);
	 if (result!=0){
	   if (plansza[result]==Nastepny_Gracz(gracz))
		 return minus_niesk;   			// pozycja wygrywająca dla przeciwnika
	   else
		return  plus_niesk;    			// pozycja wygrywająca dla nas
	  }

	 for(int Line=1;Line<=3;Line++)
	  if (!(LiniaPusta(Line,plansza) || LiniaPelna(Line,plansza))) {
		 if ((plansza[(Line-1)*3]==Nastepny_Gracz(gracz)) || (plansza[(Line-1)*3+1]==Nastepny_Gracz(gracz)) || (plansza[(Line-1)*3+2]==Nastepny_Gracz(gracz)))
		 val-=1;
		 if ((plansza[(Line-1)*3]==gracz) || (plansza[(Line-1)*3+1]==gracz) || (plansza[(Line-1)*3+2]==gracz))
		 val+=1;
	  }
	 for(int Col=1;Col<=3;Col++)
	  if (!(KolumnaPusta(Col,plansza) || KolumnaPelna(Col,plansza))) {
		 if ((plansza[Col-1]==Nastepny_Gracz(gracz)) || (plansza[(Col-1)+3]==Nastepny_Gracz(gracz)) || (plansza[(Col-1)+6]==Nastepny_Gracz(gracz)))
		 val-=1;
		 if ((plansza[Col-1]==gracz) || (plansza[(Col-1)+3]==gracz) || (plansza[(Col-1)+6]==gracz))
		 val+=1;
	  }
	if (!(Przekatna1_Pusta(plansza)||Przekatna1_Pelna(plansza))) {
	  if ((plansza[0]==Nastepny_Gracz(gracz)) || (plansza[4]==Nastepny_Gracz(gracz)) || (plansza[8]==Nastepny_Gracz(gracz)))
	  val=val-1;
	  if ((plansza[0]==gracz) || (plansza[4]==gracz) || (plansza[8]==gracz))
	  val+=1;
	};

	if (!(Przekatna2_Pusta(plansza)||Przekatna2_Pelna(plansza))) {
	  if ((plansza[2]==Nastepny_Gracz(gracz)) || (plansza[4]==Nastepny_Gracz(gracz)) || (plansza[6]==Nastepny_Gracz(gracz)))
	  val-=1;
	  if ((plansza[2]==gracz) || (plansza[4]==gracz) || (plansza[6]==gracz))
	  val+=1;
	 };
	return val;
}
// -------------------------------------------------------------------------------------
static void WykonajRuch(KTO gracz, KTO plansza[], int ruch) {
   plansza[ruch]=gracz;
}
//-------------------------------------------------------------------------------------
static KTO NastepnyGracz(KTO gracz, int glebokosc) { // dla którego gracza wykonujemy ewaluację mini-max?
if ((glebokosc % 2) == 0)
	return gracz;
else
	return Nastepny_Gracz(gracz);
}
//-------------------------------------------------------------------------------------
static POLE MiniMax(KTO plansza[], int glebokosc, KTO gracz) {
 POLE res = new POLE();
 KANDYDACI nastepni;
 if (WystarczajaGleboko(glebokosc)) {// węzeł uznawany za położony dostatecznie gleboko 
  res.val=Ewaluacja(plansza, gracz);
  res.gracz=-1;
  return res;
 };

 nastepni=Generuj(plansza);

 if (nastepni.cpt==-1){	// wezel terminalny
  res.val=Ewaluacja(plansza, gracz);
  res.gracz=-1;
  return res;
  }

 int lepszy=minus_niesk;
 int gracz_1=-1; // dopisane z powodu ostrzeżenia kompilatora Javy o niezainicjowanej zmiennej
 for (int i=0; i<=nastepni.cpt;i++) {
  KTO plansza1[]=new KTO[9];
  for (int k=0;k<9;k++) 
 	 plansza1[k]=plansza[k];
  plansza1[nastepni.tbl[i]]=NastepnyGracz(gracz,glebokosc);
  POLE r = new POLE();
  r=MiniMax(plansza1,glebokosc+1,gracz);
  if (-r.val>lepszy) {
    lepszy=-r.val;
    gracz_1=nastepni.tbl[i];
  }
 }
 res.val=lepszy;
 res.gracz=gracz_1;
 return res;
}

//-------------------------------------------------------------------------------------
static boolean Zajete(KTO plansza[], int ruch) {// Pole wolne?
	 if (ruch==-1) 
		return true;
	 if (plansza[ruch] != KTO.nic)
		 return false;
	 else
		return true;
	}
//-------------------------------------------------------------------------------------
static int WybierzRuch(KTO gracz, KTO plansza[]) { // wybór ruchu zależy od tego, kto gra
 Scanner sc = new Scanner(System.in);
 int ruch;
		
 if (gracz==KTO.czlowiek)  // gra człowiek, musimy pobrać poprawny wybór (pole nie może być zajęte)
  do { // gracz kontra komputer
	 System.out.println("\n Twój wybór(0..8):");
	 while(!sc.hasNextInt()){
	   System.out.print("To mi nie wygląda na liczbe!");
	    sc.next();
	 }
	 ruch= sc.nextInt();
	 System.out.println("Wprowadzono " + ruch);
	 } while(!Zajete(plansza, ruch));
   else { // gra komputer
        POLE wybor=MiniMax(plansza, 0, gracz);
        ruch=wybor.gracz;
		System.out.println("\nMój ruch: " + ruch);
	    }
 return ruch;
 }
//-------------------------------------------------------------------------------------
static void Graj(KTO plansza[], KTO gracz){
 int ruch;
 boolean koniec=false;
 KTO gracz1=gracz;
 while(!koniec)  {
  WyswietlPlansze(plansza);
  ruch=WybierzRuch(gracz1, plansza);
  if (ruch!=-1)
	  WykonajRuch(gracz1, plansza, ruch);
  koniec = SprawdzCzyKoniecGry(plansza, gracz1);
  gracz1=Nastepny_Gracz(gracz1);
 }
}
// -------------------------------------------------------------------------------------
 public static void main(String[] args){
  int MiniMaxUsed;
  KTO gracz;
  KTO plansza[] = new KTO[9];
  System.out.println("Kodowanie pól planszy:");
  System.out.println(" 0 1 2\n 3 4 5\n 6 7 8\n");
  System.out.println("\nZaczynamy:\n\n");
  Zeruj(plansza);
  //gracz=KTO.komputer;
  gracz=KTO.czlowiek; // lub gracz=KTO.komputer — ten zapis wskazuje, kto zaczyna grę
  Graj(plansza, gracz);
  wcisnijENTER();
 }
}
