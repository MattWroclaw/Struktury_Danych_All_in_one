class KodyProste{

static void Xor(char  s[], char  xor_key) { // Metoda 1.
  for (int i=0; i< s.length; i++)
	 s[i]= (char) (s[i] ^ xor_key);
	 }

static void odejmij(char s[] ){				// Metoda 2.
for (int i=0; i < s.length; i++)
	s[i]=(char) (255-s[i]);
}

static void pisz(String komentarz, char s[] ){
	System.out.print(komentarz+ " ");
	for (int i=0; i< s.length; i++)
		  System.out.print ((char)s[i] + " ");
	  System.out.println();
}


 public static void main(String[] args) { 
  char []s1= "Ala ma kota".toCharArray();
  pisz("Oryginał: ", s1);
  Xor(s1, '#');
  pisz("Ciąg zakodowany XOR: ", s1);
  Xor(s1, '#');
  pisz("Ciąg odkodowany XOR: ", s1);
 
 
  char []s2= "Figo to pies".toCharArray();
  pisz("Oryginał: ", s2);
  odejmij(s2);
  pisz("Ciąg zakodowany 255: ", s2);
  odejmij(s2);
  pisz("Ciąg odkodowany 255: ", s2);
 }
}