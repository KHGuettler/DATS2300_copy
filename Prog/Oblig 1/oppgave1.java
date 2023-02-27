import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class oppgave1 {

    public static int maks(int[] a) {
        
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen kan ikke være tom.");
        }

        for (int i = 0; i < a.length - 1; i++) {
            
            if (a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }

        return a[a.length - 1];
    }

    public static int ombyttinger(int[] a) {
        
        // Intitaliserer variabelen som holder antall ombytninger.
        int antall = 0;

        // Itererer gjennom tabellen.
        for (int i = 0; i < a.length - 1; i++) {
            // For hvert element sjekkes det om det er større enn det neste i tabellen.
            if (a[i] > a[i+1]) {
                // Hvis dette er tilfellet går programmet inn i if-blokken.
                // Her byttes posisjonene til verdiene så den største kommer bakerst.
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                
                // Øker antall med 1 hvis det skjer en ombytting.
                antall++;
            }
        }
        // Returnerer antall.
        return antall;
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
        double antall = 0.0;
        int total = 0;

        for (int i = 0; i < 100; i++) {
            int[] rand = permDupes(10000);
            antall++;
            total += ombyttinger(rand); 
            
        }
        double res = total / antall;
        System.out.println(res);
    }
}