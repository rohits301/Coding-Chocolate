import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // code

        // entirely new code
        // similar to sir's code

        // nse left
        Stack<Integer> st = new Stack<>();
        int[] lb = new int[arr.length];
        st.push(0);
        lb[0] = -1;

        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() > 0) {
                lb[i] = st.peek();
            } else {
                lb[i] = -1;
            }
            st.push(i);
        }

        // nse right
        st = new Stack<>();
        int[] rb = new int[arr.length];
        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() > 0) {
                rb[i] = st.peek();
            } else {
                rb[i] = arr.length;
            }
            st.push(i);
        }

        // max area
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = width * arr[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
}