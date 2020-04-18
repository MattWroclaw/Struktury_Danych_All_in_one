class WypiszAdresy{

public static void main(String[] args) {
  String s1=new String();
  String s2="Ala ma kota";
  System.out.println("s1="+s1+",s2="+s2);
  
  System.out.println("Adres s1=["+Integer.toHexString(System.identityHashCode(s1)) +"]");
  System.out.println("Adres s2=["+Integer.toHexString(System.identityHashCode(s2)) +"]");
  
  System.out.println("Teraz wykonujemy operację s1=s1+s2...:");   
  
  s1=s1+s2;

  System.out.println("s1="+s1+", s2="+s2);
  System.out.println("Adres s1=["+Integer.toHexString(System.identityHashCode(s1)) +"]");
  System.out.println("Adres s2=["+Integer.toHexString(System.identityHashCode(s2)) +"]");
  }
}
