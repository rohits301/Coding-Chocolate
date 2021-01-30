import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] gold = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                gold[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][m];
        int ans = Goldmine_memo(gold, 0, 0, dp);
        System.out.println(maxGold);
        print2D(dp);
    
    }
    
    public static void print2D(int[][] arr){
        for(int[] a: arr){
            for(int val : a){
                System.out.print(val + " ");
            }
            System.out.println();
        }    
    }
    
    static int maxGold;
    public static int Goldmine_memo(int[][] gold, int sr, int sc, int[][] dp){
        
        if(sc == gold[0].length - 1){
            return dp[sr][sc] = gold[sr][sc];
        }
        
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        
        int maxt = 0;
        int maxr = 0;
        int maxd = 0;
        int vtbs = 0;
        
        
        for(; sr < gold.length; sr++){
            
            if(sr - 1 >= 0 && sc + 1 <= gold[0].length - 1)
                maxt = Goldmine_memo(gold, sr - 1, sc + 1, dp);
                
            if(sc + 1 <= gold[0].length - 1)
                maxr = Goldmine_memo(gold, sr, sc + 1, dp);
                
            if(sr + 1 <= gold.length - 1 && sc + 1 <= gold[0].length - 1)
                maxd = Goldmine_memo(gold, sr + 1, sc + 1, dp);
            
            vtbs = gold[sr][sc] + Math.max(maxt, Math.max(maxr, maxd)); // value to be stored
            maxGold = Math.max(maxGold, vtbs);
            
            dp[sr][sc] = vtbs;
        }
        
        return vtbs;
    }
    
    //* Tabulation
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int cost = Goldmine(arr);
        System.out.println(cost);
    }
    private static int Goldmine(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        
        int ans = 0;
        
        for(int j = m - 1; j >= 0; j--){
            for(int i = n - 1; i >= 0; i--){
                if(j == m - 1){
                    dp[i][j] = arr[i][j];
                } else if(i == n - 1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j+1], dp[i][j+1]);
                } else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j+1], dp[i][j+1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i + 1][j+1], Math.max(dp[i][j+1], dp[i-1][j+1]));
                }
            }
        }
    
        for(int i = 0; i < n; i++){
            ans = Math.max(dp[i][0], ans);
        }
        return ans;
    }
}