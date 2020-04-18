class Sdw {

static int StadDoWiecznosci(int n){
  if (n==1) 
    return 1; 
  else
   if ( (n%2)== 0 ) // n parzyste
	return StadDoWiecznosci(n-2)*n;
   else
	return StadDoWiecznosci(n-1)*n;
}

public static void main(String[] args) { //wywołujemy algorytm
  try {
     StadDoWiecznosci(2);
     } 
    catch (StackOverflowError e) 
    {System.out.println(e.toString());}
 }
}




