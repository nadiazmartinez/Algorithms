import java.util.*;

class InsertionSort {
    public static void insertion_sort (int array[]){
        int n = array.length;
        for(int i = 1; i < n; i++){
            int key = array[i];
            int j = i - 1;

            // move elements of array that are greater than key to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    //print Array
    static void printArray(int array[])
    {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");

        System.out.println();
    }

        public static void main(String[] args) {
            int array[] = { 18, 7, 27, 92, 4, 5, 16, 13, 100, 1, 12, 35, 43, 41, 29, 33, 98, 99, 67, 76};
            InsertionSort ob = new InsertionSort();
            ob.insertion_sort(array);
            printArray(array);
        }
    }
