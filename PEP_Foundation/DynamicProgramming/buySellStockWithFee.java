import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        
        int profit  = stocksWithFeeTransaction(prices, fee);
        System.out.println(profit);
    }
    private static int stocksWithFeeTransaction(int[] prices, int fee){
        int T_ik0 = 0;
        int T_ik1 = Integer.MIN_VALUE;
        
        for(int val : prices){
            int temp = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + val);
            T_ik1 = Math.max(T_ik1, temp - val - fee);
        }
        return T_ik0;
    }
}