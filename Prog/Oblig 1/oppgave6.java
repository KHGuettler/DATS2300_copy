public class oppgave6 {
    
    public static void rotasjon(char[] a, int k) {

        // Hvis arrayet er lengde 0 eller 1, vil ikke rotasjoner noe, så metoden avsluttes.
        // Sjekker om k går nøyaktig opp i lengden på arrayet. 
        // HVis dette er tilfellet vil arrayet ende opp likt som ved start, så metoden avsluttes.
        if (a.length == 1 || a.length == 0 || k % a.length == 0) {
            return;
        }

        // Vi trenger ikke å rotere karakterer flere plasser enn det er plasser i arrayet.
        // Finner derfor en ny k-verdi ved modulus.
        k = k % a.length;

        // Gjør om negative k-verdier til positive, for å gjøre alle tilfeller like.
        if (k < 0) {
            k = a.length + k;
        }

        // Instansierer nødvendige variabler.
            // Brukes for å sjekke at alle tegn er flyttet.
        int ant_iter = 0;
            // Brukes fordi det i en del tilfeller må gjøres flere "forskjellige" iterasjoner.
            // Denne brukes for å holde styr på hvor hver enkel iterasjon starter.
        int start_index = 0;

            // Gjeldende indeks.
        int curr_index = 0;
            // Gjelende verdi.
        char curr_val = a[curr_index];
            // Ny indeks.
        int new_index;
            // Midlertidig verdi.
        char temp;

        // Bruker en while-løkke for å iterere.
        while (true) {
            // For hvert element finner vi indeksen til den nye plasseringen den skal få.
            new_index = (curr_index + k) % a.length;

            // Lagrer verdien i den nye posisjonen så den kan flyttes i neste iterasjon.
            temp = a[new_index];

            // Flytter den gjeldende verdien til sin nye plass.
            // (curr_val ble instansiert med verdien i a[0])
            a[new_index] = curr_val;

            // Oppdaterer den gjeldende verdien.
            curr_val = temp;

            // Oppdaterer den gjeldende indeksen.
            curr_index = new_index;

            // Øker antall iterasjoner med 1.
            ant_iter++;
            
            // Hvis vi har kommet en runde rundt sjekkes det om vi har iterert like mange ganger,
            // som antall tegn i arrayet.
            if (curr_index == start_index) {
                // Hvis det er tilfellet er rotasjonen utført, og metoden avsluttes.
                if (ant_iter == a.length) {
                    break;
                }
                // Hvis ikke flytter vi den gjeldende indeksen en frem,
                // og oppdaterer relevante variabler.
                // Dette garanterer at alle karakterer blir flyttet til riktig posisjon.
                else {
                    curr_index++;
                    curr_val = a[curr_index];
                    start_index = curr_index;
                }
            }
        }
        
        System.out.println("Antall : " + ant_iter + "\n");
    }


    public static void rotasjon_partner(char[] a, int k) {

        if (a.length == 0 || a.length == 1) {
            return;
        }

        k = k % a.length;

        if (k < 0) {
            k = a.length + k;
        }

        for (int n = 0; n <= k; n++) {
            char forrige = a[a.length-1];
            char temp = a[0];
                for (int i = 0; i < a.length; i++) {
                temp = a[i];
                a[i] = forrige;
                forrige = temp;
            }
        }
        
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 100000; i = i + 1000) {
            System.out.println(i);
            char[] vals = new char[i];

            rotasjon(vals, 700);
        }
    }
}
