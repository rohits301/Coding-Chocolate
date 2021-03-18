
// { Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));
        }
    }
}// } Driver Code Ends

class Solution {
    static String max;

    public static String swap(String str, int i, int j){
        char chi = str.charAt(i);
        char chj = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);

        StringBuilder sb = new StringBuilder();
        sb.append(left).append(chj).append(middle).append(chi).append(right);

        return sb.toString();
    }


    public static void largestInKSwaps(String str, int k, int currIndex){
        
        if(k == 0){
            return ;
        }

        int maxIndex = currIndex;
        for(int i = currIndex + 1; i < str.length(); i++){
            if(str.charAt(i) > str.charAt(ci)){
                maxIndex = i;
            }
        }
        
        if(maxIndex != currIndex){
            k--;
        }
        for(int i = currIndex; i < str.length(); i++){
            if(maxIndex == i){
                str = swap(str, i, currIndex);
                if(str.compareTo(max) > 0){
                    max = str;
                }
                largestInKSwaps(str, k, currIndex + 1);
                str = swap(str, i, currIndex);
            }
        }
    }
    public static String findMaximumNum(String str, int k) {
        // code here.
        max = str;
        largestInKSwaps(str, k, 0);
        return max;
    }
}