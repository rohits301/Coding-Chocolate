import java.io.*;
import java.util.*;

public class Main {

    private static boolean isPali(String s) {
        if (s.length() == 1) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void solution(String str, String asf) {
        // write you code here
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);

            if (isPali(prefix)) {
                solution(str.substring(i + 1), asf + "(" + prefix + ") ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }

}