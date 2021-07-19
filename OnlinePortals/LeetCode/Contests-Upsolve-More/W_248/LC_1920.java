class Solution {
    // S: O(1), T: O(n)
    public int[] buildArray(int[] nums) {
        
        // use the trick below to preserve the array elements alongwith 
        // saving space and storing new and original array in the same array
        int n = nums.length;
        int maxPlusOne = n - 1 + 1; // here, maxPlusOne = n
        
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] + 
                maxPlusOne * ((nums[nums[i]]) % maxPlusOne);
        }
        
        // originalArr[i] = nums[i] % maxPlusOne
        // newArr[i] = nums[i] / maxPlusOne
        
        for(int i = 0; i < n; i++){
            nums[i] = nums[i] / maxPlusOne;
        }
        return nums;
    }
}