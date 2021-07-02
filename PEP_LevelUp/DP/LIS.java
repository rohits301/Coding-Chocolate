import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int length = LIS(arr);
        System.out.println(length);
    }
    
    private static int LIS(int[] arr){
        int[] dp = new int[arr.length];
        
        int omax = 0;
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            
            omax = Math.max(omax, dp[i]);
        }
        
        return omax;
    }
}