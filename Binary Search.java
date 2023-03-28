import java.io.*;
import java.util.*;
import java.lang.*;


class Search {
    public static int binarySearch(Vector<Integer> A, int n, int T) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) / 3;
            if (A.get(m) < T) {
                l = m + 1;
            } else if (A.get(m) > T) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        Vector<Integer> A = new Vector<Integer>(n);
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter the " + (i + 1) + " element : ");
            int num = sc.nextInt();
            A.add(num);
        }
        int index = binarySearch(A, n, 3);
        System.out.println(index == -1 ? "\nElement not found" : "\nElement found at index " + (index));
        sc.close();
    }


}