public class _23th2_arrays {
    public static void main(String[] args) {
        // Multidimensional arrays
        int[] number = {1,2,3,4,6,7,8,9,10};
        int target = 5;
        boolean isfound = false;

        for (int n : number) {
            if (n == target) {
                isfound = true;
                break;
            }
        }
        System.out.println(isfound);

    }
}
