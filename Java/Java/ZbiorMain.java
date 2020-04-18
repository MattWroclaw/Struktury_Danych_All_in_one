import MojeTypy.ZbiorLitery;

public class ZbiorMain {


 public static void main(String[] args) {
  ZbiorLitery s1= new ZbiorLitery(), s2= new ZbiorLitery(); 
	 
  s1.dodaj('A'); s1.dodaj('B');s1.dodaj('C');
  s2.dodaj('B'); s2.dodaj('E');s2.dodaj('F'); 
  s2.dodaj('ę'); // To się nie uda  
  System.out.print ("Zbiór S1 =");
  s1.pisz();
	 
  System.out.print ("Zbiór S2 =");
	 
  s2.pisz();
  System.out.print ("Zbiór S1 = S1- 'C' ");
  s1.odejmij('C');
  s1.odejmij('X');  // to się nie uda
  System.out.print ("\nZbiór S1 =");

  s1.pisz();
  System.out.print ("Zbiór S3 = S1 + S2 = ");
  ZbiorLitery s3=new ZbiorLitery(s1, s2); // s3 utworzymy jako jako nowy obiekt ze zbiorów s1 i s2 
  s3.pisz();
 }
}