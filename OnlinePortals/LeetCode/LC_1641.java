class Solution {
    public int countVowelStrings(int n) {
        
        // T: O(n), S: O(1)
        
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        
        while(n > 1){
            
            // add new char before previous string
            
            a = a + e + i + o + u; 
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
            
            n--;
        }
        
        return (a + e + i + o + u); // total 
    }
}