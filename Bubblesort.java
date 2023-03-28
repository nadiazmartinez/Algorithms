import java.io.*;

class BubbleSort
{
    // An optimized version of Bubble Sort
    static void bubbleSort(int array[], int n) {
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Print an array
    static void printArray(int array[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int array[] = { 18, 7, 27, 92, 4, 5, 16, 13, 100, 1, 12, 35, 43, 41, 29, 33, 98, 99, 67, 76 };
        int n = array.length;
        bubbleSort(array, n);
        printArray(array, n);
    }
}