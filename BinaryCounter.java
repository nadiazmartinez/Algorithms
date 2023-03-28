import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner in = new Scanner(System.in);
        System.out.println("Case:");
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int a = in.nextInt();

            String binary = Integer.toBinaryString(a);
            String[] nums = {binary};

            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                //System.out.println(Arrays.toString(nums));
                if (nums[j].equals("1"))
                    count++;
            }
            System.out.println(count);
        }
    }
}