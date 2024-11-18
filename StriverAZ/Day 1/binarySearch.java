/** Nov 18, 2024 */

class Solution {

/* Iterative */ 

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int midEl = nums[mid];
            if(target == midEl) {
                return mid;
            } else if (target > midEl) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

/* Recursive */ 
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        return bsRecursive(nums, lo, hi, target);
    }

    private int bsRecursive(int[] arr, int lo, int hi, int tar) {
        if(lo > hi) return -1;

        int mid = (lo + hi) / 2;

        if(tar == arr[mid]){
            return mid;
        } else if(tar > arr[mid]){
            return bsRecursive(arr, mid+1, hi, tar);
        } else {
            return bsRecursive(arr, lo, mid-1, tar);
        }

    }
}