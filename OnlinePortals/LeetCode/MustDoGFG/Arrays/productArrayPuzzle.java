
class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        n = nums.length;
        
        // Edge Case when size = 1
        if(nums.length == 1){
            return new long[]{1};
        }
        
        // 1. right array
        long[] right = new long[n];
        long prod = 1;
        for(int i = n - 1; i >= 0; i--){
            prod *= nums[i];
            right[i] = prod;
        }
        
        // 2. left product
        long leftProduct = 1;
        
        // 3. fill the result array
        long[] res = new long[n];
        for(int i = 0; i < n - 1; i++){
            res[i] = leftProduct * right[i + 1];
            
            leftProduct *= nums[i]; // update left Product
        }
        
        res[n - 1] = leftProduct;
        return res;
	} 
} 