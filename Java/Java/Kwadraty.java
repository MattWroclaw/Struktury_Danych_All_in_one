// Kompilacja i użycie:
// javac Kwadraty.java
// java Kwadraty
import java.awt.*;
import javax.swing.*;
        
public class Kwadraty extends Canvas {
// prostokątny komponent  pozwalający na rysowanie i przechwytywanie zdarzeń
// Użyjemy możliwości klasy bazowej Canvas
 public void rysuj_kwadraty (int n, int lg,  int x,  int  y){// Algorytm rysujący kwadraty
// n musi być parzyste
    Graphics gc=this.getGraphics();// pobierz kontekst graficzny
    if (n>0) {
	  gc.drawLine(x, y, x+lg,y);
      gc.drawLine(x+lg,y, x+lg,y+lg);
  	  gc.drawLine(x+lg,y+lg, x,y+lg);
      gc.drawLine(x,y+lg, x,y+lg/2);
 	  gc.drawLine(x,y+lg/2, x+lg/2,y+lg);
      gc.drawLine(x+lg/2, y+lg, x+lg,y+lg/2);
      gc.drawLine(x+lg, y+lg/2, x+lg/2,y);
      gc.drawLine(x+lg/2, y, x+lg/4,y+lg/4);
	  rysuj_kwadraty(n-1,lg/2, x+lg/4,y+lg/4);
  	  gc.drawLine(x+lg/4, y+lg/4, x,y+lg/2);
	  gc.drawLine(x,y+lg/2, x,y);
	}
}

// Nadpisując metodę paint możemy samodzielnie coś narysować
    public void paint(Graphics graphics) {
     int szer=this.getWidth(); // szerokość komponentu
        // Narysujmy obiekt poczynajc od punktu (15, 15), tak, aby zajął większość obszaru okna
      rysuj_kwadraty(6, 380, 15, 15);
    }
// wywołujemy algorytm
public static void main(String[] args) {
 // tworzymy obiekt klasy Kwadraty w formie płótna do rysowania
 Kwadraty kw = new Kwadraty();
 // Tworzymy ono aplikacji
 JFrame f = new JFrame("Kwadraty rekurencyjne"); 
  // w praktyce klasa JFrame jest zazwyczaj nadpisywana przez klasę użytkownika poprzez mechanizm
  // dziedziczenia i poniższe polecenia powinny być ukryte w konstruktorach lub metodach tej klasy

 f.setLocation(100, 100); // pozycja okna
 f.setSize(450, 450);     // rozmiar okna
 // Zniszcz obiekt okna po zamknięciu okna
 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
 f.getContentPane().add(kw);
 f.setVisible(true); 
 }
}




