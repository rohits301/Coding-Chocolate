import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        // code

        int[] ans = slidingWindowMaximum(a, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static int[] slidingWindowMaximum(int[] arr, int k) {
        // ngeR (indexes)

        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        nge[n - 1] = n;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            nge[i] = st.size() == 0 ? n : st.peek();

            st.push(i);
        }

        // sliding window max
        int j = 0;
        int[] ans = new int[n - k + 1]; // arr.length - k + 1

        for (int i = 0; i < ans.length; i++) {
            // if j is left behind, bring it back to i
            if (j < i) {
                j = i;
            }

            // if my nge is in window, jump to it
            while (nge[j] < i + k) {
                j = nge[j];
            }

            ans[i] = arr[j];
        }
        return ans;
    }
}
