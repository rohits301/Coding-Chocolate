import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    // T: O(n), S: O(1), passed on LeetCode
    public static int[] sortedSquares(int[] nums) {
        // write your code here

        int n = nums.length;

        int i = 0; // most -ve ele
        int j = n - 1; // most +ve ele

        int[] res = new int[n];
        int idx = n - 1;

        while (i <= j) {
            int v1 = nums[i] * nums[i];
            int v2 = nums[j] * nums[j];

            if (v1 > v2) {
                res[idx] = v1;
                i++;
            } else {
                res[idx] = v2;
                j--;
            }
            idx--;
        }
        return res;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scn.nextInt();

        int[] res = sortedSquares(nums);

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}