class Solution {
    // T: O(n), S: O(n) - for right Array
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // 1. Make right array
        int[] right = new int[n];
        int prod = 1;
        for(int i = n - 1; i >= 0; i--){
            prod *= nums[i];
            right[i] = prod;
        }
        
        // 2. Initialise left product
        int leftProduct = 1;
        
        // 3. Fill the result array
        int[] res = new int[n];
        for(int i = 0; i < n - 1; i++){
            res[i] = leftProduct * right[i + 1];
            
            leftProduct *= nums[i]; // update left Product
        }
        
        res[n - 1] = leftProduct;
        return res;
    }
}