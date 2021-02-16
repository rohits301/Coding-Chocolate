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
        
        int profit  = stocksInfTransactionCooldown(prices);
        System.out.println(profit);
    }
    private static int stocksInfTransactionCooldown(int[] prices){
        int T_ik0 = 0;
        int T_ik1 = Integer.MIN_VALUE;
        int T_ik0_old = 0; // i - 2 waala
        
        for(int val : prices){
            int temp = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + val);
            T_ik1 = Math.max(T_ik1, T_ik0_old - val);
            
            T_ik0_old = temp;
        }
        return T_ik0;
    }
}