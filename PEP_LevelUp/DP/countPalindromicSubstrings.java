import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s = scn.nextLine();
        
        int count = countPalidromicSubstrings(s);
        System.out.println(count);
    }
    
    static int countPalidromicSubstrings(String str){
        int count = 0;
        
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int gap = 0; gap < n; gap++){
            for(int i = 0, j = gap; j < n; i++,j++){
                
                if(gap == 0){
                    dp[i][j] = true;
                    count++;
                } else if(gap == 1){
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j) &&
                        dp[i+1][j-1] == true){
                        
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

}