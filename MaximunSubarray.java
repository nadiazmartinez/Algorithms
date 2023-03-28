import java.util.*;


public class Main {

    static int FindMaximumSubArray (int A[], int low, int high){

        //Invalid Range: low is greater than high
        if (low > high)
            return Integer.MIN_VALUE;
        // Base Case: Only one element
        if (low == high)
            return A[low];

        // Find middle point
        int m = (low + high) / 2;

        // Return maximum sum of following three possible cases: left, right, midpoint

        return Math.max(
                Math.max(FindMaximumSubArray(A, low, m-1),
                        FindMaximumSubArray(A, m + 1, high)),
                FindMaxCrossingSubArray(A, low, m, high));
        }

    static int FindMaxCrossingSubArray (int A[], int low, int mid, int high){
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum = sum + A[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = mid; i <= high; i++) {
            sum = sum + A[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        // Return sum of elements on left
        // and right of mid
        // returning only left_sum + right_sum will fail for
        // [-2, 1]
        return Math.max(left_sum + right_sum - A[mid],
                Math.max(left_sum, right_sum));

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 7 };
        int n = arr.length;
        int max_sum = FindMaximumSubArray(arr, 0, n - 1);

        System.out.println("Maximum contiguous sum is "
                + max_sum);

    }
}
