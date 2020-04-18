
class Static {
  public static int mnozenie (int x){ // Metoda statyczna
    return x*2;
  }
  public static void main(String[] args) {
       System.out.println("Wywołuję metodę statyczną" + mnozenie(5) );
    }
  }