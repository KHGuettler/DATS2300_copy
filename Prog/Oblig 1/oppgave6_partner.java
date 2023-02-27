public class oppgave6_partner {

    public static void rotasjon(char[] a, int k) {
        if (a.length == 0) {
            return;
        }

        k = k % a.length;
        if (k > a.length/2) {
            k = a.length - k;
        }
    

        if (k > 0){
            for (int i = 0; i < k; i++){

                char last = a[a.length-1];

                for (int j = a.length-1; j > 0; j--){
                    a[j] = a[j-1];
                }
                a[0] = last;
            }
        }
        else if (k < 0){
            for (int i = k; i < 0; i++){
                char first = a[0];
                for (int j = 1; j < a.length; j++){
                    a[j-1] = a[j];
                }
                a[a.length-1] = first;
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0 ; i < 100000; i = i + 1000) {
            long tid = System.currentTimeMillis();
            char[] vals = new char[i];

            rotasjon(vals, 700);
            System.out.println(System.currentTimeMillis() - tid);
        }
    }
    
}
