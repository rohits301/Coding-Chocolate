class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        if(k == 0){
            return;
        }
        
        k = k % n;
        
        // reverse P1
        reverse(nums, 0, n - 1 - k);
        // reverse P2
        reverse(nums, n - k, n - 1);
        // full array reverse
        reverse(nums, 0, n - 1);
    }
    
    private void reverse(int[] nums, int li, int ri){
        // li = left index
        // ri = right index
        
        while(li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;
            
            li++;
            ri--;
        }
    }
}