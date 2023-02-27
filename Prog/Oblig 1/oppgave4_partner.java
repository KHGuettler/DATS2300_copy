import java.util.Arrays;
import java.util.Random;

public class oppgave4_partner {
    public static int[] permDupes(int n) {
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
        }

        return a;
    }

    public static void delsortering(int[] a) {

        // Gjør ingenting hvis listen er på lengde 1.
        if (a.length == 1) {
            return;
        }

        // Definerer intervallet for tabellen(venste & høyre-side);
        int left = 0;
        int right = a.length - 1;

        for (int i = 0; i < a.length; i++) {
            // Tar modulus for å finne ut om tallet ved 0.index er oddetall;
            while (left < a.length - 2 && Math.abs(a[left] % 2) == 1) {

                // Hvis ja, øker vi venstre med 1;
                left++;
            }

            // Tar modulus for å finne ut om tallet ved 0.index er partall
            while (right > 0 && a[right] % 2 == 0) {

                // Hvis ja, minker vi høyre med 1;
                right--;


            }

            // Plasserer oddetallene på venstre siden av tabellen;
            if (left < right) {
                System.out.println("Før bytt : " + Arrays.toString(a));
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                System.out.println("Etter bytt : " + Arrays.toString(a) + "\n");
            }
        }

        // Definerer første partelle som skillepunkt;
        int skille = 0;

        // Itererer til skillepunktet;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                skille = i;
                break;
            }
        }

        // Itererer til skillepunktet (gjennom oddetallene);
        for (int i = 0; i < skille; i++) {
            for (int j = i + 1; j < skille; j++) {

                // Sorterer de i stigende rekkefølge;
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        // Itererer fra skille til enden (gjennom partellene);
        for (int i = skille; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {

                // Sorterer i stigende rekkefølge;
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        //int[] values = {2, 4, 3, 1, 6, 8, 5};
        //delsortering(values);
        //System.out.println(Arrays.toString(values));
        


        
        for (int j = 0; j < 1; j++) {
            int[] values = {-4, -1, 3, 0, 2, -3, -2, 4, 1};
            delsortering(values);
            System.out.println(Arrays.toString(values));
        }
        
        
    }
    
}
