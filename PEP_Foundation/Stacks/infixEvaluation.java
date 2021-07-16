import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> optors = new Stack<>();
        Stack<Integer> opnds = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                optors.push(ch);
            } else if (ch == ')') {
                while (optors.peek() != '(') {
                    char op = optors.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();

                    int res = process(op, v1, v2);
                    opnds.push(res);
                }
                optors.pop(); // pop opening bracket
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())) {

                    char op = optors.pop();
                    int v2 = opnds.pop();
                    int v1 = opnds.pop();

                    int res = process(op, v1, v2);
                    opnds.push(res);
                }
                optors.push(ch);
            } else if (Character.isDigit(ch)) {
                opnds.push(ch - '0');
            }
        }
        while (optors.size() > 0) {
            char op = optors.pop();
            int v2 = opnds.pop();
            int v1 = opnds.pop();

            int res = process(op, v1, v2);
            opnds.push(res);
        }
        System.out.println(opnds.peek());
    }

    public static int process(char ch, int v1, int v2) {
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

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}