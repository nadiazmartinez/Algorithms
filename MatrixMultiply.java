import java.util.Vector;

class MatrixMultiply {
    public static Vector<Vector<Double>> matrix_multiply(Vector<Vector<Double>> inputA, Vector<Vector<Double>> inputB){
        Vector<Vector<Double>> outputC = new Vector<Vector<Double>>();

        if (inputA.elementAt(0).size() != inputB.size()) {
            System.out.print("Incompatible dimensions");
            return null;
        }

        for (int i = 0; i < inputA.size(); i++){
            Vector<Double> tempRow = new Vector<Double>();
            for(int j = 0; j < inputB.elementAt(0).size(); j++){
                Double temp = 0.0;
                for (int k = 0; k < inputA.elementAt(0).size(); k++){
                    temp += inputA.elementAt(i).elementAt(k) * inputB.elementAt(k).elementAt(j);
                }
                tempRow.addElement(temp);
            }
            outputC.addElement(tempRow);
        }

        return outputC;
    }


    public static void main(String[] args) {
	Vector<Vector<Double>> myDataA = new Vector<Vector<Double>>();
    Vector<Vector<Double>> myDataB = new Vector<Vector<Double>>();
    Vector<Vector<Double>> myDataC = new Vector<Vector<Double>>();

    Integer aCols = 8;
    Integer aRows = 11;
    Integer bCols = aRows;
    Integer bRows = aCols;

    for (int i = 0; i < aRows; i++){
        Vector<Double> tempRow = new Vector<Double>();
        for(int j = 0; j < aCols; j++){
            Double temp = (double)(i + j);
            tempRow.addElement(temp);
        }
        myDataA.addElement(tempRow);
    }
    for (int i = 0; i < bRows; i++){
        Vector<Double> tempRow = new Vector <Double>();
        for(int j = 0; j < bCols; j++){
            Double temp = (double)(i * j);
            tempRow.addElement(temp);
        }
        myDataB.addElement(tempRow);
    }
    System.out.println(myDataA);
    System.out.println(myDataB);
    myDataC = matrix_multiply(myDataA, myDataB);
    System.out.println(myDataC);

    }
}
