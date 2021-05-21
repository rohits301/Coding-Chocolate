import java.io.*;
import java.util.*;

public class Main {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();

        // -1 => '('

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(-1);
            } else { 
                if (st.peek() == -1) { // st.size() > 0 is redundant
                    st.pop();
                    st.push(1);
                } else {
                    int val = 0;
                    while (st.peek() != -1) { // st.size() > 0 is redundant
                        val += st.pop();
                    }
                    st.pop(); // remove the -1
                    st.push(val * 2);
                }
            }
        }

        int val = 0; // handle '()()' case
        while (st.size() > 0) {
            val += st.pop();
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);

    }
}
