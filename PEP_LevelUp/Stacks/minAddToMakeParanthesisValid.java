import java.io.*;
import java.util.*;

public class Main {
    public static int minAddToMakeValid(String s) {

        int op = 0;
        int correction = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                op++;
            } else { // ch == ')'
                if (op > 0) {
                    op--;
                } else {
                    correction++;
                }
            }
        }
        return op + correction;
    } // T: O(n) and S: O(1)

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = minAddToMakeValid(read.readLine());
        System.out.println(result);
    }
}