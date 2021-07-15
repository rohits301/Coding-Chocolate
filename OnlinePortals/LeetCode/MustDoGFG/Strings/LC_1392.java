class Solution {
    // T: O(n), S: O(n)
    public String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        
        char[] arr = s.toCharArray();
        int i = 1;
        int len = 0;
        
        while(i < arr.length){
            if(arr[i] == arr[len]){
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len > 0){
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        } 
        
        // for(int val : lps){
        //     System.out.print(val + " ");
        // }
        // System.out.println();
        
        if(lps[lps.length - 1] == 0){
            return "";
        } else {
            int ansLen = lps[lps.length - 1]; // lps Length
            int ei = arr.length;
            int si = (ei - 1) - ansLen + 1;
            
            return s.substring(si, ei);
        }
    }
}