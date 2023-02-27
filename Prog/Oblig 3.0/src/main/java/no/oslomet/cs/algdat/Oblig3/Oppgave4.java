package no.oslomet.cs.algdat.Oblig3;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class Oppgave4 {
    public static void main(String[] args) {
        Integer[] a = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};
        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) { tre.leggInn(verdi); }
        String s =  tre.toStringPostOrder();
        System.out.println(s);

        //Denne lambda-funksjonen skriver ut mellomrom før nodens verdi.
        AtomicReference<String> postorden = new AtomicReference<>();
        Oppgave<Integer> oppgave = c -> postorden.set(postorden.get() + " " + c.toString()) ;

        //Test at postorden fungerer
        postorden.set("");
        tre.postorden(oppgave);
        System.out.println(postorden.get());

        //Test at rekursiv postorden fungerer
        postorden.set("");
        tre.postordenRecursive(oppgave);
        System.out.println(postorden.get());
    }
}
