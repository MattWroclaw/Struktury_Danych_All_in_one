class MinMax{

// --------------------------------------------------------------------------------------------
	static void min_max1(int t[], int wyniki[]) {  // zakładamy n >= 1
  wyniki[0]= wyniki[1]=t[0];
  
  for(int i=1; i< t.length; i++){
   if(wyniki[1]<t[i])            // (*)
	   wyniki[1]=t[i];
   if(wyniki[0]>t[i])            // (**)
      wyniki[0]=t[i];
  } 
}
// -------------------------------------------------------------------------------------------- 
 static void min_max2(int left, int right, int t[], int wyniki[]) {  // zakładamy n >= 1
  if (left==right)
	  wyniki[0]=wyniki[1]=t[left]; //jeden element
  else
	 if (left==right-1) // dwa elementy
	 	if(t[left]<t[right]){
	 		wyniki[0]=t[left];
	 		wyniki[1]=t[right];
	 	} else{
	 		  wyniki[0]=t[right];
	 		  wyniki[1]=t[left];
	 		  } 
	 else{
   		  int mid;
 	 	  int tmp_wyniki1[] = new int[2]; // tablica na tymczasowe wyniki min1, max1
   	      int tmp_wyniki2[] = new int[2]; // tablica na tymczasowe wyniki min2, max2
	 	  mid=(left+right)/2;
	 	  min_max2(left,  mid,    t, tmp_wyniki1);
	 	  min_max2(mid+1, right,  t, tmp_wyniki2);
	 	  if (tmp_wyniki1[0]<tmp_wyniki2[0]) // (1)
	 	   	wyniki[0]=tmp_wyniki1[0];
	 	  else 
	 		 wyniki[0]=tmp_wyniki2[0];
	 	  if(tmp_wyniki1[1]>tmp_wyniki2[1])  // (2)
	 			wyniki[1]=tmp_wyniki1[1];
	 	  else 
	 	     wyniki[1]=tmp_wyniki2[1];
	 	}
 }
//--------------------------------------------------------------------------------------------  
 

 public static void main(String[] args) {
  int wyniki[] = new int[2]; // wyniki[0]=MIN, wyniki[1]=MAX
  int tab[]    = {23, 12, 1,-5, 34,-7, 45, 2, 88, -3, -9, 1};
  for (int i=0; i< tab.length; i++)
	  System.out.printf("[" + tab[i] + "] ");
  System.out.println();;
  min_max1(tab, wyniki);
  System.out.println("Wersja 1: Min: " + wyniki[0] + ", Max: " + wyniki[1]);
  
  min_max2(0, tab.length-1, tab, wyniki);
  System.out.println("Wersja 2: Min: " + wyniki[0] + ", Max: " + wyniki[1]);
  }
}



