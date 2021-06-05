class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] arr = heights;
        Stack<Integer> st = new Stack<>();
        
        st.push(-1);
        int maxArea = 0;
        
        // loop till i <= len
        for(int i = 0; i <= arr.length; i++){
            int val = i == arr.length? 0 : arr[i]; // to handle remaining elements case
            
            // nse left basically
            while(st.peek() != -1 && val <= arr[st.peek()]){
                int rm = i;
                int h = arr[st.pop()];
                int lm = st.peek();
                
                int w = rm - lm - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            st.push(i);
        }
        return maxArea;
    }
}