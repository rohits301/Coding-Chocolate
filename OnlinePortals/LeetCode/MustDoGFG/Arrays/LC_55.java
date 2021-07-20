class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReachableIdx = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(maxReachableIdx < i){
                return false;
            }
            
            maxReachableIdx = Math.max(maxReachableIdx, i + nums[i]);
        }
        return true;
    }
}