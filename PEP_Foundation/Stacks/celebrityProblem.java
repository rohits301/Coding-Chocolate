import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"

        Stack<Integer> st = new Stack<>();

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() >= 2) {
            int i = st.pop();
            int j = st.pop();

            if (arr[i][j] == 1) {
                // i knows j
                st.push(j);
            } else {
                // i doesn't know j
                st.push(i);
            }
        }

        int potential = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != potential) {
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potential);
    }

}