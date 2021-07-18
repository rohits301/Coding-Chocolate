class Solution {
    public int majorityElement(int[] nums) {
        int val = potentialCanditate(nums);
        int freq = 0;
        
        boolean isPresent = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                freq++;
            }    
            
            if(freq > nums.length / 2){
                isPresent = true;
            } 
        }
        
        if(isPresent){
            return val;
        } else {
            return -1;
        }
    }
    private int potentialCanditate(int[] arr){
        int val = arr[0];
        int count = 1;
        
        for(int i = 1; i < arr.length; i++){
            if(val == arr[i]){
                // same element, increment freq.
                count++;
            } else {
                // distinct element, map it
                count--;
            }
            
            if(count == 0){
                val = arr[i]; // last value in array
                count = 1;
            }
        }
        return val;
    }
}