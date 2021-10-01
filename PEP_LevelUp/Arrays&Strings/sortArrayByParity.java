import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~

    // T: O(n), S: O(1), passed on LeetCode
    public static void sortArrayByParity(int[] nums) {
        // similar to LL even odd

        if (nums.length == 1) {
            return;
        }

        int oi = 0; // odd-index
        int ei = 0; // even-index

        while (ei < nums.length) {

            if (nums[ei] % 2 == 0) {
                // swap
                int temp = nums[oi];
                nums[oi] = nums[ei];
                nums[ei] = temp;

                oi++;
                ei++;
            } else {
                ei++;
            }
        }

    }

    // ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}