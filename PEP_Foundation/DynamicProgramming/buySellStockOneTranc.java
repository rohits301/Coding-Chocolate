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
        
        int profit  = stocksOneTransaction(prices);
        System.out.println(profit);
    }
    private static int stocksOneTransaction(int[] prices){
        // T[i][k][x]
        
        int T_i10 = 0; // T[i][1][0]
        int T_i11 = Integer.MIN_VALUE; // T[i][1][1]
        
        for(int val : prices){
            int nextT_i10 = Math.max(T_i10, T_i11 + val);
            int nextT_i11 = Math.max(T_i11, - val);
            
            T_i10 = nextT_i10;
            T_i11 = nextT_i11;
        }
        return T_i10;
    }
}