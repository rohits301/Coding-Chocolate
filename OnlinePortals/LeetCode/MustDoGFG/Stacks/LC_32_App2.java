class Solution {
    public int longestValidParentheses(String s) {
        
        int open = 0, close = 0;
        
        int n = s.length();
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            } else {
                close++;
            }
            
            if(open == close){
                ans = Math.max(ans, 2 * open);
            } else if(close > open){
                open = close = 0; // reset
            }
        }
        
        open = close = 0; // reset
        
        for(int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            } else {
                close++;
            }
            
            if(open == close){
                ans = Math.max(ans, 2 * open);
            } else if(open > close){
                open = close = 0; // reset
            }
        }
        
        return ans;
    }
}