class Solution {
    // nums1 => query 
    // nums2 => nums
    public static int[] nextGreaterElement(int[] query, int[] nums) {

        int[] nger = ngeRight(nums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            int val = nger[i];

            map.put(key, val);
        }

        int[] response = new int[query.length];
        for(int i = 0; i < query.length; i++){
            response[i] = map.get(query[i]);
        }

        return response;
    }
    
    // element waala nge
    public static int[] ngeRight(int[] arr){
        
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        nge[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        
        for(int i = arr.length - 2; i >= 0; i--){
            while(st.size() > 0 && st.peek() <= arr[i]){
                st.pop();
            }
            
            if(st.size() == 0){
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }
            
            st.push(arr[i]);    
        }
        return nge;   
    }
}