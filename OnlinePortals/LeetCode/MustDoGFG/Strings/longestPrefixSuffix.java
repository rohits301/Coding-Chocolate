// GFG
class Solution {
    int lps(String s) {
        // code here
        int[] lps = new int[s.length()];

        char[] arr = s.toCharArray();
        int i = 1;
        int len = 0;

        while (i < arr.length) {
            if (arr[i] == arr[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[lps.length - 1];
    }
}