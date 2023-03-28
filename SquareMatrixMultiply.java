import java.util.Vector;

class SquareMatrixMultiply{
    public static Vector<Vector<Double>> square_matrix_multiply(Vector<Vector<Double>> inputA, Vector<Vector<Double>> inputB) {
        //my code here

        //line 1
        int n = inputA.size();

        //line 2 C = n * n matrix
        Vector<Vector<Double>> C = new Vector<Vector<Double>>();
        for(int i = 0; i < n; i++) {
            Vector<Double> tempRow = new Vector<Double>();
            for(int j = 0; j < n; j++){
                tempRow.addElement(0.0);
            }
            C.addElement(tempRow);
        }


        //lines 3-7
        for (int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                for(int k = 1; k < n; k++){
                    //C[i][j] += inputA[i][k] * inputB[k][j]
                    C.elementAt(i).set(j, C.elementAt(i).elementAt(j) + inputA.elementAt(i).elementAt(k) * inputB.elementAt(k).elementAt(j));
                }
            }
        }
        return C;
    }

    public static void main(String[] args){
        Vector<Vector<Double>> myDataA = new Vector<Vector<Double>>();
        Vector<Vector<Double>> myDataB = new Vector<Vector<Double>>();
        Vector<Vector<Double>> myDataC = new Vector<Vector<Double>>();

        Integer n = 31;

        for(int i = 0; i < n; i++){
            Vector<Double> tempRow = new Vector<Double>();
            for(int j = 0; j < n; j++){
                Double temp = (double)(i + j);
                tempRow.addElement(temp);
            }
            myDataA.addElement(tempRow);
        }
        for (int i = 0; i < n; i++){
            Vector<Double> tempRow = new Vector<Double>();
            for(int j = 0; j < n; j++){
                Double temp = (double)(i + j);
                tempRow.addElement(temp);
            }
            myDataB.addElement(tempRow);
        }
        System.out.println(myDataA);
        System.out.println(myDataB);
        myDataC = square_matrix_multiply(myDataA, myDataB);
        System.out.println(myDataC);
    }
}
