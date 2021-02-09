import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int[][] arr = new int[n][k];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int cost = paintHouseManyCol(arr);
        System.out.println(cost);
    }
    private static void print(int[][] a){
        for(int[] ar : a){
            for(int ele : ar){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    
    private static int paintHouseManyCol(int[][] arr){
        
        int n = arr.length;
        int k = arr[0].length;
        int[][] dp = new int[n][k];
        
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int j = 0; j < arr[0].length; j++){
            dp[0][j] = arr[0][j];
            
            if(arr[0][j] < min){
                secondMin = min;
                min = arr[0][j];
            } else if(arr[0][j] < secondMin){
                secondMin = arr[0][j];
            }
        }
        
        
        for(int i = 1; i < n; i++){
            int newMin = Integer.MAX_VALUE;
            int newSecondMin = Integer.MAX_VALUE;
            
            for(int j = 0; j < k; j++){
                if(dp[i - 1][j] != min){
                    dp[i][j] = arr[i][j] + min;
                } else {
                    dp[i][j] = arr[i][j] + secondMin;
                }
                
                if(dp[i][j] < newMin){
                    newSecondMin = newMin;
                    newMin = dp[i][j];
                } else if(dp[i][j] < newSecondMin){
                    newSecondMin = dp[i][j];
                }
                
            }
            min = newMin;
            secondMin = newSecondMin;
        }
        // print(dp);
        return min;
    }  
}