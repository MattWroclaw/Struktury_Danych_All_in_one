import java.awt.*;
import javax.swing.*;

public class Ogrodzenie extends Canvas {
// prostokątny komponent  pozwalający na rysowanie i przechwytywanie zdarzeń
// wykorzystamy możliwości klasy bazowej Canvas
	
// algorytm rysujacy ogrodzenie
public void rysuj_wzorek(int n, int lg, int x, int y) { // n = liczba podziałów
 Graphics gc=this.getGraphics();// pobierz kontekst graficzny
 if (n>0){
 // kwadrat 
  gc.drawLine(x,    y,    x+lg, y);
  gc.drawLine(x+lg, y,    x+lg, y+lg);
  gc.drawLine(x+lg, y+lg, x,    y+lg);
  gc.drawLine(x,    y+lg, x,    y);
  // 4 kola wewnętrzne
  gc.drawOval(x,      y,      lg/2, lg/2);
  gc.drawOval(x+lg/2, y,      lg/2, lg/2);
  gc.drawOval(x,      y+lg/2, lg/2, lg/2);  
  gc.drawOval(x+lg/2, y+lg/2, lg/2, lg/2);
// wzorki w kołach wewnętrznych powielają schemat główny, ale w mniejszym rozmiarze
 rysuj_wzorek(n-1, lg/2, x,      y     );
 rysuj_wzorek(n-1, lg/2, x+lg/2, y     );
 rysuj_wzorek(n-1, lg/2, x,      y+lg/2);
 rysuj_wzorek(n-1, lg/2, x+lg/2, y+lg/2);
 }
}
// nadpisując metodę paint możemy samodzielnie coś narysować

public void paint(Graphics graphics) {
 int szer=this.getWidth(); // szerokość komponentu
 int wys=this.getHeight(); // szerokość komponentu
 // narysujmy obrazek poczynając od punktu (5,5), tak, aby zająć większą część obszaru okna
  rysuj_wzorek(3,szer-szer/10, 5, 5);
 }
// wywołujemy algorytm
public static void main(String[] args) {
 Ogrodzenie og = new Ogrodzenie();  // tworzymy obiekt klasy Ogrodzenie w formie płótna do rysowania
 JFrame f = new JFrame("Ozdobne ogrodzenie"); // Tworzymy ono aplikacji 
 // W praktyce klasa JFrame jest zazwyczaj nadpisywana przez 
 // klas użytkownika poprzez mechanizm dziedziczenia i poniższe komendy powinny 
 // być ukryte w konstruktorach lub metodach publicznych klasy.
 f.setLocation(100, 100); // pozycja okna
 f.setSize(500, 500);     // rozmiar okna
 // zniszcz obiekt po zamknięciu okna
 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
 f.getContentPane().add(og);
 f.setVisible(true); 
 }
}
