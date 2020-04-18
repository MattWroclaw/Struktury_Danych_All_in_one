class OdwrocTab {
    
static void odwroc(int tab[], int left, int right){
int tmp;
if(left<right){  // zamieniamy elementy skrajne:
   tmp = tab[left];
   tab[left]=tab[right];
   tab[right]=tmp;
   odwroc(tab, left+1, right-1); // odwracamy resztę
 }
}


 public static void main(String[] args) { // wywołujemy algorytm
  int tabl[]={1,2,3,4,5,6,7,8,9};
  System.out.print("Przed: ");
  for(int i=0;i<tabl.length;i++)
	System.out.print(tabl[i] + "  "); System.out.println();
   odwroc(tabl, 0, tabl.length-1);
   System.out.print("Po   : ");
   for(int i=0;i<tabl.length;i++)
     System.out.print(tabl[i] + "  ");
   System.out.println();
 }
}
