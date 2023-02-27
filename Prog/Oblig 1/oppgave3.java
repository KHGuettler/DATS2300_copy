import java.util.Arrays;
import java.util.Random;

public class oppgave3 {

    public static int[] permDupes(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
        }

        return a;
    }


    public static int antallUlikeUsortert(int[] a) {
        // Initialiserer variabelen som holder antallet.
        int antall = 0;

        // Iterer over tabellen.
        for (int i = 0; i < a.length; i++) {
            // For hver iterasjon settes en boolean variabel til true. 
            boolean unik = true;
            // Itererer over det halvåpne intervallet [0:i>.
            // Dette gjøres for å sjekke om verdien i a[i] finnes tidligere i tabellen.
            for (int n = 0; n < i; n++) {
                // Hvis verdien i a[i] er like verdien i a[n], settes unik-variabelen til false, og løkken brytes.
                if (a[i] == a[n]) {
                    unik = false;
                    break;
                }
            }
            // Hvis unik ikke er satt til false, økes antall med 1.
            if (unik) {
                antall++;
            }
        }

        return antall;
    }

    public static void main(String[] args) {
        /** 
        for (int i = 0; i < 100; i++) {
            int[] values = permDupes(1000);
            int res = antallUlikeUsortert(values);
            System.out.println(Arrays.toString(values));
            System.out.println("Antall : " + res + "\n***");
        }
        int[] tom = {};
        */
        int[] values = {6, 2, 4, 6, 9, 1, 4, 9, 10};

        System.out.println(antallUlikeUsortert(values));
    }
}
