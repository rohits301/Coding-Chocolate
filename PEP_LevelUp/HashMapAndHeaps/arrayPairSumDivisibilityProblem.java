import java.util.*;

public class Main {

    public static void solution(int[] arr, int k) {
        // write your code here
        boolean flag = true;

        // remainder frequency map
        HashMap<Integer, Integer> fmap = new HashMap<>();

        for (int val : arr) {
            int rem = val % k;

            fmap.put(rem, fmap.getOrDefault(rem, 0) + 1);
        }

        // check freq.

        for (int val : arr) {
            int rem = val % k;

            if (rem == 0) {
                int f = fmap.get(rem);
                if (f % 2 == 1) {
                    flag = false;
                    break;
                }
            } else if (2 * rem == k) { // ** to avoid odd number error
                int f = fmap.get(rem);
                if (f % 2 == 1) {
                    flag = false;
                    break;
                }
            } else {
                int f1 = fmap.get(rem);
                int f2 = fmap.getOrDefault(k - rem, 0); // ** (k-rem) may or may not be present in fmap
                if (f1 != f2) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solution(arr, k);
    }

}
