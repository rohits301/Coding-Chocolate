class Solution {
    public int lengthOfLIS(int[] nums) {
        // T: O(n2), S: O(n)
        
        int[] dp = new int[nums.length];

        int omax = 0;
        for(int i = 0; i < dp.length; i++){
            int max = 0;

            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;

            omax = Math.max(omax, dp[i]);
        }

        return omax;
    }
}