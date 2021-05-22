/*
Ques: https://practice.geeksforgeeks.org/problems/nth-natural-number/1
*/

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while (t-- > 0) {
            long n = ob.nextLong();
            Solution ab = new Solution();
            long k = ab.findNth(n);
            System.out.println(k);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    long findNth(long N) {
        
        long rem = 0;
        long ans = 0;
        long p = 1;

        while(N > 0){
            
            rem = N % 9;
            ans += p * rem;
            
            p = p * 10;
            N = N / 9;
        }
        return ans;
    }
}