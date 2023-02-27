package no.oslomet.cs.algdat.Oblig3;

import java.util.Comparator;
import java.util.Random;

public class Oppgave6 {
    public static void main(String[] args) {

        SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());

        int[] a = {10, 10, 14, 6, 8, 1, 12, 7, 3, 11, 9, 13, 5, 2, 4};
        for (int verdi : a) tre.leggInn(verdi);
        System.out.println(tre.toStringPostOrder());

        System.out.println(tre.fjern(1));
        System.out.println(tre.toStringPostOrder());

        System.out.println(tre.fjernAlle(10));

        System.out.println(tre.toStringPostOrder());
        tre.nullstill();
        System.out.println(tre.toStringPostOrder());

        
        /* int antallFeil = 0;

        SBinTre<Integer> tre =
                new SBinTre<>(Comparator.naturalOrder());

        String s;

        tre.leggInn(6);
        tre.fjern(6);

        s = tre.toStringPostOrder();
        if (!s.equals("[]")) {
            System.out.println("Oppgave 6a: Feil i fjern(T)!");
        }
        int[] a = {6, 3, 9, 1, 5, 7, 10, 2, 4, 8, 11, 6, 8};
        for (int verdi : a) tre.leggInn(verdi);

        boolean fjernet = tre.fjern(12);
        s = tre.toStringPostOrder();

        if (!s.equals("[2, 1, 4, 5, 3, 6, 8, 8, 7, 11, 10, 9, 6]")) {
            antallFeil++;
            System.out.println("Oppgave 6b: Feil i fjern(T)! Tallet 12 er ikke i treet!");
        }

        if (fjernet == true) {
            antallFeil++;
            System.out.println("Oppgave 6c: Feil i fjern(T)! Skal returnere false når");
            System.out.println("verdien ikke er i treet.");
        }

        if (tre.antall() != 13) {
            antallFeil++;
            System.out.println("Oppgave 6d: Feil i fjern(T)! Variabelen antall skal");
            System.out.println("ikke endres for en mislykket fjerning.");
        }

        fjernet = tre.fjern(2);
        s = tre.toStringPostOrder();

        if (!s.equals("[1, 4, 5, 3, 6, 8, 8, 7, 11, 10, 9, 6]")) {
            antallFeil++;
            System.out.println("Oppgave 6e: Feil i fjern(T)!");
        }

        if (fjernet == false) {
            antallFeil++;
            System.out.println("Oppgave 6f: Feil i fjern(T)! Skal returnere true");
            System.out.println("for en vellykket fjerning.");
        }

        if (tre.antall() != 12) {
            antallFeil++;
            System.out.println("Oppgave 6g: Feil i fjern(T)! Variabelen antall skal");
            System.out.println("reduseres med 1 for en vellykket fjerning.");
        }

        tre.fjern(4);
        s = tre.toStringPostOrder();

        if (!s.equals("[1, 5, 3, 6, 8, 8, 7, 11, 10, 9, 6]")) {
            antallFeil++;
            System.out.println("Oppgave 6h: Feil i fjern(T)!");
        }

        tre.fjern(6);
        s = tre.toStringPostOrder();

        if (!s.equals("[1, 5, 3, 8, 8, 7, 11, 10, 9, 6]")) {
            antallFeil++;
            System.out.println("Oppgave 6i: Feil i fjern(T)!");
        }

        tre.fjern(8);
        s = tre.toStringPostOrder();

        if (!s.equals("[1, 5, 3, 8, 7, 11, 10, 9, 6]")) {
            antallFeil++;
            System.out.println("Oppgave 6j: Feil i fjern(T)!");
        }

        tre.fjern(10);
        tre.fjern(11);
        tre.fjern(8);
        tre.fjern(7);
        s = tre.toStringPostOrder();

        if (!s.equals("[1, 5, 3, 9, 6]")) {
            antallFeil++;
            System.out.println("Oppgave 6k: Feil i fjern(T)!");
        }

        tre.fjern(1);
        tre.fjern(3);
        tre.fjern(5);
        tre.fjern(9);

        s = tre.toStringPostOrder();

        if (!s.equals("[6]")) {
            antallFeil++;
            System.out.println("Oppgave 6l: Feil i fjern(T)!");
        }

        tre.nullstill();

        if (tre.antall() != 0) {
            antallFeil++;
            System.out.println("Oppgave 6m: Feil i nullstill() - antall er feil!");
        }

        s = tre.toStringPostOrder();

        if (!s.equals("[]")) {
            antallFeil++;
            System.out.println("Oppgave 6n: Feil i nullstill()!");
        }

        try {
            tre.nullstill();
        } catch (Exception e) {
            antallFeil++;
            System.out.println
                    ("Oppgave 6o: Skal ikke kaste unntak når et tomt tre nullstilles!");
        }

        try {
            if (tre.fjernAlle(0) != 0) {
                antallFeil++;
                System.out.println("Oppgave 6p: Feil i fjernAlle(T) for tomt tre!");
            }
        } catch (Exception e) {
            antallFeil++;
            System.out.println
                    ("Oppgave 6q: Kaster unntak i fjernAlle(T) for tomt tre!");
        }

        tre.leggInn(0);

        try {
            if (tre.fjernAlle(0) != 1) {
                antallFeil++;
                System.out.println
                        ("Oppgave 6r: Feil i fjernAlle(T) for tre med en verdi!");
            }
        } catch (Exception e) {
            antallFeil++;
            System.out.println
                    ("Oppgave 6s: Kaster unntak i fjernAlle(T) for tre med en verdi!");
        }

        int[] b = {1, 4, 1, 3, 1, 2, 1, 1};
        for (int verdi : b) tre.leggInn(verdi);

        if (tre.fjernAlle(1) != 5) {
            antallFeil++;
            System.out.println("Oppgave 6t: Feil i fjernAlle(T)!");
        }

        s = tre.toStringPostOrder();
        if (!s.equals("[2, 3, 4]")) {
            antallFeil++;
            System.out.println("Oppgave 6u: Feil i fjernAlle(T)!");
        }

        tre = new SBinTre<>(Comparator.naturalOrder());

        Random r = new Random();
        for (int i = 0; i < 500_000; i++) tre.leggInn(r.nextInt(1_000_000));

        long tid = System.currentTimeMillis();
        tre.nullstill();
        tid = System.currentTimeMillis() - tid;

        if (tid < 10) {
            antallFeil++;
            System.out.println("Oppgave 6v: Har du kodet nullstill() ved kun");
            System.out.println("nullstille hode og antall? Alle nodeverdier og");
            System.out.println("pekere i treet skal nulles!");
        } */
    } 
}
