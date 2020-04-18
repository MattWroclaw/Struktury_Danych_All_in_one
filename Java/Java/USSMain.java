import MojeTypy.USS;

class USSMain {
	
public static void main(String[] args) {
 int i;
 String tresc;
 USS p=new USS(); // tworzymy nowy słownik i wpisujemy kilka haseł
 
 p.zapisz("alf"); p.zapisz("alfabet"); p.zapisz("alfabetycznie"); p.zapisz("anagram");
 
 p.zapisz("anonim"); p.zapisz("ASTRonoMIa"); p.zapisz("Ankara");
 
 p.pisz_slownik()	;    // wypisujemy słownik
 
 System.out.println();
 
 p.szukaj("anagram");
 p.szukaj("anagramy");
 p.szukaj("gra");
 p.szukaj("alf");
 p.szukaj("ALF");
 p.szukaj("dom");
 }
}



