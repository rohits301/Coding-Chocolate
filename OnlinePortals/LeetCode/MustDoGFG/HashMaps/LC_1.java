class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        Approach 1: O(n2) - brute force
        Approach 2: O(nlogn) + O(n) - Sort and use two pointer
        Approach 3: O(n) space and time - use map & search for tar - nums[i]
        Approach 4: better O(n) - only 1 pass in Approach 3 
        */
        
        // Approach 4
        
        // put nums[i] in map with index
        // since unique solution we can put value as key of map
        // *HANDLES duplicate number cases since,
        // we never add the first one in the map* 
        // -> eg. [3,2,3], target = 6
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        
        return ans;
    }
}