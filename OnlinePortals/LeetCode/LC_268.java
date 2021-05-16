class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;

        int nxor = 0;
        for(int i = 0; i <= n; i++){
            nxor ^= i;
        }
        
        int arrXor = 0;
        for(int i = 0; i < n; i++){
            arrXor ^= nums[i];
        }
        
        return (arrXor ^ nxor); // the missing no.
    }
    // Time: O(n)
    // Space: O(1)
}