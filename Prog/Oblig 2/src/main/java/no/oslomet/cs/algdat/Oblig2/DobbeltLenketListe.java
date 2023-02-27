package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        //throw new UnsupportedOperationException();
    }

    // Oppgave 1 ///////
    public DobbeltLenketListe(T[] a) {
        // Hvis a er n null tabell kastes execptiopn.
        Objects.requireNonNull(a, "Tabellen er null.");

        // Gjør ingenting hvis tabellen er tom.
        if (a.length == 0) {
            return;
        }

        
        // Finner første verdi som ikke er 'null'.
        // Bruker -1 som placeholder-verdi, siden den aldri vil bli satt av løkken.
        int forste_indeks = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                forste_indeks = i;
                break;
            }
        }

        // Hvis verdien i forste_indeks ikke er forandret, gjør vi ingenting.
        if (forste_indeks == -1) {
            return;
        }

        // Oppretter den første noden, og øker "antll"-variabelen med 1.
        Node<T> ny_node = new Node<T>(a[forste_indeks]);
        antall++;
        // Oppretter "hode"-noden, og peker "neste" til den nye noden.
        hode = new Node<T>(null, null, ny_node);

        // Hjelpevariabel.
        Node<T> forrige_node;
        // Itererer over listen fra første indeks som ikke er 'null'.
        for (int i = forste_indeks + 1; i < a.length; i++) {
            if (a[i] != null) {
                // Setter "forrige_node" til den forrige som ble opprettet.
                forrige_node = ny_node;
                // Oppretter en ny node, med verdi fra tabellen, og med peker til "forrige_node".
                ny_node = new Node<T>(a[i], forrige_node, null);
                // Oppdaterer "forrige_node" til å peke på den nye noden.
                forrige_node.neste = ny_node;
                
                // Øker antall og endringer med 1.
                antall++;
                endringer++;
            }
        }
        // Oppretter hale-noden, og peker denne til den siste noden som ble opprettet.
        hale = new Node<T>(null, ny_node, null);
    }

    // Oppgave 3b ///////
    public Liste<T> subliste(int fra, int til) {
        // Sjekekr at intervallet er gyldig.
        fratilKontroll(antall, fra, til);

        // Oppretter en ny DobbeltLenketListe.
        DobbeltLenketListe<T> ny_liste = new DobbeltLenketListe<>();

        // Itererer på intervallet [fra:til> med en while-løkke.
        int indeks = fra;
        while (indeks < til) {
            // Bruker hent()-metoden til å hente verdien i noden på hver posisjon.
            // Legger verdiene inn i den nye listen.
            ny_liste.leggInn(hent(indeks));
            // Øker "indeks" med 1.
            indeks++;
        }

        // Setter antall endringer til 0, siden dett er en ny liste.
        ny_liste.endringer = 0;
        return ny_liste;
    }

    // Oppgave 1 ///////
    @Override
    public int antall() { 
        return antall;
    }

    // Oppgave 1 ///////
    @Override
    public boolean tom() {
        if (antall == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Oppgave 2b ///////
    @Override
    public boolean leggInn(T verdi) {
        // Sjekker at verdien ikke er null.
        Objects.requireNonNull(verdi, "Null-verdier er ikke tillatt.");

        // Oppretter en ny node med verdien gitt som argument.
        Node<T> ny_node = new Node<T>(verdi);
        
        // Sjekker om listen er tom.
        if (tom()) {
            // Hvis det er tilfellet opprettes "hode"- og "hale"-nodene refereranser til "ny_node".
            hode = new Node<T>(null, null, ny_node);
            hale = new Node<T>(null, ny_node, null);

            // Øker "antall" og "endringer" med 1.
            antall++;
            endringer++;

            return true;
        }
        else {
            // Hvis listen ikke er tom,
            // settes "ny_node" sin 'forrige'-peker til det (tidligere) siste elementet i listen.
            ny_node.forrige = hale.forrige;
            // Det (tidligere) siste elementet sin 'neste'-peker settes til "ny_node".
            hale.forrige.neste = ny_node;
            // Hale sine 'forrige'-peker settes til ny node.
            hale.forrige = ny_node;

            // Øker "antall" og "endringer" med 1.
            antall++;
            endringer++;

            return true;
        }
    }

    // Oppgave 5 ///////
    @Override
    public void leggInn(int indeks, T verdi) {
        // Sjekekr at verdien ikke er 'null'.
        Objects.requireNonNull(verdi);
        // Sjekker at indeksen er gylding.
        indeksKontroll(indeks, true);

        // Hvis listen er tom brukes leggInn()-metoden, siden denne håndterer tomme lister.
        if (tom()) {
            leggInn(verdi);
            return;
        }
        // Hvis verdien skall legges til bakerst i listen, brukes leggInn()-metoden,
        // siden denne alltid legger till noder bakerst.
        else if (indeks == antall) {
            leggInn(verdi);
            return;
        }
        // Hvis verdien skall legges inn først i listen : 
        else if (indeks == 0) {
            // Oppretter en ny node, og peker den mot den (tidligere) første i listen [Altså "hode.neste"].
            Node<T> ny_node = new Node<T>(verdi, null, hode.neste);
            // Oppdaterer den (tidligere) første noden til å peke tilbake på den nye noden.
            hode.neste.forrige = ny_node;
            // Oppdaterer "hode" til å peke på den nye noden.
            hode.neste = ny_node;
            // Øker antall og endringer med en.
            antall++;
            endringer++;
        }
        // Hvis verdien skal legges inn et annet sted i listen : 
        else {
            Node<T> før_node = finnNode(indeks-1);
            Node<T> etter_node = før_node.neste;
            Node<T> ny_node = new Node<T>(verdi, før_node, etter_node);
            før_node.neste = ny_node;
            etter_node.forrige = ny_node;
            antall++;
            endringer++;
        }

    }

    // Oppgave 4 ///////
    @Override
    public boolean inneholder(T verdi) {
        // Bruker indeksTil()-metoden for å sjekke om listen inneholder verdien.
        // Hvis metoden returnerer '-1', vet vi at listen IKKE inneholder verdien.
        if (indeksTil(verdi) == -1) {
            return false;
        }  
        else {
            return true;
        }
    }

    // Oppgave 3a ///////
    @Override
    public T hent(int indeks) {
        // Sjekker at indeksen gitt som argument er gyldig.
        indeksKontroll(indeks, false);

        // Bruker finnNode()-metoden til å finne den riktige noden.
        // Returnerer verdien til den gitte noden.
        return finnNode(indeks).verdi;
    }

    // Oppgave 4 ///////
    @Override
    public int indeksTil(T verdi) {
        // Hvis listen er tom, eller "verdi" er 'null', returnerer vi '-1'.
        if (tom()) {
            return -1;
        }
        else if (verdi == null) {
            return -1;
        }

        // Oppretter en hjelpevariabel, og setter verdien til første node.
        Node<T> gjell_node = hode.neste;

        // Iterer gjennom nodene.
        // Stopper enten når riktig verdi er funnet,
        // eller når hele listen er gått gjennom.
        for (int indeks = 0; indeks < antall; indeks++) {
            // Hvis verdiene er like, returnerer vi indeks.
            if (gjell_node.verdi.equals(verdi)) {
                return indeks;
            }
            // Hvis ikke oppdateres "gjell_node", og løkken fortsetter.
            gjell_node = gjell_node.neste;
        }
        
        // Hvis vi kommer ut av løkken vet vi at verdien ikke befinner seg i listen,
        // så vi returnerer '-1'.
        return -1;
    }

    // Oppgave 3a ///////
    @Override
    public T oppdater(int indeks, T nyverdi) {
        // Sjekker at indeksen gitt som argument er gyldig.
        indeksKontroll(indeks, false);
        // Sjekker at verdien ikke er 'null'.
        Objects.requireNonNull(nyverdi, "Verdi kan ikke være null.");

        // Bruker finnNode()-metoden for å finne den aktuelle noden.
        Node<T> mål_node = finnNode(indeks);
        // Lagrer den gamle verdien i en variabel.
        T gammelverdi = mål_node.verdi;

        // Setter nodens verdi til den nye verdien.
        mål_node.verdi = nyverdi;

        // Øker antall endringer med 1.
        endringer++;

        // Returnerer den gamle verdien.
        return gammelverdi;
    }

    // Oppgave 6 ///////
    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false;
        }
        
        Node<T> gjell_node = hode;

        // Iterer gjennom listen så lenge den gjellende noden har en neste node.
        while (gjell_node.neste != null) {
            // Går til neste node.
            gjell_node = gjell_node.neste;

            // Hvis noden har riktig verdi, sjekkes det om den er på starten / slutten av listen eller ikke.
            if (gjell_node.verdi.equals(verdi)) {
                // Hvis verdien ligger på indeks 0 sjekkes det om det listen har 1 element.
                if (gjell_node.forrige == null) {
                    // Hvis det er tilfelle settes hode og hale til 'null.'
                    if (antall() == 1) {
                        hode = null;
                        hale = null;
                    }
                    // Hvis det ikke er tilfellet, fjernes noden, og "hode" pekes mote den nye første-noden.
                    else {
                        hode.neste = gjell_node.neste;
                        gjell_node.neste.forrige = null;
                    }
                }
                // Hvis verdien er den siste i listen, oppdateres "hale" og den nye sisteverdien i listen.
                else if (gjell_node.neste == null) {
                    hale.forrige = gjell_node.forrige;
                    gjell_node.forrige.neste = null;
                }
                // Hvis verdien ligger et sted i listen, fjernes noden,
                // og nodene rundt oppdateres til å peke på hverandre.
                else {
                    Node<T> forrige_node = gjell_node.forrige;
                    forrige_node.neste = gjell_node.neste;
                    forrige_node.neste.forrige = forrige_node;
                }

                // Til slutt oppdateres "antall" og "endringer" med -1 og 1 respektivt.
                antall--;
                endringer++;

                return true;
            }
        }
        // Hvis verdien ikke finnes i liste, returneres 'null'.
        return false;
    }

    // Oppgave 6 ///////
    @Override
    public T fjern(int indeks) {
        // Sjekker at gitt indeks er gyldig.
        indeksKontroll(indeks, false);

        // Hjelpevariable.
        T fjernet_verdi;
        if (antall() == 1) {
            fjernet_verdi = hode.neste.verdi;
            hode = null;
            hale = null;
        }

        else if (indeks == 0) {
            Node<T> fjernet_node = hode.neste;
            fjernet_verdi = fjernet_node.verdi;
            hode.neste = fjernet_node.neste;
            hode.neste.forrige = null;
        }
        
        else if (indeks == antall-1) {
            Node<T> fjernet_node = hale.forrige;
            fjernet_verdi = fjernet_node.verdi;
            hale.forrige = fjernet_node.forrige;
            hale.forrige.neste = null;
        }
        else {
            Node<T> gjell_node = finnNode(indeks);
            Node<T> forrige_node = gjell_node.forrige;
            Node<T> neste_node = gjell_node.neste;

            forrige_node.neste = neste_node;
            neste_node.forrige = forrige_node;

            fjernet_verdi = gjell_node.verdi;
        }
        
        antall--;
        endringer++;
        return fjernet_verdi;
    }

    // Oppgave 7 ///////
    @Override
    public void nullstill(){
        // Hvis listen allerede er tom, avslutter vi bare funksjonen.
        if (tom()) {
            return;
        }

        // Setter hjelpevariabler.
        Node<T> gjell_node = hode;
        Node<T> neste_node = hode.neste;

        // Iterer over listen så lengde det finnes en neste node.
        while (gjell_node.neste != null) {
            gjell_node = neste_node;
            endringer++;

            // Nuller "forrige" og "verdi".
            gjell_node.forrige = null;
            gjell_node.verdi = null;

            // Hvis det ikke finnes en neste node, brytes løkken.
            if (gjell_node.neste == null) {
                break;
            }
            // Hvis ikke, lagres den neste node, før "gjell_node.neste" blir nullet ut.
            else {
                neste_node = gjell_node.neste;
                gjell_node.neste = null;
            }
        }

        // Når hele listen er kjørt gjennom, settes "hode" og "hale" til null, og "antall" settes til 0.
        hode = null;
        hale = null;
        antall = 0;
    }

    // Metode for å nullstille ved bruk av "fjern()"-metoden.
    // Denne brukes ikke, da den er betydlig mindre effektiv.
    /* @Override
    public void nullstill() {
        if (tom()) {
            return;
        }

        Node<T> gjell_node = hode;
        while (gjell_node.neste != null) {
            gjell_node = gjell_node.neste;
            fjern(0);
        }
        antall = 0;
    } */

    // Oppgave 2a ///////
    @Override
    public String toString() {
        // Hvis listen er tom, returneres "[]".
        if (tom()) {
            return "[]";
        }   

        // Oppretter et nytt StringJoiner-objekt, med "," som delimiter, og "[" og "]" som prefiks og sufiks respektivt.
        StringJoiner out_string = new StringJoiner(", ", "[", "]");

        // Starter på "hode"-noden.
        Node<T> curr_node = hode;
    
        // Iterer så lenge den gjeldende noden har en "neste"-node.
        while (curr_node.neste != null) {
            // Finner neste node.
            curr_node = curr_node.neste;
            // Legger til en String-representasjon av verdien i StringJoiner-objektet.
            out_string.add(curr_node.verdi.toString());
        }

        // Returnerer en String-representasjon av StringJoiner-objektet.
        return out_string.toString();
    }

    // Oppgave 2a ///////
    public String omvendtString() {
        // Hvis listen er tom, returneres "[]".
        if (tom()) {
            return "[]";
        }

        // Oppretter et nytt StringJoiner-objekt, med "," som delimiter, og "[" og "]" som prefiks og sufiks respektivt.
        StringJoiner out_string = new StringJoiner(", ", "[", "]");

        // Starter på "hode"-noden.
        Node<T> curr_node = hale;
        
        // Iterer så lenge den gjeldende noden har en "forrige"-node.
        while (curr_node.forrige != null) {
            // Finner node før den gjellende noden.
            curr_node = curr_node.forrige;
            // Legger til en String-representasjon av verdien i StringJoiner-objektet.
            out_string.add(curr_node.verdi.toString());
        }

        // Returnerer en String-representasjon av StringJoiner-objektet.
        return out_string.toString();
    }

    // Oppgave 3a ///////
    private Node<T> finnNode(int indeks) {
        // Hjelpevariabeler
        Node<T> res_node;
        int liste_indeks;

        // Sjekker hvilke vei vi skal iterere.
        if (indeks < antall/2) {
            // Starter ved starten av listen.
            res_node = hode.neste;
            liste_indeks = 0;

            // Bruker en while-løkken til å iterer gjennom listen,
            // til vi kommer til ønsket indeks.
            while (liste_indeks != indeks) {
                // Oppdaterer "res_node".
                res_node = res_node.neste;
                
                // Øker "liste_indeks" med 1.
                liste_indeks++;
            }
        }
        else {
            // Starter ved slutten av listen.
            res_node = hale.forrige;
            liste_indeks = antall-1;

            // Bruker en while-løkken til å iterer baklengs gjennom listen,
            // til vi kommer til ønsket indeks.
            while (liste_indeks != indeks) {
                res_node = res_node.forrige;
                // Reduserer "liste_indeks" med 1.
                liste_indeks--;
            }
        }
        
        // Returnerer den aktuelle noden.
        return res_node;
    }

    // Oppgave 3b ///////
    // Hentet fra Kompendiet ///
    // Programkode 1.2.3 a) ///
    private static void fratilKontroll(int antall, int fra, int til){
        if (fra < 0) {
            throw new IndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }

        if (til > antall){
            throw new IndexOutOfBoundsException("til(" + til + ") > antall(" + antall + ")");
        }
        
        if (fra > til){
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }

    // Oppgave 8b ///////
    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }


    // Oppgave 8d ///////
    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        // Oppgave 8c ///////
        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        // Oppgave 8a ///////
        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException();
            }
            else if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // Muligens ikke spesifisert i oppgaven,
            // men må gjøres for å hindre å alltid returnere 'null' som første verdi.
            else if (denne == hode && denne.neste != null) {
                denne = denne.neste;
            }

            fjernOK = true;
            Node<T> forrige_node = denne;
            denne = denne.neste;
            return forrige_node.verdi;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


