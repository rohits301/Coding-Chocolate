import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scn.nextInt(); // width
            arr[i][1] = scn.nextInt(); // height
        }

        int ans = russianDollEnvelopes(arr);
        System.out.println(ans);
    }

    static int russianDollEnvelopes(int[][] arr) {
        int n = arr.length;

        // sort on width
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0]; // sort asc, will return -ve value, eqv. to return -1
            }
        });

        // lis on height
        int[] lis = new int[n];
        int omax = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                // for envelops to fit, height of i > height of j
                // as well as, width of i > width of j
                // since, there might be a case when both envelops have same width
                // and in that case we cannot nest them
                if (arr[i][1] > arr[j][1] && arr[i][0] > arr[j][0]) {
                    if (max < lis[j]) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;

            omax = Math.max(omax, lis[i]);
        }

        return omax;
    }

}