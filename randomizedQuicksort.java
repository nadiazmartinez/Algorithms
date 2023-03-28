import java.util.*;

class RandomizedQuicksort
{
    // This Function helps in calculating random numbers between p and r
    static void randomizedPartition(int arr[],int p,int r)
    {
        Random rand= new Random();
        int pivot = rand.nextInt(r -p)+p;
        int temp1=arr[pivot];
        arr[pivot]=arr[r];
        arr[r]=temp1;
    }

    /* This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot */
    static int partition(int arr[], int p, int r)
    {
        // pivot is chosen randomly
        randomizedPartition(arr,p,r);
        int pivot = arr[r];


        int i = (p-1); // index of smaller element
        for (int j = p; j < r; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    p --> Starting index,
    r --> Ending index */
    static void randomizedSort(int arr[], int p, int r)
    {
        if (p < r)
        {
            /* pi is partitioning index, arr[pi] is
            now at right place */
            int pi = partition(arr, p, r);

            // Recursively sort elements before
            // partition and after partition
            randomizedSort(arr, p, pi-1);
            randomizedSort(arr, pi+1, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver Code
    public static void main(String args[])
    {
        int arr[] = {18, 7, 27, 92, 4, 5, 16, 13, 100, 1, 12, 35, 43, 41, 29, 33, 98, 99, 67, 76};
        int n = arr.length;
        printArray(arr);
        randomizedSort(arr, 0, n-1);
        printArray(arr);
    }
}
