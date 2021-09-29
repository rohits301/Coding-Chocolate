import java.util.*;

public class Main {
    // ~~~~~~~~~~~~User Section~~~~~~~~~~~

    // GFG Ques link:
    // https://www.geeksforgeeks.org/find-the-number-of-jumps-to-reach-x-in-the-number-line-from-zero/

    // T: O(sqrt(x)), S: O(1)
    public static int minJumps(int x) {
        // Write your code here

        // for negative numbers, just make positive and proceed
        if (x < 0) {
            x = -x;
        }

        int jump = 1; // jump size I'm about to take
        int sum = 0;

        while (sum < x) {
            sum += jump;
            jump++;
        }

        if ((sum - x) % 2 == 0) { // even
            return jump - 1;
        } else if ((sum + jump - x) % 2 == 0) { // odd but taking next jump, makes it even
            return jump;
        } else { // odd even after extra jump, hence take 1 more
            return jump + 1;
        }
    }

    // ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();

        int jumps = minJumps(x);
        System.out.println(jumps);
    }
}