public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        // Kernighan's algo to count set bits
        int counter = 0;
        
        while(n != 0){
            int rsbm = (n & -n);
            n = n - rsbm;
            counter++;
        }
        
        return counter;
    }
}