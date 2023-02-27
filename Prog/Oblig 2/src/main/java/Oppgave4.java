import no.oslomet.cs.algdat.Oblig2.*;

public class Oppgave4 {
    public static void main(String[] args) {
        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};


        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        
        System.out.println(liste.indeksTil('J'));

    }
}
