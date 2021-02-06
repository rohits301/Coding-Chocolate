import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner (System.in);
        String str = scn.next();
        
        int ans = countEncodings(str);
        System.out.println(ans);
    }
    private static int countEncodings(String str){
        int[] dp = new int[str.length()];
        
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i++){
            char chi = str.charAt(i);
            char chim1 = str.charAt(i - 1);
            
            if(chim1 == '0' && chi == '0'){
                dp[i] = 0;
            } else if (chim1 == '0' && chi != '0'){
                dp[i] = dp[i - 1];
            } else if (chim1 != '0' && chi == '0'){
                if(chim1 == '1' || chim1 == '2'){
                    dp[i] = (i >= 2? dp[i - 2] : 1);
                } else {
                    dp[i] = 0;
                }
            } else {
                int lastTwo = Integer.parseInt(str.substring(i - 1, i + 1));
                if(lastTwo <= 26){
                    dp[i] = dp[i-1] + (i >= 2? dp[i - 2] : 1); // both calls
                } else {
                    dp[i] = dp[i - 1]; // single waali call
                }
            }
        }
        return dp[str.length() - 1];
    }
}