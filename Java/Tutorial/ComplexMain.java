// Kompiluj tylko ten plik: javac ComplexMain.java

import Piotr.PrzykladyDoNauki.*; // Tu znajdziesz definicje klasy Complex

class ComplexMain {

  public static void main(String[] args) {
    Complex x1= new Complex(5,3);
    Complex x2= new Complex(4,2);
    System.out.println("x1.res="+ (int)x1.Czesc_Rzecz()); 
    x1.pisz("x1=");
    x2.pisz("x2=");
    Complex x3= new Complex();
    x3=x3.dodaj(x1, x2);
    x3.pisz("x1+x2=");
    x3=x1.iloczyn(x2);
    x3.pisz("x1*x2=");
  }
}