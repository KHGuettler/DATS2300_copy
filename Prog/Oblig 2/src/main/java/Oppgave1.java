import java.util.Arrays;

import no.oslomet.cs.algdat.Oblig2.*;

public class Oppgave1 {
    public static void main(String[] args) {
        Integer[] values = {null, 1, 2, 3, null, null, null};

        Liste<Integer> i_liste = new DobbeltLenketListe<>(values);

        int antall_not_null = 0;
        for (Integer i : values) {
            if (i != null) {
                antall_not_null++;
            }
        }


        System.out.println("Antall ikke Null : " + antall_not_null + "  Verdier : " + Arrays.toString(values) + "  Lengde : " + values.length);

        System.out.println("Antall : " + i_liste.antall() + "  Endringer : " + i_liste.antall());

        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> s_liste = new DobbeltLenketListe<>(s);
        System.out.println(s_liste.antall() + " " + s_liste.tom());
    }
}
