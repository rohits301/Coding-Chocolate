import java.io.*;
import java.util.*;

public class Main {

    public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssf,
            ArrayList<ArrayList<Integer>> ans) {
        // write your code here

        // n = arr.length
        if (vidx == n) {
            if (ssf == k) {
                boolean flag = true;

                for (int i = 0; i < subsetSum.length - 1; i++) {
                    if (subsetSum[i] != subsetSum[i + 1]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (ArrayList<Integer> subset : ans) {
                        System.out.print(subset + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            // existing set
            if (ans.get(j).size() > 0) {
                ans.get(j).add(arr[vidx]);
                subsetSum[j] += arr[vidx];

                solution(arr, vidx + 1, n, k, subsetSum, ssf, ans);

                subsetSum[j] -= arr[vidx];
                ans.get(j).remove(ans.get(j).size() - 1);
            } else { // new set

                ans.get(j).add(arr[vidx]);
                subsetSum[j] += arr[vidx];

                solution(arr, vidx + 1, n, k, subsetSum, ssf + 1, ans);

                subsetSum[j] -= arr[vidx];
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        // if k is equal to 1, then whole array is your answer
        if (k == 1) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println("]");
            return;
        }
        // if there are more subsets than no. of elements in array or sum of all
        // elements is not divisible by k
        if (k > n || sum % k != 0) {
            System.out.println("-1");
            return;
        }
        int[] subsetSum = new int[k];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        solution(arr, 0, n, k, subsetSum, 0, ans);
    }
}