public class Sortering {

    // Kompendie : Programkode 1.1.8 d)
    // Metode for å bytte verdiene på to indeks-posisjoner for et gitt array.
    private static void bytt(int[] a, int i, int n) {
        int temp = a[i];
        a[i] = a[n];
        a[n] = temp;
    }

    // Kompendie : Programkode 1.3.9 a)
    // Metode som sorterer et array basert på en skilleverdi.
    public static int partisjoner(int[] a, int venstre, int høyre, int skille) {
        while (true) {
            // Så lenge venstre-indeksen er mindre enn høyre
            // og verdien på venstre-indeksen er lavere enn skilleverdien,
            // flyttes venstre-indeksen enn til høyre.
            while (venstre <= høyre && a[venstre] < skille) {
                venstre++;
            }

            // Det samme gjøres her, men her sjekkes det om høyre er større eller lik skillverdien.
            while (venstre <= høyre && a[høyre] >= skille) {
                høyre--;
            }

            // Når vi er ute av løkkene sjekkes det om venstre er mindre enn høyre;
            if (venstre < høyre) {
                // Hvis det er tilfellet byttes verdiene om,
                // og den ytre løkken fortsetter.
                bytt(a, venstre++, høyre--);
            }

            else {
                // Hvis ikke er alt sortert, og venstre-indeksen returneres,
                // da dette er der skille i arrayet ligger.
                return venstre;
            }
        }
    }


    // Kompendie : Programkode 1.3.9 f)
    // Metode for å plassere skilleverdien på riktig indeks etter partisjonering.
    public static int sorterSkille(int[] a, int venstre, int høyre, int indeks) {
        // Bytter om skilleverdien med siste element.
        bytt(a, indeks, høyre);
        // Kaller partisjoner().
        int pos = partisjoner(a, venstre, høyre-1, a[høyre]);
        // Flytter skilleverdien til indeksen returenrt av partisjoner().
        bytt(a, pos, høyre);
        return pos;
    }

    // Kompendie : Programkode 1.3.9 h)
    // Metode for å implementere en kvikksorterings-algoritme.
    public static void kvikkSortering(int[] a, int venstre, int høyre) {
        // Avbryter metoden når venstre er større eller lik høyre, 
        // da dette betyr at arrayet er sortert.
        if (venstre >= høyre) {
            return;
        }
        
        // Finner et skille (pivot) fra sorterSkille(),
        // og kaller seg selv med nye argumenter.
        int skille = sorterSkille(a, venstre, høyre, (venstre + høyre) / 2);
        kvikkSortering(a, venstre, skille - 1);
        kvikkSortering(a, skille +1, høyre);
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
