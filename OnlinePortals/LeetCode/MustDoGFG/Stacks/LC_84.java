class Solution {
    public int largestRectangleArea(int[] heights) {
        
        // right boundary
        int[] rb = new int[heights.length]; // nse on right
        Stack<Integer> st = new Stack<>();
        
        st.push(heights.length - 1); // left to right
        rb[heights.length - 1] = heights.length;
        for(int i = heights.length - 2; i >= 0; i--){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                rb[i] = heights.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }
        
        // left boundary
        int[] lb = new int[heights.length]; // nse on left   
        st = new Stack<>();
        
        st.push(0); // right to left
        
        lb[0] = -1;
        for(int i = 1; i < heights.length; i++){
            while(st.size() > 0 && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }
        
        // area
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int width = rb[i] - lb[i] - 1;
            int area = width * heights[i];
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}