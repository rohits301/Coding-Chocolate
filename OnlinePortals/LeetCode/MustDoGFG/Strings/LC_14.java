class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder prefix = new StringBuilder("");
        
        if(strs.length == 0){
            return prefix.toString();
        }
        
        int idx = 0;
        
        // iterate thru every char in 1st string, can take any btw
        for(int i = 0; i < strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            
            for(int j = 1; j < strs.length; j++){
                String str = strs[j];
                // if ch of 1st string doesn't match or 
                // index exceeds the length of strings in the array, Return
                if(idx >= str.length() || ch != str.charAt(idx)){
                    return prefix.toString();
                }
            }
            
            prefix.append(ch);
            idx++;
        }
        
        return prefix.toString();
    }
}