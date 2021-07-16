import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack < Integer > value = new Stack < > ();
        Stack < String > in = new Stack < > ();
        Stack < String > post = new Stack < > ();

        for (int i = exp.length() - 1; i >= 0; i--) { // traverse from back
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                value.push(ch - '0'); 
                in.push(ch + "");
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int v1 = value.pop(); // *REMEMBER IN CASE OF PREFIX*
                int v2 = value.pop();
                int res = operation(ch, v1, v2);
                value.push(res);

                String val1 = in.pop();
                String val2 = in.pop();
                String pushval = "(" + val1 + ch + val2 + ")"; 
                in.push(pushval);

                val1 = post.pop();
                val2 = post.pop();
                pushval = val1 + val2 + ch;
                post.push(pushval);
            }
        }
        System.out.println(value.pop());
        System.out.println(in.pop());
        System.out.println(post.pop());
    }

    public static int operation(char ch, int v1, int v2) {
        if (ch == '+') {
            return v1 + v2;
        } else if (ch == '-') {
            return v1 - v2;
        } else if (ch == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}