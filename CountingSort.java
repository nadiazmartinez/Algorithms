import java.util.Arrays;
import java.util.Vector;

public class CountingSort {
    public static void counting_sort(Vector<Integer> input, Vector<Integer> output, int k){
        // Find the minimum and maximum elements in the input vector
        int min = input.get(0);
        int max = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) < min) {
                min = input.get(i);
            }
            if (input.get(i) > max) {
                max = input.get(i);
            }
        }

        // Create the count array
        Vector<Integer> count = new Vector<Integer>(max - min + 1);
        for (int i = 0; i < max - min + 1; i++) {
            count.add(0);
        }

        // Count the number of occurrences of each element
        for (int i = 0; i < input.size(); i++) {
            count.set(input.get(i) - min, count.get(input.get(i) - min) + 1);
        }

        // Calculate cumulative sum of count array
        for (int i = 1; i < count.size(); i++) {
            count.set(i, count.get(i) + count.get(i - 1));
        }

        // Sort the elements into the output array
        for (int i = input.size() - 1; i >= 0; i--) {
            output.set(count.get(input.get(i) - min) - 1, input.get(i));
            count.set(input.get(i) - min, count.get(input.get(i) - min) - 1);
        }
    }
    public static void main(String[] args) {
	// write your code here
        Vector<Integer> myData = new Vector <Integer>();
        myData.addElement(18);
        myData.addElement(7);
        myData.addElement(27);
        myData.addElement(92);
        myData.addElement(4);
        myData.addElement(5);
        myData.addElement(16);
        myData.addElement(13);
        myData.addElement(100);
        myData.addElement(1);
        myData.addElement(12);
        myData.addElement(35);
        myData.addElement(43);
        myData.addElement(41);
        myData.addElement(29);
        myData.addElement(33);
        myData.addElement(98);
        myData.addElement(99);
        myData.addElement(67);
        myData.addElement(76);

        System.out.println(myData);
        Integer max = myData.elementAt(0);
        for(int i = 0; i < myData.size(); i++){
            if (myData.elementAt(i) > max)
            max = myData.elementAt(i);
        }
        Vector <Integer> mySortedData = new Vector <Integer>();
        counting_sort(myData, mySortedData, max);
        System.out.println(mySortedData);
    }
}
