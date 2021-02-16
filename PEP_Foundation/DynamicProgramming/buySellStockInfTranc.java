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
        
        int profit  = stocksInfiniteTransactions(prices);
        System.out.println(profit);
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