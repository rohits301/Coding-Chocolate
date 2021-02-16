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
        
        int profit  = stocksTwoTransaction(prices);
        System.out.println(profit);
    }
    private static int stocksTwoTransaction(int[] prices){
        
        // T_i11 -> First transaction ke end mein
        // T_i21 -> Second transaction ke end mein
        int T_i10 = 0;
        int T_i20 = 0;
        int T_i11 = Integer.MIN_VALUE;
        int T_i21 = Integer.MIN_VALUE;
        
        for(int val : prices){
            int temp = T_i10;
            T_i10 = Math.max(T_i10, T_i11 + val);
            T_i11 = Math.max(T_i11, - val);
            T_i20 = Math.max(T_i20, T_i21 + val);
            T_i21 = Math.max(T_i21, temp - val);
        }
        return T_i20;
    }
}