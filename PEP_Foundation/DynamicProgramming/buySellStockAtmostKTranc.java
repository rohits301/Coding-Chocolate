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
        int k = scn.nextInt();
        
        int profit  = stocksAtmostKTransactions(prices, k);
        System.out.println(profit);
    }
    private static int stocksAtmostKTransactions(int[] prices, int k){

        // here j is looping on K
        
        int ans = 0;
        if(k < prices.length / 2){
            int[] T_ik0 = new int[k + 1];
            int[] T_ik1 = new int[k + 1];
            Arrays.fill(T_ik1, Integer.MIN_VALUE);
            
            for(int val : prices){
                for(int j = k; j >= 1; j--){
                    T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + val);
                    T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - val);
                }
            }
            ans = T_ik0[k];
        }
        else { // k >= prices.length / 2
            // infinte tranc. code
            ans = stocksInfiniteTransactions(prices);
        }
        return ans;
    }
    private static int stocksInfiniteTransactions(int[] prices){
        // T[i][k][x]
        
        int T_ik0 = 0; // T[i][k][0]
        int T_ik1 = Integer.MIN_VALUE; // T[i][k][1]
        
        for(int val : prices){
            int nextT_ik0 = Math.max(T_ik0, T_ik1 + val);
            int nextT_ik1 = Math.max(T_ik1, T_ik0 - val);
            
            T_ik0 = nextT_ik0;
            T_ik1 = nextT_ik1;
        }
        return T_ik0;
    }
}