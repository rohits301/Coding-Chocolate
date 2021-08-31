import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = scn.nextInt();
        }
        
        int maxSum = maxSumIncSubseq(arr);
        System.out.println(maxSum);
    }
    
    private static int maxSumIncSubseq(int[] arr){
        int omax = Integer.MIN_VALUE;
        
        int n = arr.length;
        int[] dp = new int[n]; // stores sum of max inc. subseq.
        
        for(int i = 0; i < n; i++){
            int max = Integer.MIN_VALUE;
            
            for(int j = 0; j < i; j++){
                if(arr[i] >= arr[j]){
                    if(max == Integer.MIN_VALUE){
                        max = dp[j]; // first element
                    } else if (dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            if(max == Integer.MIN_VALUE){
                dp[i] = arr[i]; // start new subseq.
            } else {
                dp[i] = max + arr[i];
            }
            
            omax = Math.max(dp[i], omax);
        }
        
        // for(int val : dp){
        //     System.out.print(val + " ");
        // }
        // System.out.println();
        return omax;
    }

}