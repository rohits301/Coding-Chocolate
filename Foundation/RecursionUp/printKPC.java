import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        
        printKPC(str, "");
    }

    public static void printKPC(String ques, String ans) {
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        
        char ch = ques.charAt(0);
        String code = codes(ch-'0');
        String ros = ques.substring(1);
        
        for(int i=0; i<code.length(); i++){
            printKPC(ros, ans + code.charAt(i));
        }
    }
    
    private static String codes(int ch){
        String[] code = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        return code[ch];
    }

}