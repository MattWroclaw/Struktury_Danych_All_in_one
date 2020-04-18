import MojeTypy.Stos;

class Wyrazenie{     // właściwe drzewo binarne zapamiętujące wyrażenia arytmetyczne
	  public double val; // wartość
	  public char op;    // operator, niech wpis '0' tutaj  oznacza, że węzeł przechowuje 
	                     // wartość a nie operator arytmetyczny  
	  public Wyrazenie lewy, prawy; // potomkowie węzła pełniącego funkcję operatora 
	  
	  public Wyrazenie() { // prosty konstruktor
		  lewy=null; 
		  prawy=null;
	  } 

 public void pisz_prefix(){	// funkcja wypisuje wyrażenie w postaci prefiksowej
	 if(this.op=='0') // wartość liczbowa...
		 System.out.print(this.val + " ");
	  		 else{
	  		  System.out.print(this.op + " ");
	  		  this.lewy.pisz_prefix();
	  		  this.prawy.pisz_prefix();
		   }
	}
 
 public void pisz_infix(){	// funkcja wypisuje wyrażenie w postaci infiksowej
	 if(this.op=='0') // wartość liczbowa...
		 System.out.print(this.val + " ");
	  		 else{
	  		  System.out.print("(");
	  		      this.lewy.pisz_infix();
	  		           System.out.print(this.op);
	  		      this.prawy.pisz_infix();
	  		  System.out.print(")");
		   }
  }
 
 public boolean poprawne(){ // czy wyrażenie jest poprawne składniowo?
	 if(this.op=='0') 
	 	return true; // Według naszej konwencji jest to liczba, więc akceptujemy
	 switch (this.op)	{ // sprawdzimy teraz operator, czy jest nam znany
		  case '+':  //
		  case '-':  //
		  case '*':  // to są znane operatory
		  case ':':  // 
		  case '/': 
			  	return ( (this.lewy).poprawne() && (this.prawy).poprawne()); 
		  default :
			    return false;  // błąd,  nieznany operator lub inny błąd
	 }
	 
 }

public double oblicz(){
	 if(this.poprawne()) 			   // wyrażenie poprawne?
	 	if (this.op=='0') 
	 		return (this.val); 			// pojedyncza wartość
	 	 else
	 	  switch (this.op) {
	 	    case '+': return (this.lewy).oblicz()+(this.prawy).oblicz();
	 		case '-': return (this.lewy).oblicz()-(this.prawy).oblicz();
	 		case '*': return (this.lewy).oblicz()*(this.prawy).oblicz();
	 		case ':':
	 		case '/':if ( (this.prawy).oblicz()!= 0)
	 					return ((this.lewy).oblicz()/(this.prawy).oblicz());
	 				 else {
	 					   System.out.println("\nDzielenie przez zero!");
	                        return -1; // Uproszczona sygnalizacja błędów
	                  }
	       }
	     else 
	    	 System.out.println("Błąd składni");
	         return -1; // Uproszczona sygnalizacja bledow
	 }
 
 
}
public class WyrazeniaMain {
	
public static void main(String[] args) {    
 double[] wart= {2  , 3 , 0 , 7 ,9  ,0  , 0 , 12.5, 0 };
 char[]   oper= {'0','0','+','0','0','*','+','0'  ,'*'};
 Stos <Wyrazenie> s=new Stos<Wyrazenie>();// Stos roboczy do odkładania węzłów wyrażenia
 Wyrazenie w=null;
  
 for(int i=0;i<9;i++) {
    w=new Wyrazenie();
    if( (oper[i]=='*') || (oper[i]=='+') || (oper[i]=='-') || (oper[i]=='/')||(oper[i]==':'))
            w.op=oper[i]; 					
    else{
	  w.op='0'; // Umowna konwencja oznaczająca wartość, a nie operator
	  w.val=wart[i];;
	  }
  w.lewy =null;
  w.prawy=null;

 if( (oper[i]=='*') || (oper[i]=='+') || (oper[i]=='-') || (oper[i]=='/') || (oper[i]==':') ){
      Wyrazenie l1, p1;
      l1=s.pop();
      p1=s.pop();
      w.lewy =l1; // "Podwiązanie" pod węzeł x
      w.prawy=p1; // "Podwiązanie" pod węzeł x
   }
  s.push(w);
 }
 System.out.println("Prefiks:");  w.pisz_prefix(); 
 System.out.print(" Wynik:" +         w.oblicz());
 System.out.println("\nInfix:");   w.pisz_infix();   
 System.out.print(" Wynik:" +         w.oblicz());
 }
}
