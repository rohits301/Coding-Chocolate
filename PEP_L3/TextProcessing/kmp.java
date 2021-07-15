import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String txt, String pat) {
        // write your code here

        StringBuilder sb = new StringBuilder();
        sb.append(pat + "#" + txt);

        String str = sb.toString();

        // lps
        char[] arr = (str).toCharArray();

        int[] lps = new int[arr.length];
        int i = 1;
        int len = 0; // lps[i-1] in expln

        while (i < arr.length) {
            if (arr[i] == arr[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // for(int val: lps){
        // System.out.print(val + " ");
        // }

        // kmp
        int plen = pat.length();
        for (int j = 0; j < lps.length; j++) {
            if (lps[j] == plen) {
                int startIdxInLPSArr = j - plen + 1;

                // idx in txt = startIdxInLPSArr - plen - 1;
                // subtract Length(pat + '#')
                System.out.println(startIdxInLPSArr - plen - 1);
            }
        }

        System.out.println(); // to handle empty case
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        solution(s1, s2);
    }

}