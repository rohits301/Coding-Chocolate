class Solution {
    public int lengthOfLIS(int[] nums) {
        // T: O(nlogn), S: O(n)
        
        ArrayList<Integer> al = new ArrayList<>();
        al.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int lastEle = al.get(al.size() - 1);
            
            if(num > lastEle){
                al.add(num);
            } else {
                // array till now is sorted
                // hence binary search for the min. idx
                // to place num in al
                
                int idx = binarySearch(num, al);
                al.set(idx, num);
            }
        }
        return al.size(); // size of LIS
    }
    private int binarySearch(int val, ArrayList<Integer> al){
        int left = 0;
        int right = al.size() - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(al.get(mid) == val){
                return mid;
            } 
            
            if (al.get(mid) < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}