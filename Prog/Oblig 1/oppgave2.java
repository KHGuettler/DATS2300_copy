public class oppgave2 {
    
    public static int antallUlikeSortert(int[] a) {

        // Hvis tabellen er tom returneres 0.
        if (a.length == 0) {
            return 0;
        }

        // Hvis ikke initialiserer vi antall-variabelen med verdien 1.
        // Vi kan være sikre på at dette stemme (siden en ikke-tom tabell må ha minst en unik verdi).
        // Dette løser også et problem der enten siste eller første verdi ikke kan sjekkes på en elegant måte.
        // TODO: Det bør sjekkes om det finnes en bedre måte å gjøre dette på.
        int antall = 1;

        // Itererer over tabellen.
        for (int i = 1; i < a.length; i++) {
            // Sjekker for hvert element at det står riktig i forhold til det neste elementet.
            // Dette for å garanterer at tabellen er sortert.
            if (a[i] < a[i-1]) {
                throw new IllegalStateException("Tabellen er ikke sortert i stigende rekkefølge. Vennligst prøv igjen med en gyldig tabell.");
            }

            // Sjekker om to elementer ved siden av hverandre ikke har samme verdi.
            // Hvis de ikke har det økes antall med 1.
            if (!(a[i-1] == a[i])) {
                antall++;
            }

        }

        // Returnerer antall.
        return antall;
    }

    public static void main(String[] args) {
        
        int[] values = {1, 2, 2, 3, 3, 4, 5, 5, 5, 6};

        int res = antallUlikeSortert(values);

        System.out.println(res);
    }
}
