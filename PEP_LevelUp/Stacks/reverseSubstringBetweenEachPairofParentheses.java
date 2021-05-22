import java.io.*;
import java.util.*;

public class Main {
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                ArrayDeque<Character> que = new ArrayDeque<>();
                while(st.peek() != '('){
                    char ch = st.pop();
                    que.add(ch);
                }              
                st.pop(); // opening bracket
                while(que.size() > 0){
                    st.push(que.remove());
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        
        char[] charray = new char[st.size()];
        int i = charray.length - 1;
        
        while(i >= 0){
            charray[i] = st.pop();
            i--;
        }
        
        return new String(charray);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
