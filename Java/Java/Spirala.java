import java.awt.*;
import javax.swing.*;

public class Spirala extends Canvas { 
// prostokatny komponent  pozwalający na rysowanie i przechwytywanie zdarzeń
// do rysowania wykorzystamy mozliwosci klasy bazowej Canvas    
 
  int alpha=10; // odstęp pomiędzy liniami

  public void rysuj_spirala(int lg, int x, int y){ // właściwy algorytm rysujący spiralę
    Graphics gc=this.getGraphics();// pobierz kontekst graficzny
    if (lg>0) {
      gc.drawLine(x, y, x+lg, y);
      gc.drawLine(x+lg, y, x+lg, y+lg);
      gc.drawLine(x+lg, y+lg, x+alpha, y+lg);
      gc.drawLine(x+alpha, y+lg, x+alpha, y+alpha);
      rysuj_spirala(lg-2*alpha, x+alpha, y+alpha);
    }    
}
 // Nadpisując metodę paint możemy samodzielnie coś narysować
  public void paint(Graphics graphics) {
    int szer=this.getWidth(); // szerokość komponentu
    // Narysujmy spiralę poczynajac od punktu (15, 15), tak, aby zajęła większą część obszaru okna
    rysuj_spirala(szer-50, 15, 15);
   }


public static void main(String[] args) { // wywołujemy algorytm
 // tworzymy obiekt klasy Spirala w formie płótna do rysowania
 Spirala s = new Spirala();
 // Tworzymy okno aplikacji
 JFrame f = new JFrame("Spirala rekurencyjna"); 
 // W praktyce klasa JFrame jest zazwyczaj nadpisywana przez klasę użytkownika poprzez mechanizm 
 // dziedziczenia i poniższe komendy powinny być ukryte w konstruktorach lub metodach publicznych klasy:
 f.setLocation(300, 500); // pozycja okna
 f.setSize(400, 400);     // rozmiar okna
 // Zniszcz obiekt okna po zamknięciu okienka
 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
 f.getContentPane().add(s);
 f.setVisible(true); 
 }
}




