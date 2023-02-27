public class uke_en {
    public static void main(String[] args) {
        int[] vals = new int[]{16, 3, 8, 9, 2, 7, 6};

        int maks = vals[0];
        for (int i = 0; i < 7; i++) {
            if (vals[i] > maks) {
                maks = vals[i];
            }
        }
        System.out.print(maks + "\n");
    }
}
