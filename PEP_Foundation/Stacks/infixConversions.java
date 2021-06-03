import java.io.*;
import java.util.*;
import java.lang.Character; // I included this

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code

        infixConversions(exp);
    }

    public static void infixConversions(String str) {

        Stack<Character> optor = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                optor.push(ch);
            } else if (ch == ')') {
                while (optor.peek() != '(') {
                    process(optor, pre, post);
                }
                optor.pop(); // pop '('
            } else if (Character.isDigit(ch) || Character.isLetter(ch)) {
                pre.push(ch + "");
                post.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (optor.size() > 0 && 
                       optor.peek() != '(' && 
                       precedence(optor.peek()) >= precedence(ch)) {
                    process(optor, pre, post);
                }
                optor.push(ch); // push the operator
            }
        }

        while(optor.size() > 0){
            process(optor, pre, post);
        }

        System.out.println(post.pop());
        System.out.println(pre.pop());
    }

    private static int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        } else if(ch == '*' || ch == '/'){
            return 2;
        } else {
            return 0; // This case never comes basically
        }
    }

    private static void process(Stack<Character> optor, Stack<String> pre, Stack<String> post){   
        char operator = optor.pop();
        
        String pop1 = post.pop();
        String pop2 = post.pop();
        
        StringBuilder sb = new StringBuilder();
        sb.append(pop2).append(pop1).append(operator);
        post.push(sb.toString());

        String p1 = pre.pop();
        String p2 = pre.pop();
        
        sb = new StringBuilder();
        sb.append(operator).append(p2).append(p1);
        pre.push(sb.toString());
    }
}