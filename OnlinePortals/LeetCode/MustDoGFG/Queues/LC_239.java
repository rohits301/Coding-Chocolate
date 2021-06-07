class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        int i = 0;
        for(; i < k; i++){
            // removing smaller elements 
            // and making room for next window
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        
        for(; i < n; i++){
            ans[i-k] = nums[dq.peekFirst()];
            
            // discarding the indexes 
            // which will not be there in the next window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.removeFirst();
            }
            
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        ans[i-k] = nums[dq.peekFirst()];
        
        return ans;
    }
}