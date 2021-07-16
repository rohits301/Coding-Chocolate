import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> pre = new Stack<>();
        Stack<String> in = new Stack<>();
        Stack<Integer> value = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                value.push(ch - '0');
                in.push(ch + "");
                pre.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v2 = value.pop();
                int v1 = value.pop();
                int res = operation(ch, v1, v2);

                value.push(res);

                String val2 = in.pop();
                String val1 = in.pop();
                String pushval = "(" + val1 + ch + val2 + ")";
                in.push(pushval);

                val2 = pre.pop();
                val1 = pre.pop();
                pushval = ch + val1 + val2;
                pre.push(pushval);
            }
        }

        System.out.println(value.peek());
        System.out.println(in.peek());
        System.out.println(pre.peek());
    }

    public static int operation(char ch, int v1, int v2) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else if (ch == '/') {
            return v1 / v2;
        } else {
            return 0;
        }
    }
}