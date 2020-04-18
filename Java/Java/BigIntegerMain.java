import java.math.BigInteger;

public class BigIntegerMain{
 public static void main(String[] args){
  long maxLong=9223372036854775807L; // zwróć uwagę na literkę L na końcu
  System.out.println("Maksymalna wartość 'long' =    " + maxLong);
  maxLong = maxLong + 1;
  System.out.println("Maksymalna wartość 'long'+1 = " + maxLong + "(przekroczenie zakresu i przewinięcie na początek - do wartości minimalnej!)");
  BigInteger x = new BigInteger("9223372036854775807");
  BigInteger y = new BigInteger("5");
  BigInteger z = x.multiply(y);
  System.out.println("BigInteger 9223372036854775807 x 5 = " + z.toString());
 }
}
