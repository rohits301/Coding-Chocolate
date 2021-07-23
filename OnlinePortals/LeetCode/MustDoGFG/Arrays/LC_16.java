class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        // if minDiff == 0, break, target is achieved, closest sum = target
        for(int i = 0; i <= n - 3 && minDiff != 0; i++){
            int left = i + 1;
            int right = n - 1;
            
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int diff = target - sum;
                if(Math.abs(diff) < Math.abs(minDiff)){
                    minDiff = diff;
                    // System.out.println(minDiff);
                }
                
                if(sum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - minDiff; // the closest sum achieved
    }
}