import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~User's Section~~~~~~~~~~~~~~~
    // T: O(n), S: O(1), passed on LeetCode
    public static int partitionDisjoint(int[] arr) {
        // write your code here

        int greater = arr[0];
        int lmax = arr[0];
        int ans = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > greater) {
                greater = arr[i];
            } else if (arr[i] < lmax) {
                ans = i;
                lmax = greater;
            }
        }

        return ans + 1;
    }

    // ~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int len = partitionDisjoint(arr);
        System.out.println(len);
    }
}