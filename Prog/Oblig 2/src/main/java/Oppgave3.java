import no.oslomet.cs.algdat.Oblig2.*;

public class Oppgave3 {
    public static void main(String[] args) {
        // 3b) /////
        /* Integer[] values = {1, 3, 34 , 9};

        Liste<Integer> l1 = new DobbeltLenketListe<>(values);

        System.out.println("Original Verdi : " + l1.hent(3));
        
        System.out.println("Oppdaterer verdi : " + l1.oppdater(3, 18));
        
        System.out.println("Ny verdi : " + l1.hent(3)); */

        // 3b) /////
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};


        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3,8)); // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5)); // []
        System.out.println(liste.subliste(8,liste.antall())); // [I, J]
        // System.out.println(liste.subliste(0,11)); // skal kaste unntak

    }
}
