class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int gap = 0; gap < s.length(); gap++) {

            for (int i = 0, j = gap; j < s.length(); i++, j++) {

                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && 
                        dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j]) {
                    len = gap + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}