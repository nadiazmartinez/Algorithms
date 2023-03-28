import java.util.List;
import java.util.Vector;

class BucketSort {
    public static void bsort(Vector<Double> array) {
        int m = 10;
        Vector<Vector<Double>> b = new Vector<Vector<Double>>();
        for (int i = 0; i < m; i++) {
            //compose vector of doubles
            Vector<Double> temp = new Vector<Double>();

            //add individual elements to b
            b.addElement(temp);
        }
        // end of line 1

        int n = array.size();
        // line 5
        for (int i = 0; i < n; i++) {
            int bIndex = (int) (array.elementAt(i) / (double) (m));
            //System.out.print(bIndex + " ");
            b.elementAt(bIndex).addElement(array.elementAt(i));
        }

        //sort every temp
        for (int i = 0; i < m; i++) {
            insertionSort(b.get(i));
        }

        //take all values for b and put into array
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < b.get(i).size(); j++) {
                array.set(index++, b.get(i).get(j));

            }

        }
    }

        public static void insertionSort (List<Double> arr) {
            for (int i = 1; i < arr.size(); i++) {
                double key = arr.get(i);
                int j = i - 1;

                while (j >= 0 && arr.get(j) > key) {
                    arr.set(j + 1, arr.get(j));
                    j--;
                }
                arr.set(j + 1, key);
            }
        }

        public static void main (String[]args){
            //1. compose an array of unsorted data

            Vector<Double> array = new Vector<Double>();
            for (double i = 0.0; i < 200; i++) {
                array.addElement((i * 199) % 97);
            }

            //2. display original array
            System.out.println(array);

            //3. use sorting algorithm
            bsort(array);

            //4. display new array
            System.out.println(array);

        }


    }

