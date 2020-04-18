class Dobor{

  public static void main(String[] args) {
  int N=5;
  int nastepny[]={-1, -1, -1, -1, -1}; 	// zapamiętuje ostatni wybor,  na samym początku nastepny[-1 + 1] =0, pózniej
                                        // posuwamy się o 1 pozycję dalej podczas danego etapu wyboru

  int dobor[]={-1, -1, -1, -1, -1}; 	// rozwiązanie zadania

  int wybiera[][]={ 
		 	 {0,4,3,2,1},   /* A */
		 	 {1,0,4,2,3},   /* B */
		 	 {0,3,1,2,4},   /* C */
		 	 {3,4,0,1,2},   /* D */
		 	 {4,3,2,1,0}};  /* E */

		 // preferencje promotorów: lubi[i][0] = nr A na liście 'i',  lubi[i][1] = nr B na liście 'i' itd.

  int lubi[][]={ /* A B C D E */
		 	 {3,4,0,2,1},
		 	 {2,1,3,4,0},
		 	 {0,1,2,4,3},
		 	 {4,3,2,0,1},
		 	 {2,3,4,0,1}};

 int student, wybierajacy, promotor, odrzucony;
 
 for(student=0; student<N; student++) {
   wybierajacy=student;
   System.out.println("Wybierającym staje się " + (char)(wybierajacy +'A') );
   while(wybierajacy!=-1){
	 nastepny[wybierajacy]++;
	 promotor=wybiera[wybierajacy][nastepny[wybierajacy]];
	 System.out.println("-->próbuje on tematu (promotora) " + promotor);
	 if(dobor[promotor]==-1) {// promotor (i jego temat) jest wolny
	  	System.out.println("Temat (promotor) " +  promotor +  " był wolny i zostaje on przyznany studentowi " +  (char)(wybierajacy +'A'));;
	 	dobor[promotor]=wybierajacy;
	 	wybierajacy=-1;
	 } else
	    if(lubi[promotor][wybierajacy]<lubi[promotor][dobor[promotor]]){
	       odrzucony=dobor[promotor];
	 	   System.out.println("Promotor " + promotor + " porzuca swój aktualny wybór " + (char)(odrzucony +'A'));
	 	   System.out.println(" na rzecz " + (char)(wybierajacy +'A'));
	 	   dobor[promotor]=wybierajacy;
	 	   wybierajacy=odrzucony;
	 	   System.out.println("  --- Wybierającym staje się " + (char)(wybierajacy +'A'));;
	    }
   } // koniec while
  } // koniec for
 for(int i=0; i<N; i++)
  System.out.println("Promotor " +  i + ", student "  +  (char)(dobor[i]+'A') );
 }
}


