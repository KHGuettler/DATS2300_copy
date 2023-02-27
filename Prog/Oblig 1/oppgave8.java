import java.util.Arrays;

public class oppgave8 {

    public static int[] indekssortering(int[] a) {
        
        int[] indeksTabell = new int[a.length];

        if (a.length == 0) {
            return indeksTabell;
        }

        return indeksTabell;
    }
    

    public static void main(String[] args) {
        int[] values = {7, 2, 8, 8, 5, 7};

        int[] index = indekssortering(values);
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(index));
        System.out.print("Sortert : ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[index[i]] + " ");
        }
    }
}
