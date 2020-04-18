class OperacjeBitowe {
	
  public static final byte OPCJA_1=1; // 0001
  public static final byte OPCJA_2=2; // 0010
  public static final byte OPCJA_3=4; // 0100
  public static final byte OPCJA_4=8; // 1000

  static void showbits(char s){            // funkcja pokazuje reprezentację binarną znaku
	  char wagi[]={1,2,4,8,16,32,64,128};  //  maska bitu wagi
	  for(int i=7; i >= 0; i--) {
		int bit = (wagi[i] & s);
		if (bit !=0 ) 
		  	System.out.print("1"); 
		else 
		    System.out.print("0");
		}
	  }


public static void main(String[] args) { // ilustracja operacji bitowych w Javie
 System.out.print("i\tbinarnie\tprzes.w lewo\tnegacja\n");      
   for (int i=9; i<33; i++){
   System.out.printf(i+ "\t");
   showbits((char)i);  // reprezentacja binarna 
   System.out.print("\t");
	
   int j= i << 1;  showbits((char)j); // przesunięcie o 1 bit w lewo
   System.out.print("\t");
   int k= ~i;      showbits((char)k); // negacja bitowa    
   System.out.println(""); 
 }
 byte opcje = OPCJA_2 | OPCJA_3; // "właczenie" opcji 2 i 3, wynik: 0110, czyli 6
 System.out.print ((int)opcje + "\t");
 showbits((char)opcje);  // reprezentacja binarna
  
  /*
  int osemkowa =0116;
  System.out.print ("\n"+osemkowa); // wypisz 78, 0116(OCT)=(78)DEC
  
  int szesnastkowa=0x4E;
  System.out.print ("\n"+szesnastkowa); // wypisze 78, (4E)HEX=(78)DEC
  */
}
}
