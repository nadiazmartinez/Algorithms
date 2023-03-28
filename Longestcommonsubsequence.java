import java.util.Vector;

public class Main {

    public static void print_LCS(Vector<Vector<Integer>> cInput, String xInput, String yInput, int i, int j) {

        if (i == 0 || j == 0) {
            System.out.println();
            return;
        }

        String direction = "";

        int cCurrent = cInput.elementAt(i).elementAt(j);
        int dValue = cInput.elementAt( i-1).elementAt(j-1);
        int vValue = cInput.elementAt(i-1).elementAt(j);
        int lValue = cInput.elementAt(i).elementAt(j-1);

        Character myXinputChar = xInput.charAt(i-1);
        Character myYinputChar = yInput.charAt(j-1);

        direction = "l";

        if (myXinputChar.equals(myYinputChar)) {
            direction = "d";
        }
        else if (vValue >= lValue) {
            direction = "u";
        }

        System.out.println("The direction is: " + direction);

        if (direction.equals("d")) {
            print_LCS(cInput, xInput, yInput, i - 1, j - 1);
            System.out.print(xInput.charAt(i - 1));
        }
        else if (direction.equals("u")) {
            print_LCS(cInput, xInput, yInput, i - 1, j);
        }
        else
            print_LCS(cInput, xInput, yInput, i, j - 1);
    }
    public static void main(String[] args) {

        String Xinput = "ABCBDAB";
        String Yinput = "BDCABA";

        Vector<Vector<Integer>> cTable = new Vector<Vector<Integer>>();
        for( int i = 0; i <= Xinput.length(); i++) {
            Vector<Integer> cRow = new Vector<Integer>();

            for( int j = 0; j <= Yinput.length(); j++) {
                cRow.addElement(0);
            }

            cTable.addElement(cRow);
        }

        for( int i = 1; i < cTable.size(); i++) {
            for ( int j = 1; j < cTable.elementAt(i).size(); j++) {
                Character xInputChar = Xinput.charAt(i - 1);
                Character yInputChar = Yinput.charAt(j - 1);

                if ( xInputChar.equals(yInputChar)) {
                    cTable.elementAt(i).set(j, cTable.elementAt(i-1).elementAt(j-1) + 1);
                }
                else if (cTable.elementAt(i-1).elementAt(j) >= cTable.elementAt(i).elementAt(j-1)) {
                    cTable.elementAt(i).set(j, cTable.elementAt(i-1).elementAt(j));
                }
                else {
                    cTable.elementAt(i).set(j, cTable.elementAt(i).elementAt(j-1));
                }
            }
        }
        print_LCS(cTable, Xinput, Yinput, Xinput.length(), Yinput.length());
    }
}