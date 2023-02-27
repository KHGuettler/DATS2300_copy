import no.oslomet.cs.algdat.Oblig2.*;

public class Oppgave6 {
    public static void main(String[] args) {
        String[] values = {};


        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(values);
        
        System.out.println(liste.toString());
        System.out.println(liste.fjern(0));
        System.out.println(liste.toString());

    }
}
