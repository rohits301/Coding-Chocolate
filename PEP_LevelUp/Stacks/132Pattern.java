import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        boolean ans = find132pattern(arr);
        System.out.println(ans);
    }

    static boolean find132pattern(int[] arr) {

        Stack<Integer> st = new Stack<>();

        int[] min = new int[arr.length];

        min[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min[i] = Math.min(min[i - 1], arr[i]);
        }

        // Reqd. order : min < st.peek < arr[j]

        boolean found = false;
        for (int j = arr.length - 1; j >= 0; j--) {

            // (min < st.peek), removing smaller elements
            // to find just greater than min
            while (st.size() > 0 && st.peek() <= min[j]) {
                st.pop();
            }

            // st.peek < arr[j]
            if (st.size() > 0 && st.peek() < arr[j]) {
                found = true;
                break;
            }
            st.push(arr[j]);
        }

        return found;
    }
}
