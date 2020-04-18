class Wybor {
  public static void main(String[] args) {
  char c = 'B';
  switch (c){
    case 'A': System.out.println("Znak A"); 
    case 'B': System.out.println("Znak B"); 
              break; // *
    default: 
	      System.out.println("Nieznany symbol");
   }

  }
}
