import java.util.Arrays;
import java.util.Random;


public class oppgave4 {

    public static int[] permDupes(int n) {
        Random r = new Random();
        int[] a = new int[n]; 

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n) + 1;
        }

        return a;
    }

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

    // Minner om programkode 1.3.9 a) fra kompendiet,
    // men bruker paritet i stedet for størrelse.
    // Sorterer også hele arrayet uten input på sub-array.
    public static int parterParitet(int[] a) {
        int v = 0;
        int h = a.length - 1;
        while (true) {
            // Flytter indeksene for venstre og høyre så lenge de er odde og par respektivt.
            // (Bruker bit-vis sammenligning da dette er marginalt mer effektivt.)
            while (v <= h && (a[v] & 1) == 1) {
                v++;
            }

            while (v <= h && (a[h] & 1) == 0) {
                h--;
            }

            if (v < h) {
                bytt (a, v++, h--);
            }
            else {
                return v;
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

    // Basert på programkode 1.3.9 a) fra kompendie,
    // men skiller basert på paritet, ikke størrelse.
    public static void delsortering(int[] a) {
        int odde = 0;
        int par = a.length - 1;

        // Flytter indeksene for venstre og høyre så lenge de er odde og par respektivt.
        // (Bruker bit-vis sammenligning da dette er marginalt mer effektivt enn modulus.)
        while (true) {
            while (odde <= par && (a[odde] & 1) == 1) {
                odde++;
            }

            while (odde <= par && (a[par] & 1) == 0) {
                par--;
            }
            if (odde < par) {
                bytt(a, odde++, par--);
            }
            else {
                break;
            }
        }

        // Når arrayet er sortert med hensyn på paritet,
        // kalles kvikkSortering() separat på begge sidene av arrayet.
        // Sub-arrayene er da definert som :
            // odde = [0:par]
            // par = [odde:a.length-1]
        kvikkSortering(a, 0, par);
        kvikkSortering(a, odde, a.length-1);
    }

    public static void delsortering_old(int[] a) {
        //System.out.println(Arrays.toString(a));
        int parStart = a.length-1;
        for (int i = 0; i < a.length; i++) {
            // Partall
            if ((a[i] & 1) == 0) {
                for (int n = a.length-1; n > i; n--) {
                    if ((a[n] & 1) == 1) {
                        int temp = a[i];
                        a[i] = a[n];
                        a[n] = temp;
                        parStart = n;
                        break;
                    }
                    
                    else if (a[i] > a[n]) {
                        //System.out.println(Arrays.toString(a));
                        //System.out.println(a[i] + " er større enn " + a[n]);
                        int temp = a[i];
                        a[i] = a[n];
                        a[n] = temp;
                        //System.out.println(Arrays.toString(a) + "\n");
                    }
                }
            }
        }

        for (int i = 0; i < parStart; i++) {
            System.out.println(a[i]);
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        
        int[] values = {2, 4, 3, 1, 6, 8, 5};
        delsortering(values);
        System.out.println(Arrays.toString(values));
        


        
        
        /**
        long starttid = System.currentTimeMillis();
        int[] values = permDupes(1000000);
        delsortering(values);

        System.out.println(System.currentTimeMillis() - starttid);
        */
        
        
    }
    
}
