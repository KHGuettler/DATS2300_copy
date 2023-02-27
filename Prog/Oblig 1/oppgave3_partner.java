import java.util.Arrays;
import java.util.Random;

public class oppgave3_partner {

    public static int[] permDupes(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
        }

        return a;
    }

    public static int antallUlikeUsortert(int[] a) {

        // Arrayet kan ikke være tomt;
        if (a.length == 0) {
            return 0;
        }

        // Setter variabel for å holde antall.
        int antall = 0;

        // Itererer gjennom arrayet.
        for (int i = 0; i < a.length; i++) {

            // Setter en variabel for å sjekk om et tall er unikt.
            boolean unik = true;

            // Itererer over det halvåpne intervallet [0:i>.
            // Dette gjøres for å sjekke om verdien i a[i] finnes tidligere i tabellen.
            for (int j = 0; j < i; j++) {
                // Hvis verdien av a[j] og a[i] er
                // like går vi ut av denne løkken;
                if (a[i] == a[j]) {
                    unik = false;
                    break;
                }
            }
            // Øker antall med en hvis tallet er unikt.
            if (unik) {
                antall++;
            }
        }
        // Returnerer antallet;
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
