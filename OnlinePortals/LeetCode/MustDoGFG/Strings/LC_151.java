class Solution {
    // T: O(n), S: O(no. of words in string)
    public String reverseWords(String s) {
        
        StringBuilder res = new StringBuilder();
        
        int i = 0;
        int n = s.length();
        
        while(i < n){
            // counting spaces
            while(i < n && s.charAt(i) == ' '){
                i++;
            }
            
            // check if string has trailing spaces, then i == length
            // and substring will give indexOutOFBoundsEXception
            if(i == n){
                break;
            }
            
            // count word length
            int j = i + 1;
            while(j < n && s.charAt(j) != ' '){
                j++;
            }
            
            String word = s.substring(i, j);
            
            if(res.length() == 0){
                res.append(word);
            } else {
                res.insert(0, word + " ");
            }
            
            i = j + 1;
        }
        return res.toString();
    }
}