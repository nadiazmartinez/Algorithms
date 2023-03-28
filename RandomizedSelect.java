import java.io.*;
import java.util.*;
import java.util.Arrays;

class RandomizedSelect{
        public static int partition(int[] A, int p,
                                    int r) {
                int x = A[r];
                int i = p - 1;
                for (int j = p; j < r; j++) {
                        if (A[j] <= x) {
                                i++;
                                swap(A, i, j);
                        }
                }
                swap(A, i + 1, r);
                return i + 1;
        }
                // swapping pivot
        public static void swap (int data[], int i, int j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
        }

        public static int ithSmallest(int[] A, int p,
                int r, int i)
                {
                // find the partition
                int q = partition(A, p, r);


                // if partition value is equal to the ith position,
                // return value at i
                if (q == i - 1)
                        return A[q];

                // if partition value is less than ith position,
                // search right side of the array.
                else if (q < i - 1)
                return ithSmallest(A, q + 1, r, i);

                // if partition value is more than ith position,
                // search left side of the array.
                else
                return ithSmallest(A, p, q - 1, i);
                }
}



public class Main {

    public static void main(String[] args) {
            int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
            int[] arraycopy = new int[] { 10, 4, 5, 8, 6, 11, 26 };

            int iPosition = 3;
            int length = array.length;

            if (iPosition > length) {
                    System.out.println("Index out of bound");
            }
            else {
                    // find ith smallest value
                    System.out.println(
                            "i-th smallest element in array : "
                                    + RandomizedSelect.ithSmallest(arraycopy, 0, length - 1,
                                    iPosition));
            }
    }
}
