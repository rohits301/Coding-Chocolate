import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] cost = new int[n][m];

        for(int i = 0;i < n; i++){
            for(int j = 0; j < m; j++){
                cost[i][j] = scn.nextInt();
            }
        }
        
        // int[][] qb = new int[n+1][m+1];
        // for(int[] ar : qb){
        //     Arrays.fill(ar, Integer.MAX_VALUE);
        // }
        // int minCost = minCostInMaze_Memo(cost, 0, 0, qb);
        // System.out.println(minCost);
        // print2D(qb);
    
        int minCost = minCostInMaze_Tab(cost);
        System.out.println(minCost);
    }
    
    public static void print2D(int[][] arr){
        for(int[] a: arr){
            for(int val : a){
                System.out.print(val + " ");
            }
            System.out.println();
        }    
    }
    
    public static int minCostInMaze_Memo(int[][] cost, int sr, int sc, int[][]qb){
        if(sr == cost.length - 1 && sc == cost[0].length - 1){
            qb[sr][sc] = cost[sr][sc];
            return cost[sr][sc];
        }

        if(qb[sr][sc] != Integer.MAX_VALUE){
            return qb[sr][sc];
        }
        
        int minCost = Integer.MAX_VALUE;
        int hminCost = Integer.MAX_VALUE;
        int vminCost = Integer.MAX_VALUE;
        
        if(sc + 1 <= cost[0].length - 1)
            hminCost = minCostInMaze_Memo(cost, sr, sc + 1, qb);
        if(sr + 1 <= cost.length - 1)
            vminCost = minCostInMaze_Memo(cost, sr + 1, sc, qb);

        minCost = cost[sr][sc] + Math.min(minCost, Math.min(hminCost, vminCost));
        
        qb[sr][sc] = minCost;
        return minCost;
    }

    public static int minCostInMaze_Tab(int[][] cost){
        int[][] dp = new int[cost.length][cost[0].length];
        
        for(int sr = cost.length - 1; sr >= 0; sr--){
            for(int sc = cost[0].length - 1; sc >= 0; sc--){
                if(sr == cost.length - 1 && sc == cost[0].length - 1){
                    dp[sr][sc] = cost[sr][sc];
                    continue;
                }
        
                int minCost = Integer.MAX_VALUE;
                int hminCost = Integer.MAX_VALUE;
                int vminCost = Integer.MAX_VALUE;
                
                if(sc + 1 <= cost[0].length - 1)
                    hminCost = dp[sr][sc + 1];
                if(sr + 1 <= cost.length - 1)
                    vminCost = dp[sr + 1][sc];
        
                minCost = cost[sr][sc] + Math.min(minCost, Math.min(hminCost, vminCost));
                
                dp[sr][sc] = minCost;
            }
        }
        // print2D(dp);
        
        return dp[0][0];    
    }
}