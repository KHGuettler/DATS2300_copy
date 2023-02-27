import java.util.Arrays;

public class oppgave5 {
    
    public static void rotasjon(char[] a) {

        if (a.length == 0) {
            return;
        }
        char forrige = a[a.length-1];
        char temp = a[0];
        for (int i = 0; i < a.length; i++) {
            temp = a[i];
            a[i] = forrige;
            forrige = temp;
        }
    }

    public static void main(String[] args) {
        char[] values = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        //char[] values = {};

        rotasjon(values);
        System.out.println(Arrays.toString(values));
    }   
}
