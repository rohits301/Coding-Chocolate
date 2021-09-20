import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    // T: O(n) + O(q), S: O(1)
    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] arr = new int[length];

        for (int q = 0; q < queries.length; q++) {
            int si = queries[q][0]; // start index
            int ei = queries[q][1]; // ending index
            int inc = queries[q][2]; // increment

            // impact
            arr[si] += inc;
            if (ei + 1 < length) {
                arr[ei + 1] += -inc;
            }

        }

        // prefix sum
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int length = scn.nextInt();

        int nq = scn.nextInt();

        int[][] queries = new int[nq][3];

        for (int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }

        int[] res = getModifiedArray(length, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}