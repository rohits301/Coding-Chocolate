class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        // ans = m + n - LCS
        
        // LCS
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[m][n];
        
        return m + n - lcs;
    }
}