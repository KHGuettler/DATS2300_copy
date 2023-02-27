package no.oslomet.cs.algdat.Oblig3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Oppgave5 {
    public static void main(String[] args) {
        /* Integer[] a = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};
        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
        for (int verdi : a) { tre.leggInn(verdi); }
        String s =  tre.toStringPostOrder();
        System.out.println(s);

        ArrayList<Integer> treListe = tre.serialize();

        System.out.println(treListe.toString());

        SBinTre<Integer> deSerialisert = SBinTre.deserialize(treListe, Comparator.naturalOrder());

        System.out.println(deSerialisert.toStringPostOrder()); */

        SBinTre<Integer> tre =
                new SBinTre<>(Comparator.naturalOrder());

        int[] a = {10, 14, 6, 8, 1, 12, 7, 3, 11, 9, 13, 5, 2, 4};
        for (int verdi : a) tre.leggInn(verdi);
        System.out.println(tre.toStringPostOrder());

        ArrayList<Integer> data = tre.serialize();
        System.out.println(data);

        Integer[] truth = {10, 6, 14, 1, 8, 12, 3, 7, 9, 11, 13, 2, 5, 4};
        System.out.println(Arrays.toString(truth));

        SBinTre<Integer> tre2 = SBinTre.deserialize(data, Comparator.naturalOrder());
        System.out.println(tre2.toStringPostOrder());
    }
}
