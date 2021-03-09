import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, int minRemovalAllowed, HashSet<String> ans) {
        // write your code here

        if (minRemovalAllowed == 0) {
            int minRemovalNow = getMin(str); // min Removal for the given string

            if (minRemovalNow == 0) {
                if (!ans.contains(str)) {
                    ans.add(str);
                    System.out.println(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            solution(left + right, minRemovalAllowed - 1, ans);
        }
    }

    public static int getMin(String str) {
        // write your code here

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else if (st.size() == 0 || st.peek() == ')') {
                st.push(ch);
            } else {
                st.pop(); // closing bracket
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int minRemovalAllowed = getMin(str);
        solution(str, minRemovalAllowed, new HashSet<>());
    }
}