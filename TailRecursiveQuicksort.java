import java.util.Arrays;

class QuickSortUsingTailRecursion {

    public static void sort(int[] array) {
        tailRecursion(array, 0, array.length - 1);
    }

    private static void tailRecursion(int[] array, int p, int r) {

        while (p < r) {
            int q = partition(array, p, r);
            tailRecursion(array, p, q - 1);
            p = q + 1;
        }
    }

    private static int partition(int[] array, int p, int r) {
        int i = p - 1;
        int j = p;

        while (j < r) {
            if (array[j] <= array[r]) {
                swap(array, ++i, j);
            }
            j++;
        }

        swap(array, ++i, j);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {18, 7, 27, 92, 4, 5, 16, 13, 100, 1, 12, 35, 43, 41, 29, 33, 98, 99, 67, 76};
        System.out.println("Before Array: " + Arrays.toString(array));
        QuickSortUsingTailRecursion.sort(array);
        System.out.println("After Array: " + Arrays.toString(array));
    }

}