import java.util.Iterator;

import no.oslomet.cs.algdat.Oblig2.*;


public class Oppgave8 {
    public static void main(String[] args) {
        Integer[] values = {1, 2, 3,};

        DobbeltLenketListe<Integer> l1 = new DobbeltLenketListe<>(values);

        Iterator<Integer> d1 = l1.iterator();
        System.out.println(d1.next());
        System.out.println(d1.next());


        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        Liste<String> liste = new DobbeltLenketListe<>(navn);
        liste.forEach(s -> System.out.print(s + " "));
        System.out.println();
        for (String s : liste) System.out.print(s + " ");
        System.out.println();

    }
}
