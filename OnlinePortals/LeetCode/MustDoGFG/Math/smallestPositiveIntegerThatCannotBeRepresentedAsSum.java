// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            long array[] = new long[n];
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextLong();
            }
            Solution ob = new Solution();
            System.out.println(ob.smallestpositive(array, n));
            t--;
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    long smallestpositive(long[] arr, int n) {
        Arrays.sort(arr);

        if (arr[0] != 1) {
            return 1;
        }

        long maxPossible = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > maxPossible + 1) {
                break;
            }

            maxPossible += arr[i];
        }
        return maxPossible + 1;
    }
}