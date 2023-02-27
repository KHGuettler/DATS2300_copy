import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class oppgave4_partner_2 {
    ///// Oppgave 4 //////////////////////////////////////

    ///// Hjelpemetoder /////

    // Kompendie : Programkode 1.1.8 d)
    private static void bytt(int[] a, int i, int n) {
        int temp = a[i];
        a[i] = a[n];
        a[n] = temp;
    }

    // Kompendie : Programkode 1.3.9 a)
    public static int parter(int[] a, int venstre, int høyre, int skille) {
        while (true) {
            while (venstre <= høyre && a[venstre] < skille) {
                venstre++;
            }

            while (venstre <= høyre && a[høyre] >= skille) {
                høyre--;
            }

            if (venstre < høyre) {
                bytt(a, venstre++, høyre--);
            }

            else {
                return venstre;
            }
        }
    }

    // Kompendie : Programkode 1.3.9 f)
    public static int sorterParter(int[] a, int venstre, int høyre, int indeks) {
        bytt(a, indeks, høyre);
        int pos = parter(a, venstre, høyre-1, a[høyre]);
        bytt(a, pos, høyre);
        return pos;
    }

    // Kompendie : Programkode 1.3.9 h)
    public static void kvikkSortering(int[] a, int venstre, int høyre) {
        if (venstre >= høyre) {
            return;
        }
        
        int pivot = sorterParter(a, venstre, høyre, (venstre + høyre) / 2);
        kvikkSortering(a, venstre, pivot - 1);
        kvikkSortering(a, pivot +1, høyre);
    }

    public static void delsortering(int[] a) {

        // Gjør ingenting hvis listen er på lengde 0 eller 1.
        if (a.length == 0 || a.length == 1) {
            return;
        }

        // Definerer intervallet for tabellen(venste & høyre-side);
        int left = 0;
        int right = a.length - 1;

        while(true) {
            // Tar modulus for å finne ut om tallet ved venstre-index er oddetall;
            while (left < a.length - 2 && Math.abs(a[left] % 2) == 1) {

                // Hvis ja, øker vi venstre med 1;
                left++;
            }

            // Tar modulus for å finne ut om tallet ved høyre-index er partall;
            while (right > 0 && a[right] % 2 == 0) {

                // Hvis ja, minker vi høyre med 1;
                right--;
            }

            // Plasserer oddetallene på venstre siden av tabellen;
            if (left < right) {
                bytt(a, left, right);
            }
            else {
                break;
            }
        }

        kvikkSortering(a, 0, right);
        kvikkSortering(a, left, a.length-1);
    }


    public static int[] permDupes(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
        }

        return a;
    }
     
    public static void main(String[] args) {
        /**
        int[] values = {0,0,0};
        delsortering(values);
        System.out.println(Arrays.toString(values));
        */

        long starttid = System.currentTimeMillis();
        int[] values = permDupes(1000000);
        delsortering(values);

        System.out.println(System.currentTimeMillis() - starttid);
        
        
    }
}
