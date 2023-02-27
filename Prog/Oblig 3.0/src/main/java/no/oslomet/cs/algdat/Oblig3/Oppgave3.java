package no.oslomet.cs.algdat.Oblig3;

import java.util.Comparator;

public class Oppgave3 {
    public static void main(String[] args) {
        Integer[] a = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};
        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) { tre.leggInn(verdi); }
        String s =  tre.toStringPostOrder();
        System.out.println(s);
    }
}
