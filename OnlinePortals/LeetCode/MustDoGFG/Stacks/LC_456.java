class Solution {
    public boolean find132pattern(int[] nums) {
        int[] arr = nums;
        
        int[] min = new int[arr.length];
        
        min[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            min[i] = Math.min(min[i-1], arr[i]);
        }
        
        //Reqd. order : min < st.peek < arr[j]
        
        Stack<Integer> st = new Stack<>();
        
        boolean found = false;
        for(int j = arr.length - 1; j >= 0; j--){
            
            // (min < st.peek), removing smaller elements 
            // to find just greater than min 
            while(st.size() > 0 && st.peek() <= min[j]){
                st.pop();
            }
            
            // st.peek < arr[j]
            if(st.size() > 0 && st.peek() < arr[j]){
                found = true;
                break;
            }
            st.push(arr[j]);
        }
        
        return found;
    }
}