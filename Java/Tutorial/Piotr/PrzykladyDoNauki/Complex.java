package Piotr.PrzykladyDoNauki;

public class Complex {
  private double Re,Im; // atrybuty prywatne (reprezentacja liczby urojonej jako Re+i*Im)
  
  //private static int Licznik=0;

  public Complex(double x, double y){ // konstruktor klasy
	  Im=x;
	  Re=y;
	  // Licznik++;
   }
  
  public Complex(){ // alternatywny konstruktor klasy
	  Re=0; 
	  Im=0;
	  //Licznik++;
  }

  public double Czesc_Rzecz(){    // zwraca część rzeczywistą
	return Re; 
  } 
  public double Czesc_Uroj (){    // zwraca część urojoną
	return Im; 
  }

  // Teraz zrealizujemy operacje arytmetyczne dodawania i mnożenia
  // x1=a+b*i  x2=c+d*i 
  // x1+x2= (a+c)+i*(b+d)
  public Complex dodaj (Complex x1, Complex x2){    // Zwraca sumę dwóch liczb zespolonych
    Complex res = new Complex (x1.Im+x2.Im, x1.Re+x2.Re);
    return res;
  }
  
  // x1=a+b*i  x2=c+d*i 
  // x1*x2= (ac-bd)+i*(ad+bc)
  public Complex iloczyn (Complex x2){    //  zwraca iloczyn dwóch liczb zespolonych (x1=this, ten sam obiekt)*x2 (parametr)
    Complex res = new Complex (this.Im*x2.Im-this.Re*x2.Re, this.Im*x2.Re+this.Re*x2.Im);
    return res;
 }
  
  public void pisz(String s) { // prosta funkcja wyświetlająca liczbę w formacie tekstowym [a+i*b] plus pewien komentarz 's'
   System.out.println(s+"["+(int)this.Im+"+i*"+(int)this.Re+"]");
  // System.out.println("Licznik=" + Licznik);
   
  }  
}