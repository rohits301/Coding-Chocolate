class Solution {
    // T: O(n) n = length of string
    // S: O(m) m = count of chars with freq = 2
    public String makeFancyString(String s) {
        
        int freq = 1;
        char prev = s.charAt(0);
        
        StringBuilder ans = new StringBuilder();
        ans.append(prev);
        
        for(int i = 1; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == prev){
                freq++;
            } else {
                prev = ch;
                freq = 1; //reset
            }
            
            if(freq < 3) ans.append(prev);
        }
        
        return ans.toString();
    }
}