// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            Vector<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(Vector<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    final static int m = 1000000007;
    final static long oneInLong = 1 % m;
    Vector<Long> nthRowOfPascalTriangle(int n) {
        // code here
        
        // base case
        if(n == 1){
            Vector<Long> base = new Vector<>();
            base.add(oneInLong);
            return base;
        }
        
        // pre order
        Vector<Long> currRow = new Vector<>();
        currRow.add(oneInLong); // adding 1 in the beginning
        
        Vector<Long> prevRow = nthRowOfPascalTriangle(n - 1);
        
        // post order
        for(int i = 1; i < prevRow.size(); i++){
            
            long val = (prevRow.get(i - 1) % m + + prevRow.get(i) % m) % m;
            currRow.add(val);
        }
        currRow.add(oneInLong); // adding 1 at last
        
        return currRow;
    }
}