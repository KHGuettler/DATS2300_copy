import java.util.Arrays;
import java.util.Random;

public class Tabell {

    public static int maks(int[] a) {
        int length = a.length;

        if (length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom.");
        }

        int m = 0;
        int maksverdi = a[0];
        for (int i = 1; i < length; i++){
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        //System.out.print("Indeks : " + m + "\n" + "Verdi : " + maksverdi + "\n");
        return m;
    }

    public static int[] permDupes(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
        }

        return a;
    }

    public static int[] permUnique(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }

        return a;
    }

    public static int antallMaks(int[] a) {
        int antall = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                antall++;
                maksverdi = a[i];
            }
        }

        return antall;
    }

    public static void shuffle(int[] a) {
        Random r = new Random();

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void main(String[] args) {
        int[] testTabell = permDupes(10);
        int[] testTabellTo = permUnique(10);
        System.out.println(Arrays.toString(testTabell));
        maks(testTabell);
        System.out.println(Arrays.toString(testTabellTo));
        maks(testTabellTo);
        System.out.println(antallMaks(testTabellTo));
    }
}
