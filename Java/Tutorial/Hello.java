
class Hello { // Początek definicji klasy Hello
  public static int mnozenie (int x){ // Metoda o nazwie mnozenie podwaja argument wejściowy
    return x*2;
  }

  public static void main(String[] args) { // Argumenty wywołania programu
    System.out.println("Witam serdecznie!");
    for (int i = 0; i < args.length; i++){
       System.out.println("i="+i+", Parametr["+i+"]="+args[i] + " i*2=" + mnozenie(i) );
    }
    
    // System.out.println("Bar \"Blue Oyster\"");
    
    
  }
}// Koniec definicji klasy Hello