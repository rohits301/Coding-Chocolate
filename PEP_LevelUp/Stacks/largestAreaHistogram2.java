import java.io.*;
import java.util.*;

public class Main {
    public static int largestRectangleArea(int[] heights) {
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

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));
        
    }
}
