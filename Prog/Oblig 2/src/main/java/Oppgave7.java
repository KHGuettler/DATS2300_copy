import no.oslomet.cs.algdat.Oblig2.*;
public class Oppgave7 {
    public static void main(String[] args) {
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>();

        for (int i = 0; i < 100_000_00; i++) {
            l1.leggInn(String.valueOf(i));
        }
        System.out.println("Fjerner");
        long tid = System.currentTimeMillis();
        l1.nullstill();
        System.out.println(l1);

        System.out.println(System.currentTimeMillis() - tid);
    }
}
