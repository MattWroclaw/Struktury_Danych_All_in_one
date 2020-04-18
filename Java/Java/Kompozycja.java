import MojeTypy.GrafTabl;
 
class Kompozycja{
		
 public static void main(String[] args) {
  GrafTabl G1 = new GrafTabl (5, "G1");
  GrafTabl G2 = new GrafTabl (5, "G2");
  GrafTabl G =  new GrafTabl (5, "G = kompozycja G1 i G2");
  
  G1.add(1, 0, 1); G1.add(0, 2, 1); G1.add(3, 2, 1); G1.add(1, 3, 1); G1.add(4, 3, 1); G1.add(1, 4, 1);
  G2.add(4, 0, 1); G2.add(0, 1, 1); G2.add(2, 1, 1); G1.add(4, 2, 1); G1.add(1, 3, 1); G1.add(3, 3, 1);
  G1.wypisz();
  G2.wypisz();
  G.kompozycja (G1, G2);
  G.wypisz();
 }
}
