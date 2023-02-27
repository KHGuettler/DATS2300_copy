public class oppgave7 {

    /// 7a)
    public static String flett(String s, String t) {
        String res = "";
        String rest = "";
        int len = 0;
        
        if (s.length() > t.length()) {
            len = t.length();
            rest = s.substring(len, s.length());
        }
        else {
            len = s.length();
            rest = t.substring(len, t.length());
        }

        for (int i = 0; i < len; i++) {
            res += s.charAt(i);
            res += t.charAt(i);
        }
        res += rest;
        return res;
    }
    
    /// 7b)
    public static String flett(String... s) {
        // Variabel for å holde resultatet.
        String res = "";

        // Setter en variabel for å vite hvor vi er i hver streng.
        int karPos = 0;
        // Setter en boolsk variabel som sier om det er noen strenger igjen med flere
        // bokstaver.
        boolean bokstaverIgjen = true;
        // Bruker en while-løkke som går så lenge det finnes en streng med flere
        // bokstaver.
        while (bokstaverIgjen) {
            // Setter variabelen til false. Den blir satt til true hvis et av ordene har
            // flere bokstaver.
            bokstaverIgjen = false;
            // Iterer over alle ordene fra input.
            for (int i = 0; i < s.length; i++) {
                // Sjekker om vi har nådd enden av strengen.
                if (s[i].length() > karPos) {
                    // Variabelen settes til true, så while-løkken fortsetter.
                    bokstaverIgjen = true;
                    // Res oppdateres med bokstaven på plassen angitt av karPos-variabelen.
                    res += s[i].charAt(karPos);
                }
            }
            karPos++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ABC";
        String t = "DEFGH";

        String res = flett(s, t);

        System.out.println(res);

        String a = flett("AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU");
        System.out.println(a);


    }
    
}
