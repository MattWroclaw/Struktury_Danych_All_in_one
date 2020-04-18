public class Palindrom {

    static void palindrom(String s) {
        int dl = s.length();
        int cpt = 0;
        boolean test = true; //  's' jest (na razie) palindromem
        while ((cpt <= dl / 2) && (test == true))
            if (s.charAt(cpt) == s.charAt(dl - cpt - 1))
                cpt++;
            else
                test = false;
        System.out.print(s);
        if (test == true)
            System.out.print(" ...jest palindromem\n");
        else
            System.out.print(" ...jest zwykłym słowem...\n");
    }

    public static void main(String[] args) {
        palindrom("ab");
        palindrom("a");
        palindrom("abba");
        palindrom("abkba");
        palindrom("abkca");
    }
}	 