import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf, int count, int pos) {
        // write your code here

        if (pos == str.length()) {
            // last ka decision
            if (count == 0) {
                System.out.println(asf);
            } else {
                System.out.println(asf + count);
            }
            return;
        }

        char ch = str.charAt(pos);
        // String roq = str.substring(pos + 1); // this gives error for str.length() = 1

        // YES
        if (count == 0)
            solution(str, asf + ch, 0, pos + 1);
        else
            solution(str, asf + count + ch, 0, pos + 1);

        // NO
        solution(str, asf, count + 1, pos + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "", 0, 0);
    }
}